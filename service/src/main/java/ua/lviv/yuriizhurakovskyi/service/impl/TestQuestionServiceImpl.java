package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.model.TestQuestionDto;
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
    public TestQuestionDto save(TestQuestionDto testQuestionDto) {
        return testQuestionRepository.save(testQuestionDto);
    }

    @Override
    public Iterable<TestQuestionDto> saveAll(Collection<TestQuestionDto> testQuestionDtos) {
        return testQuestionRepository.saveAll(testQuestionDtos);
    }

    @Override
    public Optional<TestQuestionDto> findById(Integer testQuestionId) {
        return testQuestionRepository.findById(testQuestionId);
    }

    @Override
    public boolean existsById(Integer testQuestionId) {
        return testQuestionRepository.existsById(testQuestionId);
    }

    @Override
    public List<TestQuestionDto> findAll() {
        return testQuestionRepository.findAll();
    }

    @Override
    public void deleteById(Integer testQuestionId) {
        testQuestionRepository.deleteById(testQuestionId);
    }

    @Override
    public void delete(TestQuestionDto testQuestionDto) {
        testQuestionRepository.delete(testQuestionDto);
    }

    @Override
    public void deleteAll(Collection<TestQuestionDto> testQuestionDtos) {
        testQuestionRepository.deleteAll(testQuestionDtos);
    }

    @Override
    public void deleteAll() {
        testQuestionRepository.deleteAll();
    }
}