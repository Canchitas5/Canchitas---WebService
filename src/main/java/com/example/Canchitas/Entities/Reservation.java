package com.example.Canchitas.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "reservation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "day", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String day;
    @Column(name = "time_start", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private String timeStart;
    @Column(name = "time_end", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private String timeEnd;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "status", nullable = false)
    private String status;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportPlace_id", nullable = false)
    private SportPlace sportPlace;
}
