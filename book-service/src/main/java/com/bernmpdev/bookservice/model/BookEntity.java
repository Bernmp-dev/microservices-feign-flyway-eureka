package com.bernmpdev.bookservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "Book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String title;

    @Column(nullable = false, length = 180)
    private String author;

    @Column( name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(nullable = false)
    private Double price;

    @Transient
    private String currency;

    @Transient
    private String environment;

}
