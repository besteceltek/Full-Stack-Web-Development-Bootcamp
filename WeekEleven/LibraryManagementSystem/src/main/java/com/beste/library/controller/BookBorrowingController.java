package com.beste.library.controller;

import com.beste.library.dto.request.BookBorrowingRequest;
import com.beste.library.dto.request.BookBorrowingUpdateRequest;
import com.beste.library.entity.BookBorrowing;
import com.beste.library.service.BookBorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/book-borrowing")
public class BookBorrowingController {
    private final BookBorrowingService bookBorrowingService;

    public BookBorrowingController(BookBorrowingService bookBorrowingService) {
        this.bookBorrowingService = bookBorrowingService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookBorrowing> findAll() {
        return bookBorrowingService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing findById(@PathVariable("id") Long id) {
        return bookBorrowingService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowingRequest bookBorrowingRequest) {
        return bookBorrowingService.save(bookBorrowingRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing update(@PathVariable Long id, @RequestBody BookBorrowingUpdateRequest bookBorrowingUpdateRequest) {
        return bookBorrowingService.update(id, bookBorrowingUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        bookBorrowingService.delete(id);
    }
}
