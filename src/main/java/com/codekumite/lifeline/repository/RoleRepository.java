package com.codekumite.lifeline.repository;

import com.codekumite.lifeline.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}