package org.application;

import java.util.HashSet;
import java.util.Set;

public class InitialRegularBase implements Workers {

    @Override
    public Set<User> userList() {
        return new HashSet<>();
    }

    @Override
    public void saveUserToFile(Set<User> users) {
        System.out.println(Constants.ERROR_SAVE_FUNCTION);
    }

}
