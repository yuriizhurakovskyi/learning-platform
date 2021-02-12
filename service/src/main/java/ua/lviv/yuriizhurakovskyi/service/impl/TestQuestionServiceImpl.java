package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.TestQuestionRepository;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestQuestionServiceImpl implements TestQuestionService {
    private final TestQuestionRepository testQuestionRepository;

    @Override
    public TestQuestion save(TestQuestion testQuestion) {
        return testQuestionRepository.save(testQuestion);
    }

    @Override
    public TestQuestion findById(Integer testQuestionId) {
        return testQuestionRepository.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException("Test Question with id=" + testQuestionId + " not found exception"));
    }

    @Override
    public List<TestQuestion> findAll() {
        return testQuestionRepository.findAll();
    }

    @Override
    public void deleteById(Integer testQuestionId) {
        this.findById(testQuestionId);
        testQuestionRepository.deleteById(testQuestionId);
    }

    @Override
    public TestQuestion update(TestQuestion testQuestion) {
        Integer testQuestionId = testQuestion.getId();
        TestQuestion qd = this.findById(testQuestionId);
        qd.setQuestion(testQuestion.getQuestion());
        qd.setAnswer(testQuestion.getAnswer());
        return testQuestionRepository.save(qd);
    }

}