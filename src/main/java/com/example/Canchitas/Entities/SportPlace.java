package com.example.Canchitas.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "sport_places")
public class SportPlace {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "LONGTEXT")
    private String name;
    @Column(name = "coordinates", nullable = false, columnDefinition = "LONGTEXT")
    private String coordinates;
    @Column(name = "image", nullable = false, columnDefinition = "LONGTEXT")
    private String image;
    @Column(name = "description", nullable = false, columnDefinition = "LONGTEXT")
    private String description;


    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;


}
