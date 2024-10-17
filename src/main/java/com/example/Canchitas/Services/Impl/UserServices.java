package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.User;
import com.example.Canchitas.Repositores.UserRepository;
import com.example.Canchitas.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements UserService {

    private final UserRepository usersRepository;

    public UserServices(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public User findByEmail(String email) throws Exception {
        return usersRepository.findByEmail(email);
    }
    @Override
    public List<User> findByRole(String role) throws Exception {
        return usersRepository.findByRole(role);
    }

    @Override
    public User save(User user) throws Exception {
        return usersRepository.save(user);
    }

    @Override
    public void delete(Long id) throws Exception {
        usersRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) throws Exception {
        return usersRepository.findById(id);
    }
}
