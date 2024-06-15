package com.beste.library.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorRequest {

    private String name;
    private LocalDate birthDate;
    private String country;
}
