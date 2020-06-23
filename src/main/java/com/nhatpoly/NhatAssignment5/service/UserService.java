package com.nhatpoly.NhatAssignment5.service;


import com.nhatpoly.NhatAssignment5.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
   User findUserById(Long id);
    void saveUser(User user);

    void deleteUser(Long id);


}
