package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
