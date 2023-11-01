package org.application;

import java.util.Set;

public interface Workers {

    Set<User> userList();

    void saveUserToFile(Set<User> users) throws Exception;

}
