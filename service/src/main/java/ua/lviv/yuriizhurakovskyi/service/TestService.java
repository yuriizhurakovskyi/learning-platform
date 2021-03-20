package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TestService {

    TestDtoResponse save(TestDtoRequest testDtoRequest);

    TestDtoResponse findById(Long testId);

    List<TestDtoResponse> findAll();

    void deleteById(Long testId);

    TestDtoResponse update(TestDtoRequest testDtoRequest);
}
