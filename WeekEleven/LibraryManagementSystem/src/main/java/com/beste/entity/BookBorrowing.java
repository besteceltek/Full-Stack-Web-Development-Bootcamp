package com.beste.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id", unique = true, nullable = false)
    private Integer borrowId;

    @Column(name = "borrow_name", length = 100, nullable = false)
    private String borrowName;

    @Column(name = "borrow_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate borrowDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrow_book_id", referencedColumnName = "book_id")
    private Book book;

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "borrowId=" + borrowId +
                ", borrowName='" + borrowName + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                '}';
    }

    // Getter & Setter


    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
