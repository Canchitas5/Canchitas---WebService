package com.example.Canchitas.Repositores;

import com.example.Canchitas.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email) throws Exception;
    List<User> findByFirstName(String firstName) throws Exception;
    List<User> findByRole(String role) throws Exception;
}
