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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @Column(name = "address", nullable = false, columnDefinition = "LONGTEXT")
    private String address;
    @Column(name = "capacity", nullable = false)
    private int capacity;
    @Column(name = "place_size", nullable = false)
    private int placeSize;
    @Column(name = "sport_type", nullable = false)
    private String sportType;



    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;


}
