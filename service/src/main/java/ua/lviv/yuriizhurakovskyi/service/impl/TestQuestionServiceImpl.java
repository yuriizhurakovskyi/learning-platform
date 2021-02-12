package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
import ua.lviv.yuriizhurakovskyi.repository.TestQuestionRepository;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestQuestionServiceImpl implements TestQuestionService {
    private final TestQuestionRepository testQuestionRepository;

    @Override
    public TestQuestion save(TestQuestion testQuestion) {
        return testQuestionRepository.save(testQuestion);
    }

    @Override
    public Iterable<TestQuestion> saveAll(Collection<TestQuestion> testQuestions) {
        return testQuestionRepository.saveAll(testQuestions);
    }

    @Override
    public Optional<TestQuestion> findById(Integer testQuestionId) {
        return testQuestionRepository.findById(testQuestionId);
    }

    @Override
    public boolean existsById(Integer testQuestionId) {
        return testQuestionRepository.existsById(testQuestionId);
    }

    @Override
    public List<TestQuestion> findAll() {
        return testQuestionRepository.findAll();
    }

    @Override
    public void deleteById(Integer testQuestionId) {
        testQuestionRepository.deleteById(testQuestionId);
    }

    @Override
    public void delete(TestQuestion testQuestion) {
        testQuestionRepository.delete(testQuestion);
    }

    @Override
    public void deleteAll(Collection<TestQuestion> testQuestions) {
        testQuestionRepository.deleteAll(testQuestions);
    }

    @Override
    public void deleteAll() {
        testQuestionRepository.deleteAll();
    }
}