package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
import ua.lviv.yuriizhurakovskyi.repository.TestQuestionRepository;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.Collection;
import java.util.Optional;

public class TestQuestionServiceImpl implements TestQuestionService {
    private Logger logger = LoggerFactory.getLogger(TestQuestionServiceImpl.class);
    private final TestQuestionRepository testQuestionRepository;

    @Autowired
    public TestQuestionServiceImpl(TestQuestionRepository testQuestionRepository) {
        this.testQuestionRepository = testQuestionRepository;
    }

    @Override
    public TestQuestion save(TestQuestion testQuestion) {
        if (testQuestion != null) {
            logger.debug("Save TestQuestion: " + testQuestion);
        }
        return testQuestionRepository.save(testQuestion);
    }

    @Override
    public Iterable<TestQuestion> saveAll(Collection<TestQuestion> testQuestions) {
        if (!testQuestions.isEmpty()) {
            logger.debug("Save all testQuestions: " + testQuestions);
        }
        return testQuestionRepository.saveAll(testQuestions);
    }

    @Override
    public Optional<TestQuestion> findById(Integer testQuestionId) {
        logger.debug("Find testQuestion by id" + testQuestionId);
        return testQuestionRepository.findById(testQuestionId);
    }

    @Override
    public boolean existsById(Integer testQuestionId) {
        logger.debug("Exists user by id: " + testQuestionId);
        return testQuestionRepository.existsById(testQuestionId);
    }

    @Override
    public Iterable<TestQuestion> findAll() {
        logger.debug("Find All TestQuestions");
        return testQuestionRepository.findAll();
    }

    @Override
    public void deleteById(Integer testQuestionId) {
        logger.debug("Delete testQuestion by id");
        testQuestionRepository.deleteById(testQuestionId);
    }

    @Override
    public void delete(TestQuestion testQuestion) {
        logger.debug("Delete TestQuestion: " + testQuestion);
        testQuestionRepository.delete(testQuestion);
    }

    @Override
    public void deleteAll(Collection<TestQuestion> testQuestions) {
        logger.debug("Delete collections of TestQuestions: " + testQuestions);
        testQuestionRepository.deleteAll(testQuestions);
    }

    @Override
    public void deleteAll() {
        logger.debug("Delete all TestQuestions");
        testQuestionRepository.deleteAll();
    }
}