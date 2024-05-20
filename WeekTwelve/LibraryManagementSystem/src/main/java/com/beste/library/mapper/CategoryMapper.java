package com.beste.library.mapper;

import com.beste.library.dto.request.CategoryRequest;
import com.beste.library.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category asEntity(CategoryRequest categoryRequest);

    void update(@MappingTarget Category category, CategoryRequest categoryRequest);
}
