package com.example.Canchitas.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, columnDefinition = "LONGTEXT") //Must be LongTEXT
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "LONGTEXT") //Must be LongTEXT
    private String password;

    @Column(name = "type_user", nullable = false) //Must be LongTEXT
    private String typeUser;
}
