package com.davProject.RAD_PROJECT.repository;

import java.util.Optional;

import com.davProject.RAD_PROJECT.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findUserByUsername(String username);
}