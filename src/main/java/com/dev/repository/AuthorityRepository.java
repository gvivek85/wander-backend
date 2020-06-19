package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
