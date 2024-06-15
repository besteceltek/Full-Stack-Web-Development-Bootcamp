package com.beste.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "borrow")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "borrow_name", length = 100, nullable = false)
    private String name;

    @Column(name = "borrow_email", nullable = false)
    private String email;

    @Column(name = "borrow_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate borrowDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrow_book_id", referencedColumnName = "book_id")
    private Book book;
}
