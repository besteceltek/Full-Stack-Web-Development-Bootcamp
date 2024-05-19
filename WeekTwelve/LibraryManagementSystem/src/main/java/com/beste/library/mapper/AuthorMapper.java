package com.beste.library.mapper;

import com.beste.library.dto.request.AuthorRequest;
import com.beste.library.dto.response.AuthorResponse;
import com.beste.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author asEntity(AuthorRequest authorRequest);
    AuthorResponse asOutput(Author author);
    List<AuthorResponse> asOutput(List<Author> authorList);

    void update(@MappingTarget Author author, AuthorRequest authorRequest);
}
