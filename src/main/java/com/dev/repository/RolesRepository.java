package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

	List<Roles> findByName(String roleName);
}
