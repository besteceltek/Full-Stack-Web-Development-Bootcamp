package com.beste.library.mapper;

import com.beste.library.dto.request.PublisherRequest;
import com.beste.library.dto.response.PublisherResponse;
import com.beste.library.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    Publisher asEntity(PublisherRequest publisherRequest);
    PublisherResponse asOutput(Publisher publisher);
    List<PublisherResponse> asOutput(List<Publisher> publisherList);

    void update (@MappingTarget Publisher publisher, PublisherRequest publisherRequest);
}
