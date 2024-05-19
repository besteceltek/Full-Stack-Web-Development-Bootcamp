package com.beste.library.repository;

import com.beste.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndBirthDateAndCountry(String name, LocalDate birthDate, String country);
}
