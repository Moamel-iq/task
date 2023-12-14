package com.task.users.dao;

import com.task.users.entity.User;

import java.util.List;
import java.util.Optional;

////Moamel
public interface UserDao {

    List<User> getAllUsers();
    Optional<User> findById(Long id);

    void createUser(User user);
    void updateUser(User user);

    void deleteUser(Long id);

    Boolean existsUserWithEmail(String email);
    Boolean existsUserWithPhone(String phone);



}
