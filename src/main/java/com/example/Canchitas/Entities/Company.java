package com.example.Canchitas.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "company")
public class Company extends User {
    private String companyName;
    private String RUC;
    private String phone;
    private String PicProfile;

    public Company(Long id, String email, String password, String typeUser, String companyName, String RUC, String phone, String PicProfile) {
        super(id, email, password, typeUser);
        this.companyName = companyName;
        this.RUC = RUC;
        this.phone = phone;
        this.PicProfile = PicProfile;
    }
}
