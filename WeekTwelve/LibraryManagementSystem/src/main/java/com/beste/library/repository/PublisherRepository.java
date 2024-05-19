package com.beste.library.repository;

import com.beste.library.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByNameAndEstablishmentYearAndAddress(String name, Integer establishmentYear, String address);
}
