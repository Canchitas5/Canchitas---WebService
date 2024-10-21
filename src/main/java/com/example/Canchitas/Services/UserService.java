package com.example.Canchitas.Services;

import com.example.Canchitas.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends CrudService<User> {
    Optional<User> findByEmail(String email) throws Exception;
    List<User> findByTypeUser(String typeUser) throws Exception;




}
