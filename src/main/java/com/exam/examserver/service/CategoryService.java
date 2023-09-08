package com.exam.examserver.service;

import com.exam.examserver.model.exam.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long category_Id);

    public void deleteCategory(Long category_Id);
}
