package com.beste.library.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookBorrowingUpdateRequest {

    private String borrowerName;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
