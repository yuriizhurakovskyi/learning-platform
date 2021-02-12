package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TestService {
    Test save(Test test);

    Test findById(Integer testId);

    List<Test> findAll();

    void deleteById(Integer testId);

    Test update(Test test);
}
