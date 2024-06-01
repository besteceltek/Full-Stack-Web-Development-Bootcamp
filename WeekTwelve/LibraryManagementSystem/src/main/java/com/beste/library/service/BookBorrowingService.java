package com.beste.library.service;

import com.beste.library.dto.request.BookBorrowingRequest;
import com.beste.library.dto.request.BookBorrowingUpdateRequest;
import com.beste.library.entity.Book;
import com.beste.library.entity.BookBorrowing;
import com.beste.library.mapper.BookBorrowingMapper;
import com.beste.library.mapper.BookMapper;
import com.beste.library.repository.BookBorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookBorrowingService {

    private final BookBorrowingRepository bookBorrowingRepository;
    private final BookBorrowingMapper bookBorrowingMapper;
    private final BookMapper bookMapper;

    public List<BookBorrowing> findAll() {
        return bookBorrowingRepository.findAll();
    }

    public BookBorrowing findById(Long id) {
        return bookBorrowingRepository.
                findById(id).orElseThrow(() -> new RuntimeException(id + "idli kira bulunamadı"));
    }

    public BookBorrowing save(BookBorrowingRequest bookBorrowingRequest) {
        Optional<BookBorrowing> isBookBorrowExist = bookBorrowingRepository.
                findByEmailAndBorrowDateAndBook(
                        bookBorrowingRequest.getEmail(),
                        bookBorrowingRequest.getBorrowDate(),
                        bookBorrowingRequest.getBook()
                );
        Book book = bookMapper.asEntity(bookBorrowingRequest.getBook());
        if (isBookBorrowExist.isEmpty()) {
            if (book.getStock() > 0) {
                bookBorrowingRequest.getBook().setStock(book.getStock() - 1);
                bookMapper.update(book, bookBorrowingRequest.getBook());
                return bookBorrowingRepository.save(bookBorrowingMapper.asEntity(bookBorrowingRequest));
            }
            throw new RuntimeException("Bu kitap stokta kalmamıştır");
        }
        throw new RuntimeException("Bu kira daha önce kayıt edilmiştir");
    }

    public BookBorrowing update(Long id, BookBorrowingUpdateRequest bookBorrowingUpdateRequest) {
        Optional<BookBorrowing> bookBorrowingFromDb = bookBorrowingRepository.findById(id);
        Optional<BookBorrowing> isBookBorrowingExist = bookBorrowingRepository.
                findByNameAndBorrowDateAndReturnDate(
                        bookBorrowingUpdateRequest.getName(),
                        bookBorrowingUpdateRequest.getBorrowDate(),
                        bookBorrowingUpdateRequest.getReturnDate()
                );
        if (bookBorrowingFromDb.isEmpty()) {
            throw new RuntimeException(id + "idli kira bulunamadi");
        }
        if (isBookBorrowingExist.isEmpty()) {
            BookBorrowing bookBorrowing = bookBorrowingFromDb.get();
            bookBorrowingMapper.update(bookBorrowing, bookBorrowingUpdateRequest);
            return bookBorrowingRepository.save(bookBorrowing);
        }
        throw new RuntimeException("Bu kira daha önce kayıt edilmiştir");
    }

    public void delete(Long id) {
        Optional<BookBorrowing> bookBorrowingFromDb = bookBorrowingRepository.findById(id);
        if (bookBorrowingFromDb.isPresent()) {
            bookBorrowingRepository.delete(bookBorrowingFromDb.get());
        } else {
            throw new RuntimeException(id + "idli kira bulunamadi");
        }
    }
}
