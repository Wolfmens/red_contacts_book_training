package org.application;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Scanner;
import java.util.Set;

@Component
public class WorkerWithBook {

    private Set<User> userList;
    private final Scanner scanner;
    private final Workers initialBase;

    public WorkerWithBook(Set<User> userList, Workers initialFileBase) {
        this.userList = userList;
        this.initialBase = initialFileBase;
        scanner = new Scanner(System.in);
    }

    public void startWork() {
        System.out.println(Constants.GREETINGS);
        while (true) {
            System.out.println(Constants.WHICH_COMMAND);
            String command = scanner.nextLine().strip().toUpperCase();
            if (command.equals(Constants.EXIT)) {
                break;
            }
            if (!Constants.COMMANDS.contains(command)) {
                System.out.println(Constants.INCORRECT_COMMAND);
                continue;
            }
            switch (command) {
                case Constants.ADD -> addUserToList();
                case Constants.LIST -> showAddedContacts();
                case Constants.REMOVE -> removeUser();
                case Constants.SAVE -> saveUserToFile();
            }
        }
    }

    private void removeUser() {
        System.out.println(Constants.REMOVE_USER);
        String email = scanner.nextLine().strip();
        User user = userList.stream().filter(u -> u.getEmail().equals(email)).findAny().orElse(null);
        if (user != null) {
            userList.remove(user);
            System.out.println(user.getFullName() + Constants.SUCCESSFUL_REMOVAL);
        } else {
            System.out.println(Constants.UNSUCCESSFUL_DELETION);
        }
    }

    private void showAddedContacts() {
        userList.forEach(System.out::println);
    }

    private void addUserToList() {
        System.out.println(Constants.ADD_VALUES);
        String inputValues = scanner.nextLine().strip();
        if (!inputValues.matches(Constants.REGEX_FOR_CHECK_VALUES)) {
            System.out.println(Constants.INCORRECT_VALUES_ADDED);
        } else {
            String[] userProperties = inputValues.split(";\\s");
            String fullName = (userProperties[0] + ';').strip();
            String phoneNumber = (userProperties[1] + ';').strip();
            String email = (userProperties[2]).strip();
            User user = new User(fullName, phoneNumber, email);
            userList.add(user);
            System.out.println(user.getFullName() + Constants.SUCCESSFUL_ADD);
        }
    }

    private void saveUserToFile() {
        try {
            initialBase.saveUserToFile(userList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Приложение закрывается ...");
    }
}
