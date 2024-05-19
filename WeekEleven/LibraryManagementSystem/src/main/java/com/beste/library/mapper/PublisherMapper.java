package com.beste.library.mapper;

import com.beste.library.dto.response.PublisherResponse;
import com.beste.library.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherResponse asOutput(Publisher publisher);
    List<PublisherResponse> asOutput(List<Publisher> publisherList);
}
