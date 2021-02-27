package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;

@Component
@AllArgsConstructor
public class TestQuestionDtoResponseMapper {
    private final TestDtoResponseMapper testDtoResponseMapper;

    public TestQuestionDtoResponse map(TestQuestion testQuestion) {
        TestDtoResponse testDtoResponse = testDtoResponseMapper.map(testQuestion.getTest());
        return TestQuestionDtoResponse.builder()
                .id(testQuestion.getId())
                .question(testQuestion.getQuestion())
                .answer(testQuestion.getAnswer())
                .testDtoResponse(testDtoResponse)
                .build();
    }
}
