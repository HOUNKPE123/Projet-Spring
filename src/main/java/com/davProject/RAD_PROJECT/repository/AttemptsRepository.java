package com.davProject.RAD_PROJECT.repository;

import java.util.Optional;

import com.davProject.RAD_PROJECT.entity.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Integer> {
    Optional<Attempts> findAttemptsByUsername(String username);
}