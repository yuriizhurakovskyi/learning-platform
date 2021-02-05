package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.TestQuestionDto;

import java.util.Collection;
import java.util.Optional;

public interface TestQuestionService {
    TestQuestionDto save(TestQuestionDto testQuestionDto);

    Iterable<TestQuestionDto> saveAll(Collection<TestQuestionDto> testQuestionDtos);

    Optional<TestQuestionDto> findById(Integer testQuestionId);

    boolean existsById(Integer testQuestionId);

    Iterable<TestQuestionDto> findAll();

    void deleteById(Integer testQuestionId);

    void delete(TestQuestionDto testQuestionDto);

    void deleteAll(Collection<TestQuestionDto> testQuestionDtos);

    void deleteAll();
}