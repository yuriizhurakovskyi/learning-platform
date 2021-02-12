package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.TestRepository;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test findById(Integer testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test with id=" + testId + " not found exception "));
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public void deleteById(Integer testId) {
        this.findById(testId);
        testRepository.deleteById(testId);
    }

    @Override
    public Test update(Test test) {
        Integer testId = test.getId();
        Test t = this.findById(testId);
        //   t.setLevel(test.getLevel());
        //   t.setCountOfQuestions(test.getCountOfQuestions());
        t.setName(test.getName());
        return testRepository.save(t);
    }

}
