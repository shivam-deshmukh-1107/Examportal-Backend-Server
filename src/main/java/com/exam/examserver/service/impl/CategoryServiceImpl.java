package com.exam.examserver.service.impl;

import com.exam.examserver.model.exam.Category;
import com.exam.examserver.repo.CategoryRepository;
import com.exam.examserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long category_Id) {
        return this.categoryRepository.findById(category_Id).get();
    }

    @Override
    public void deleteCategory(Long category_Id) {

        Category category = new Category();
        category.setC_Id(category_Id);
        this.categoryRepository.delete(category);

    }
}
