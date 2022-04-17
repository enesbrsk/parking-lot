package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);
}
