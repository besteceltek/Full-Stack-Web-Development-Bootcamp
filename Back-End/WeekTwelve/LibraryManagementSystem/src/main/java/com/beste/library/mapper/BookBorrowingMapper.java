package com.beste.library.mapper;

import com.beste.library.dto.request.BookBorrowingRequest;
import com.beste.library.dto.request.BookBorrowingUpdateRequest;
import com.beste.library.entity.BookBorrowing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookBorrowingMapper {

    BookBorrowing asEntity(BookBorrowingRequest bookBorrowingRequest);
    BookBorrowing asEntity(BookBorrowingUpdateRequest bookBorrowingUpdateRequest);

    void update(@MappingTarget BookBorrowing bookBorrowing, BookBorrowingUpdateRequest bookBorrowingUpdateRequest);
}
