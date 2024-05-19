package com.beste.library.dto.request;

import lombok.Data;

@Data
public class BookRequest {

    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
}
