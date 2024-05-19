package com.beste.library.repository;

import com.beste.library.dto.request.BookRequest;
import com.beste.library.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {
    Optional<BookBorrowing> findByBorrowerNameAndBorrowDateAndBook(String borrowerName, LocalDate borrowDate, BookRequest bookForBorrowing);
    Optional<BookBorrowing> findByBorrowerNameAndBorrowDateAndReturnDate(String borrowerName, LocalDate borrowDate, LocalDate returnDate);
}
