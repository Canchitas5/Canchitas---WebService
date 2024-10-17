package com.example.Canchitas.Services;

import com.example.Canchitas.Entities.User;

import java.util.List;

public interface UserService extends CrudService<User> {
    User findByEmail(String email) throws Exception;
    List<User> findByFirstName(String firstName) throws Exception;
    List<User> findByRole(String role) throws Exception;
}
