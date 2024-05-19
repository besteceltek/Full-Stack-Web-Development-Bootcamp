package com.beste.library.mapper;

import com.beste.library.dto.request.CategoryRequest;
import com.beste.library.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category asOutput(Category category);
    List<Category> asOutput(List<Category> categoryList);
    Category asEntity(CategoryRequest categoryRequest);

    void update(@MappingTarget Category category, CategoryRequest categoryRequest);
}
