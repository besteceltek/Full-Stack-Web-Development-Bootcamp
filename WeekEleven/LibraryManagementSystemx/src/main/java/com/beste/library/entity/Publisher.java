package com.beste.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", unique = true, nullable = false)
    private Long publisherId;

    @Column(name = "publisher_name", length = 100, nullable = false)
    private String publisherName;

    @Column(name = "establishment_year", nullable = false)
    private Integer establishmentYear;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
