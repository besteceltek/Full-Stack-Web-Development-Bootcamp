package com.beste.library.repository;

import com.beste.library.dto.request.BookRequest;
import com.beste.library.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {
    Optional<BookBorrowing> findByNameAndBorrowDateAndReturnDate(String name, LocalDate borrowDate, LocalDate returnDate);

    Optional<BookBorrowing> findByEmailAndBorrowDateAndBook(String email, LocalDate borrowDate, BookRequest bookForBorrowing);
}
