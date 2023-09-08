package com.exam.examserver.controller;

import com.exam.examserver.model.exam.Question;
import com.exam.examserver.model.exam.Quiz;
import com.exam.examserver.service.QuestionService;
import com.exam.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //    Add Question Service
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //    Update Question Service
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //    Getting All Question of any quiz Service
    @GetMapping("/quiz/{q_Id}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("q_Id") Long q_Id) {

        Quiz quiz = this.quizService.getQuiz(q_Id);
        Set<Question> questions = quiz.getQuestions();

        List<Question> questionList = new ArrayList<>(questions);
        if (questionList.size() > Integer.parseInt(quiz.getNumber_of_questions())) {
            questionList = questionList.subList(0, Integer.parseInt(quiz.getNumber_of_questions()));
        }
        Collections.shuffle(questionList);
        return ResponseEntity.ok(questionList);
    }

    //    Getting All Question of any quiz Service for Admin
    @GetMapping("/quiz/all/{q_Id}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("q_Id") Long q_Id) {

        Quiz quiz = new Quiz();
        quiz.setQ_id(q_Id);
        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
    }

    //    Getting Single Question Service
    @GetMapping("/{ques_Id}")
    public Question question(@PathVariable("ques_Id") Long question_Id) {
        return this.questionService.getQuestion(question_Id);
    }

    //    Delete Question Service
    @DeleteMapping("/{ques_Id}")
    public void delete(@PathVariable("ques_Id") Long question_Id) {
        this.questionService.deleteQuestion(question_Id);
    }
}
