package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClassworkService {
    ClassworkDtoResponse save(ClassworkDtoRequest classworkDtoRequest);

    ClassworkDtoResponse findById(Long classworkId);

    List<ClassworkDtoResponse> findAll();

    void deleteById(Long classworkId);

    ClassworkDtoResponse update(ClassworkDtoRequest classworkDtoRequest);
}
