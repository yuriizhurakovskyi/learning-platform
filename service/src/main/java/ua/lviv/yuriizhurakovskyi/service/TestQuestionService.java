package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TestQuestionService {
    TestQuestion save(TestQuestion testQuestion);

    Iterable<TestQuestion> saveAll(Collection<TestQuestion> testQuestions);

    Optional<TestQuestion> findById(Integer testQuestionId);

    boolean existsById(Integer testQuestionId);

    List<TestQuestion> findAll();

    void deleteById(Integer testQuestionId);

    void delete(TestQuestion testQuestion);

    void deleteAll(Collection<TestQuestion> testQuestions);

    void deleteAll();
}