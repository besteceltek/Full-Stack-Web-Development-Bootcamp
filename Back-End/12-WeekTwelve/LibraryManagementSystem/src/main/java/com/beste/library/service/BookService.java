package com.beste.library.service;

import com.beste.library.dto.request.BookRequest;
import com.beste.library.entity.Book;
import com.beste.library.mapper.BookMapper;
import com.beste.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "idli kitap bulunamadı"));
    }

    public Book save(BookRequest bookRequest) {
        Optional<Book> isBookExist = bookRepository.
                findByNameAndPublicationYear(bookRequest.getName(), bookRequest.getPublicationYear());
        if (isBookExist.isEmpty()) {
            Book book = bookRepository.save(bookMapper.asEntity(bookRequest));
            return book;
        }
        throw new RuntimeException("Bu kitap daha önce kayıt edilmiştir");
    }

    public Book update(Long id, BookRequest bookRequest) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        Optional<Book> isBookExist = bookRepository.
                findByNameAndPublicationYear(bookRequest.getName(), bookRequest.getPublicationYear());
        if (bookFromDb.isEmpty()) {
            throw new RuntimeException(id + "idli kitap bulunamadi");
        }
        if (isBookExist.isEmpty()) {
            Book book = bookFromDb.get();
            bookMapper.update(book, bookRequest);
            return book;
        }
        throw new RuntimeException("Bu kitap daha önce kayıt edilmiştir");
    }

    public void delete(Long id) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if (bookFromDb.isPresent()) {
            bookRepository.delete(bookFromDb.get());
        } else {
            throw new RuntimeException("Bu kitap bulunamadi");
        }
    }
}
