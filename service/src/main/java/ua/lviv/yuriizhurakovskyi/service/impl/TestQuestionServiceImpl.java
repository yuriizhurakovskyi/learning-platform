package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.TestQuestionDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.TestQuestionDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.TestQuestionRepository;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestQuestionServiceImpl implements TestQuestionService {
    private final TestQuestionRepository testQuestionRepository;
    private final TestQuestionDtoRequestMapper testQuestionDtoRequestMapper;
    private final TestQuestionDtoResponseMapper testQuestionDtoResponseMapper;

    @Override
    public TestQuestionDtoResponse save(TestQuestionDtoRequest testQuestionDtoRequest) {
        TestQuestion testQuestion = testQuestionDtoRequestMapper.map(testQuestionDtoRequest);
        testQuestion = testQuestionRepository.save(testQuestion);
        return testQuestionDtoResponseMapper.map(testQuestion);
    }

    @Override
    public TestQuestionDtoResponse findById(Long testQuestionId) {
        TestQuestion testQuestion = testQuestionRepository.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException("Test Question with id=" + testQuestionId + " not found exception"));
        return testQuestionDtoResponseMapper.map(testQuestion);
    }

    @Override
    public List<TestQuestionDtoResponse> findAll() {
        List<TestQuestion> testQuestions = testQuestionRepository.findAll();
        return testQuestions.stream()
                .map(testQuestionDtoResponseMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long testQuestionId) {
        this.findById(testQuestionId);
        testQuestionRepository.deleteById(testQuestionId);
    }

    @Override
    public TestQuestionDtoResponse update(TestQuestionDtoRequest testQuestionDtoRequest) {
        TestQuestion testQuestion = testQuestionDtoRequestMapper.map(testQuestionDtoRequest);
        Long testQuestionId = testQuestion.getId();
        TestQuestion tq = testQuestionRepository.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException("Test Question with id=" + testQuestionId + " not found exception"));
        System.out.println("ID: " + tq.getId());
        tq.setQuestion(testQuestion.getQuestion());
        tq.setAnswer(testQuestion.getAnswer());
        tq.setTest(testQuestion.getTest());
        tq = testQuestionRepository.save(tq);
        return testQuestionDtoResponseMapper.map(tq);
    }

}