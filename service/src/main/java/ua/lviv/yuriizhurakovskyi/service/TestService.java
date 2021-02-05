package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.TestDto;

import java.util.Collection;
import java.util.Optional;

public interface TestService{
    TestDto save(TestDto testDto);

    Iterable<TestDto> saveAll(Collection<TestDto> testDtos);

    Optional<TestDto> findById(Integer testId);

    boolean existsById(Integer testId);

    Iterable<TestDto> findAll();

    void deleteById(Integer testId);

    void delete(TestDto testDto);

    void deleteAll(Collection<TestDto> testDtos);

    void deleteAll();
}
