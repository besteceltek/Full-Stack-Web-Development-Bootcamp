package com.beste.library.service;

import com.beste.library.entity.Category;
import com.beste.library.mapper.CategoryMapper;
import com.beste.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryMapper.asOutput(categoryRepository.findAll());
    }

    public Category findById(Long id) {
        return categoryMapper.asOutput(categoryRepository.
                findById(id).orElseThrow(() -> new RuntimeException(id + "idli kategori bulunamadı")));
    }

   /*
   public CategoryResponse save(CategoryRequest categoryRequest) {
        Optional<Category> isCategoryExist = categoryRepository.findByNameAndDescription(
                categoryRequest.getName(),categoryRequest.getDescription()
        );
        if (isCategoryExist.isEmpty()) {
            Category category = categoryRepository.save(categoryMapper.asEntity(categoryRequest));
            return categoryMapper.asOutput(category);
        }
        throw new RuntimeException("Bu kategori daha önce kayıt edilmiştir");
    }

    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        Optional<Category> categoryFromDb = categoryRepository.findById(id);
        Optional<Category> isCategoryExist = categoryRepository.findByNameAndDescription(
                categoryRequest.getName(),categoryRequest.getDescription()
        );
        if (categoryFromDb.isEmpty()) {
            throw new RuntimeException(id + "idli kategori bulunamadi");
        }
        if (isCategoryExist.isEmpty()) {
            Category category = categoryFromDb.get();
            categoryMapper.update(category, categoryRequest);
            return categoryMapper.asOutput(category);
        }
        throw new RuntimeException("Bu kategori daha önce kayıt edilmiştir");
    }

    public void delete(Long id) {
        Optional<Category> categoryFromDb = categoryRepository.findById(id);
        if (categoryFromDb.isPresent()) {
            categoryRepository.delete(categoryFromDb.get());
        } else {
            throw new RuntimeException(id + "idli kategori bulunamadi");
        }
    }
    */
}
