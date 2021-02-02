package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.repository.TestRepository;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.Collection;
import java.util.Optional;

public class TestServiceImpl implements TestService {
    private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test save(Test test) {
        if (test != null) {
            logger.debug("Save test: " + test);
        }
        return testRepository.save(test);
    }

    @Override
    public Iterable<Test> saveAll(Collection<Test> users) {
        if (!users.isEmpty()) {
            logger.debug("Save all users: " + users);
        }
        return testRepository.saveAll(users);
    }

    @Override
    public Optional<Test> findById(Integer testId) {
        logger.debug("Find Test By Id: " + testId);
        return testRepository.findById(testId);
    }

    @Override
    public boolean existsById(Integer testId) {
        logger.debug("Exists Test By Id: " + testId);
        return testRepository.existsById(testId);
    }

    @Override
    public Iterable<Test> findAll() {
        logger.debug("Find All Tests");
        return testRepository.findAll();
    }

    @Override
    public void deleteById(Integer testId) {
        logger.debug("Delete By Id");
        testRepository.deleteById(testId);
    }

    @Override
    public void delete(Test test) {
        logger.debug("Delete test");
        testRepository.delete(test);
    }

    @Override
    public void deleteAll(Collection<Test> tests) {
        logger.debug("Delete Tests: " + tests);
        testRepository.deleteAll(tests);
    }

    @Override
    public void deleteAll() {
        logger.debug("Delete All Tests");
        testRepository.deleteAll();
    }
}
