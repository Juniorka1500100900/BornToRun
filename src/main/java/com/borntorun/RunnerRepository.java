package com.borntorun;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RunnerRepository extends JpaRepository<Runner, Long> {

    List<Runner> findByName(String name);

    Optional<Runner> findByEmail(String email);

    List<Runner> findByAge(int age);

    List<Runner> findByActive(boolean active);

    List<Runner> findByGender(String gender);

    @Query("SELECT AVG(r.age) FROM Runner r")
    double calculateAverageAge();

    @Query("SELECT r FROM Runner r ORDER BY r.age DESC")
    Runner findOldestRunner();

    @Query("SELECT r FROM Runner r ORDER BY r.age ASC")
    Runner findYoungestRunner();
    @Query("SELECT r FROM Runner r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Runner> search(String keyword);

    @Query("SELECT r FROM Runner r ORDER BY r.age DESC")
    List<Runner> findTopNRunners(int topCount);
}
