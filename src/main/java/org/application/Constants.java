package org.application;

public interface Constants {

    String ADD = "A";
    String REMOVE = "R";
    String SAVE = "S";
    String EXIT = "E";
    String LIST = "L";

    String GREETINGS = "Добро пожаловать в \"Красную контактную книгу\"";

    String WHICH_COMMAND =
            "\n" + LIST + " - показать список добавленных контактов\n" +
            ADD + " - добавить контакт\n" +
            REMOVE + " - удалить контакт по Email\n" +
            SAVE + " - сохранить добавленные контакты в файл\n" +
            EXIT + " - выйти из книги контактов\n";

    String ADD_VALUES = "Введите данные (в формате Иванов Иван Иванович; +890999999; someEmail@example.example.)\n";
    String SUCCESSFUL_ADD = " успешно добавлен";

    String REMOVE_USER = "Введите данные (в формате someEmail@example.example.)\n";
    String SUCCESSFUL_REMOVAL = " успешно удален";
    String UNSUCCESSFUL_DELETION = "пользователь с таким Email не найден или данные введены не корректно, " +
            "попробуйте еще раз";

    String REGEX_FOR_CHECK_VALUES = "[A-Za-zА-Яа-я]+\\s[A-Za-zА-Яа-я]+\\s[A-Za-zА-Яа-я]+;" +
            "\\s\\+[0-9]+;" +
            "\\s[A-Za-zА-Яа-я0-9]+@[A-Za-zА-Яа-я]+\\.[A-Za-zА-Яа-я]+\\.";

    String INCORRECT_VALUES_ADDED = "Некорректно введенные данные, введите согласно шаблону";

    String ERROR_SAVE_FUNCTION = "Функция сохранения в файл не работает, поменяйте свойства приложения";
    String SUCCESSFUL_SAVE = "Контакты успешно сохранены";
}
