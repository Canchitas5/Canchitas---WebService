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
@Table(name = "persons")
public class Person extends User {
    private String name;
    private String lastName;
    private String dni;
    private String phone;
    private String birthDate;

    private String PicProfile;


    public Person( Long id,  String email, String password, String typeUser, String name, String lastName, String dni, String phone, String birthDate, String PicProfile) {
        super(id, email, password, typeUser);
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.birthDate = birthDate;
        this.PicProfile = PicProfile;
    }
}
