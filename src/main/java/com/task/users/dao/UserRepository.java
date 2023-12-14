package com.task.users.dao;

import com.task.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
////Moamel
public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);
    Boolean existsByPhone(String phone);
}
