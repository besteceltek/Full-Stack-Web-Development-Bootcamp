package com.beste.library.controller;

import com.beste.library.dto.response.PublisherResponse;
import com.beste.library.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherResponse> findAll() {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponse findById(@PathVariable("id") Long id) {
        return publisherService.findById(id);
    }
}
