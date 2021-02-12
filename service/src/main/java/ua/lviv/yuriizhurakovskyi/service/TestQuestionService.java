package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;

import java.util.List;

public interface TestQuestionService {
    TestQuestion save(TestQuestion testQuestion);

    TestQuestion findById(Integer testQuestionId);

    List<TestQuestion> findAll();

    void deleteById(Integer testQuestionId);

    TestQuestion update(TestQuestion testQuestion);
}