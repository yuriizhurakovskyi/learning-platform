package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoResponse;

import java.util.List;

public interface TestQuestionService {

    TestQuestionDtoResponse save(TestQuestionDtoRequest testQuestionDtoRequest);

    TestQuestionDtoResponse findById(Long testQuestionId);

    List<TestQuestionDtoResponse> findAll();

    void deleteById(Long testQuestionId);

    TestQuestionDtoResponse update(TestQuestionDtoRequest testQuestionDtoRequest);
}