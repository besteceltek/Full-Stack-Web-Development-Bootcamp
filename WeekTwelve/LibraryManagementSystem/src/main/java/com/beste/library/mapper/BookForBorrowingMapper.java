package com.beste.library.mapper;

import com.beste.library.dto.request.BookRequest;
import com.beste.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookForBorrowingMapper {
    Book asEntity(BookRequest bookRequest);
}
