package com.igor.msbook.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book", schema = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 180)
    private String author;
    @Column(name = "launch_date", nullable = false)
    private LocalDateTime launchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String title;
    @Transient
    private String currency;
}
