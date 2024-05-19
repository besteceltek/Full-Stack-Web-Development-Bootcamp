package com.beste.library.dto.request;

import lombok.Data;

@Data
public class BookForBorrowingRequest {

    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
}
