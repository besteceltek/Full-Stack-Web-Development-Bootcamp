package com.beste.library.service;

import com.beste.library.dto.request.PublisherRequest;
import com.beste.library.dto.response.PublisherResponse;
import com.beste.library.entity.Publisher;
import com.beste.library.mapper.PublisherMapper;
import com.beste.library.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public PublisherResponse save(PublisherRequest publisherRequest) {
        Optional<Publisher> isPublisherExist = publisherRepository.
                findByNameAndEstablishmentYearAndAddress(
                        publisherRequest.getName(),
                        publisherRequest.getEstablishmentYear(),
                        publisherRequest.getAddress()
                );
        if (isPublisherExist.isEmpty()) {
            Publisher publisher = publisherRepository.save(publisherMapper.asEntity(publisherRequest));
            return publisherMapper.asOutput(publisher);
        }
        throw new RuntimeException("Bu yayıncı daha önce kayıt edilmiştir");
    }

    public PublisherResponse update(Long id, PublisherRequest publisherRequest) {
        Optional<Publisher> publisherFromDb = publisherRepository.findById(id);
        Optional<Publisher> isPublisherExist = publisherRepository.
                findByNameAndEstablishmentYearAndAddress(
                        publisherRequest.getName(),
                        publisherRequest.getEstablishmentYear(),
                        publisherRequest.getAddress()
                );
        if (publisherFromDb.isEmpty()) {
            throw new RuntimeException(id + "idli yayıncı bulunamadi");
        }
        if (isPublisherExist.isEmpty()) {
            Publisher publisher = publisherFromDb.get();
            publisherMapper.update(publisher, publisherRequest);
            return publisherMapper.asOutput(publisherRepository.save(publisher));
        }
        throw new RuntimeException("Bu yayıncı daha önce kayıt edilmiştir");
    }

    public void delete(Long id) {
        Optional<Publisher> publisherFromDb = publisherRepository.findById(id);
        if (publisherFromDb.isPresent()) {
            publisherRepository.delete(publisherFromDb.get());
        } else {
            throw new RuntimeException(id + "idli yayıncı bulunamadi");
        }
    }
}
