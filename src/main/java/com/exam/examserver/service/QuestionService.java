package com.exam.examserver.service;

import com.exam.examserver.model.exam.Question;
import com.exam.examserver.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(long question_Id);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(long question_Id);
}
