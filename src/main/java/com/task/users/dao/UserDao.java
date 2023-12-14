package com.task.users.dao;

import com.task.users.entity.User;

import java.util.List;
import java.util.Optional;

////Moamel
public interface UserDao {

    List<User> getAllUsers();
    Optional<User> getUser(Long id);

    void createUser(User user);
    void updateUser(User user);

    void deleteUser(Long id);

    boolean existsUserWithEmail(String email);
    boolean existsUserWithPhone(String phone);



}
