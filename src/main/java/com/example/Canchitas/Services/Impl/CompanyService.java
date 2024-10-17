package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.Company;
import com.example.Canchitas.Repositores.CompanyRepository;
import com.example.Canchitas.Services.CompanyServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServices {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) throws Exception {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Long id) throws Exception {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAll() throws Exception {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getById(Long id) throws Exception {
        return companyRepository.findById(id);
    }
}
