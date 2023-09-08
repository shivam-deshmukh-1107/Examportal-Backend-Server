package com.exam.examserver.controller;

import com.exam.examserver.model.exam.Category;
import com.exam.examserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    // Constructor injection
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    private CategoryService categoryService;

    //Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //    Get Category
    @GetMapping("/{category_Id}")
    public Category getCategory(@PathVariable("category_Id") Long category_Id) {
        return this.categoryService.getCategory(category_Id);
    }

    //    Getting All categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //    Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

    //    Delete Category
    @DeleteMapping("/{category_Id}")
    public void deleteCategory(@PathVariable("category_Id") Long category_Id) {
        this.categoryService.deleteCategory(category_Id);
    }

}
