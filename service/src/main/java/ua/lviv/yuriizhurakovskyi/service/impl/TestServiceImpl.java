package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.TestDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.TestDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.TestRepository;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final TestDtoRequestMapper testDtoRequestMapper;
    private final TestDtoResponseMapper testDtoResponseMapper;

    @Override
    public TestDtoResponse save(TestDtoRequest testDtoRequest) {
        Test test = testDtoRequestMapper.map(testDtoRequest);
        test = testRepository.save(test);
        return testDtoResponseMapper.map(test);
    }

    @Override
    public TestDtoResponse findById(Long testId) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test with id=" + testId + " not found exception "));
        return testDtoResponseMapper.map(test);
    }

    @Override
    public List<TestDtoResponse> findAll() {
        List<Test> tests = testRepository.findAll();
        return tests.stream().map(testDtoResponseMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long testId) {
        this.findById(testId);
        testRepository.deleteById(testId);
    }

    @Override
    public TestDtoResponse update(TestDtoRequest testDtoRequest) {
        Test test = testDtoRequestMapper.map(testDtoRequest);
        Long testId = test.getId();
        Test t = testRepository.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test with id=" + testId + " not found exception "));
        //   t.setLevel(test.getLevel());
        //   t.setCountOfQuestions(test.getCountOfQuestions());
        t.setName(test.getName());
        t = testRepository.save(t);
        return testDtoResponseMapper.map(t);
    }

}
