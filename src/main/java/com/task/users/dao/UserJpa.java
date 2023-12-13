package com.task.users.dao;

import com.task.users.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

////Moamel
@Repository("userJpa")
public class UserJpa implements UserDao{
    private final UserRepository userRepository;

    public UserJpa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void createUser(User user ) {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
