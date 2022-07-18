package com.example.backend.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    Optional<User> findUserByName(String name);
    Optional<User> findUserByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);


}
