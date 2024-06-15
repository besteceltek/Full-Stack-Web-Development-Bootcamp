package com.beste.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", unique = true, nullable = false)
    private Long authorId;

    @Column(name = "author_name", length = 100, nullable = false)
    private String authorName;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
