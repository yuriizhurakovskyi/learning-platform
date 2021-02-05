package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.model.ClassworkDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClassworkService {
    ClassworkDto save(ClassworkDto classworkDto);

    Iterable<ClassworkDto> saveAll(Collection<ClassworkDto> classworkDtos);

    Optional<ClassworkDto> findById(Integer classworkId);

    boolean existsById(Integer classworkId);

    List<ClassworkDto> findAll();

    void deleteById(Integer classworkId);

    void delete(ClassworkDto classworkDto);

    void deleteAll(Collection<ClassworkDto> classworkDtos);

    void deleteAll();
}
