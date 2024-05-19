package com.beste.library.service;

import com.beste.library.dto.request.AuthorRequest;
import com.beste.library.dto.response.AuthorResponse;
import com.beste.library.entity.Author;
import com.beste.library.mapper.AuthorMapper;
import com.beste.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorResponse> findAll() {
        return authorMapper.asOutput(authorRepository.findAll());
    }

    public AuthorResponse findById(Long id) {
        return authorMapper.asOutput(authorRepository.
                findById(id).orElseThrow(() -> new RuntimeException(id + "idli yazar bulunamadı")));
    }

    public AuthorResponse save(AuthorRequest authorRequest) {
        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(
                authorRequest.getName(), authorRequest.getBirthDate(), authorRequest.getCountry()
        );
        if (isAuthorExist.isEmpty()) {
            Author author = authorRepository.save(authorMapper.asEntity(authorRequest));
            return authorMapper.asOutput(author);
        }
        throw new RuntimeException("Bu yazar daha önce kayıt edilmiştir");
    }

    public AuthorResponse update(Long id, AuthorRequest authorRequest) {
        Optional<Author> authorFromDb = authorRepository.findById(id);
        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(
                authorRequest.getName(), authorRequest.getBirthDate(), authorRequest.getCountry()
        );
        if (authorFromDb.isEmpty()) {
            throw new RuntimeException(id + "idli yazar bulunamadi");
        }
        if (isAuthorExist.isEmpty()) {
            Author author = authorFromDb.get();
            authorMapper.update(author, authorRequest);
            return authorMapper.asOutput(authorRepository.save(author));
        }
        throw new RuntimeException("Bu yazar daha önce kayıt edilmiştir");
    }

    public void delete(Long id) {
        Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isPresent()) {
            authorRepository.delete(authorFromDb.get());
        } else {
            throw new RuntimeException(id + "idli yazar bulunamadi");
        }
    }
}
