package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.repository.TestRepository;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Iterable<Test> saveAll(Collection<Test> users) {
        return testRepository.saveAll(users);
    }

    @Override
    public Optional<Test> findById(Integer testId) {
        return testRepository.findById(testId);
    }

    @Override
    public boolean existsById(Integer testId) {
        return testRepository.existsById(testId);
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public void deleteById(Integer testId) {
        testRepository.deleteById(testId);
    }

    @Override
    public void delete(Test test) {
        testRepository.delete(test);
    }

    @Override
    public void deleteAll(Collection<Test> tests) {
        testRepository.deleteAll(tests);
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }
}
