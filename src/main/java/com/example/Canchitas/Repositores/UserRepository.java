package com.example.Canchitas.Repositores;

import com.example.Canchitas.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email) throws Exception;
    List<User> findByTypeUser(String typeUser) throws Exception;
}
