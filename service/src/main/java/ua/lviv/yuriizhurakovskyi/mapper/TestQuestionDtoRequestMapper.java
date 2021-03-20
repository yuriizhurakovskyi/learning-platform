package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.TestRepository;

@Component
@AllArgsConstructor
public class TestQuestionDtoRequestMapper {

    private final TestRepository testRepository;

    public TestQuestion map(TestQuestionDtoRequest testQuestionDtoRequest) {
        Long testId = testQuestionDtoRequest.getTestId();
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test with id=" + testId + " not found exception"));

        return TestQuestion.builder()
                .id(testQuestionDtoRequest.getId())
                .test(test)
                .question(testQuestionDtoRequest.getQuestion())
                .answer(testQuestionDtoRequest.getAnswer())
                .build();
    }
}
