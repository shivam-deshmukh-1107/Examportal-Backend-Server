package com.exam.examserver.service;

import com.exam.examserver.model.exam.Category;
import com.exam.examserver.model.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updatequiz(Quiz quiz);

    public Set<Quiz> getQuizzies();

    public Quiz getQuiz(Long quiz_Id);

    public void deleteQuiz(Long quiz_Id);

    public List<Quiz> getQuizziesOfCategory(Category category);

    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
