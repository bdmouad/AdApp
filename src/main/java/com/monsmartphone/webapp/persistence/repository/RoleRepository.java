package com.monsmartphone.webapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
