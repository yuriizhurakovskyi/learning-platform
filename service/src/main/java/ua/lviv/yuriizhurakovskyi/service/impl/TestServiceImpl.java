package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.model.TestDto;
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
    public TestDto save(TestDto testDto) {
        return testRepository.save(testDto);
    }

    @Override
    public Iterable<TestDto> saveAll(Collection<TestDto> users) {
        return testRepository.saveAll(users);
    }

    @Override
    public Optional<TestDto> findById(Integer testId) {
        return testRepository.findById(testId);
    }

    @Override
    public boolean existsById(Integer testId) {
        return testRepository.existsById(testId);
    }

    @Override
    public List<TestDto> findAll() {
        return testRepository.findAll();
    }

    @Override
    public void deleteById(Integer testId) {
        testRepository.deleteById(testId);
    }

    @Override
    public void delete(TestDto testDto) {
        testRepository.delete(testDto);
    }

    @Override
    public void deleteAll(Collection<TestDto> testDtos) {
        testRepository.deleteAll(testDtos);
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }
}
