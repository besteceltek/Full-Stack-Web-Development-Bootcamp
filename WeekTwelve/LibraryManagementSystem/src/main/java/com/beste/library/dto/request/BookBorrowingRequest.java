package com.beste.library.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookBorrowingRequest {

    private String name;
    private String email;
    private LocalDate borrowDate;
    private BookRequest book;
}
