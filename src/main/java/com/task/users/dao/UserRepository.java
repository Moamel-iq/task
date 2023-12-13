package com.task.users.dao;

import com.task.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
////Moamel
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
