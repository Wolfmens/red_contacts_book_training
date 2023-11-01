package org.application;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import static java.nio.file.Files.readAllLines;

public class InitialFileBase implements Workers {

    @Value("${app.init}")
    private String path;

    @Override
    public Set<User> userList() {
        try {
            Set<User> set = getTransformationUserList();
            return set;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUserToFile(Set<User> users) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter(path, true));
        Set<String> list = getUserSetFromFile();
        for (User user : users) {
            String userValues = user.getFullName() + user.getPhoneNumber() +
                    user.getEmail().substring(0, user.getEmail().length() - 1);
            if (!list.contains(userValues)) {
                writer.write(userValues + "\n");
            }
        }
        System.out.println(Constants.SUCCESSFUL_SAVE);
        writer.flush();
    }

    private Set<User> getTransformationUserList() throws Exception{
        Set<String> list = getUserSetFromFile();
        if (list.isEmpty()) {
            return new HashSet<>();
        }
        Set<User> userList = new HashSet<>();
        for(String stringValues : list) {
            String[] valuesElements = stringValues.split(";");
            String name = valuesElements[0] + ';';
            String phone = valuesElements[1] + ';';
            String email = valuesElements[2] + '.';
            userList.add(new User(name,phone,email));
        }
        return userList;
    }

    private Set<String> getUserSetFromFile() throws Exception{
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
       return new HashSet<>(readAllLines(file.toPath()));
    }
}
