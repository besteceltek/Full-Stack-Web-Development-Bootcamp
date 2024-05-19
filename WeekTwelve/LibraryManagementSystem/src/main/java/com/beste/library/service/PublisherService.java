package com.beste.library.service;

import com.beste.library.dto.response.PublisherResponse;
import com.beste.library.mapper.PublisherMapper;
import com.beste.library.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public List<PublisherResponse> findAll() {
        return publisherMapper.asOutput(publisherRepository.findAll());
    }

    public PublisherResponse findById(Long id) {
        return publisherMapper.asOutput(publisherRepository.
                findById(id).orElseThrow(() -> new RuntimeException(id + "idli yayıncı bulunamadı")));
    }
}
