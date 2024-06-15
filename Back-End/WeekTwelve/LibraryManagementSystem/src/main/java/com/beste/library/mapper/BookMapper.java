package com.beste.library.mapper;

import com.beste.library.dto.request.BookRequest;
import com.beste.library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book asEntity(BookRequest bookRequest);

    void update(@MappingTarget Book book, BookRequest bookRequest);
}
