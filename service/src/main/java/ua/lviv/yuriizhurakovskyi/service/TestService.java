package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TestService{
    Test save(Test test);

    Iterable<Test> saveAll(Collection<Test> tests);

    Optional<Test> findById(Integer testId);

    boolean existsById(Integer testId);

    List<Test> findAll();

    void deleteById(Integer testId);

    void delete(Test test);

    void deleteAll(Collection<Test> tests);

    void deleteAll();
}
