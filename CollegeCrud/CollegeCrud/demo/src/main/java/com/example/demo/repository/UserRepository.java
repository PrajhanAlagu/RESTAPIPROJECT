package com.example.demo.repository;

import com.example.demo.entity.User;

import org.springframework.lang.NonNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findUserById(@NonNull Long id);
    
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.id = :id")
    boolean existsById(@NonNull Long id);

    @Query("DELETE FROM User u WHERE u.id = :id")
    void deleteUserById(@NonNull Long id);

}