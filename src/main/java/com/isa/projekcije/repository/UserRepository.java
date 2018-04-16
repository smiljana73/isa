package com.isa.projekcije.repository;

import com.isa.projekcije.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    Optional<User> findById(Long id);




}
