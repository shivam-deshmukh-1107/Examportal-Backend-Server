package com.exam.examserver.controller;

import com.exam.examserver.model.exam.Category;
import com.exam.examserver.model.exam.Quiz;
import com.exam.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //    Add Quiz Service
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //    Update Quiz Service
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updatequiz(quiz));
    }

    //    Getting Quiz Service
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzies());
    }

    //    Getting Single Quiz Service
    @GetMapping("/{q_Id}")
    public Quiz quiz(@PathVariable("q_Id") Long q_Id) {
        return this.quizService.getQuiz(q_Id);
    }

    //    Delete Quiz Service
    @DeleteMapping("/{q_Id}")
    public void delete(@PathVariable("q_Id") Long q_Id) {
        this.quizService.deleteQuiz(q_Id);
    }

    //    Getting Specific quiz
    @GetMapping("/category/{c_Id}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("c_Id") long c_Id) {
        Category category = new Category();
        category.setC_Id(c_Id);
        return this.quizService.getQuizziesOfCategory(category);
    }

    //    Getting Active Quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
        return this.quizService.getActiveQuizzes();
    }

    //    Getting Active Quizzes of category
    @GetMapping("/category/active/{c_Id}")
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("c_Id") Long c_Id) {
        Category category = new Category();
        category.setC_Id(c_Id);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
}
