package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.ClassworkDto;
import ua.lviv.yuriizhurakovskyi.repository.ClassworkRepository;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassworkServiceImpl implements ClassworkService {
    private final ClassworkRepository classworkRepository;

    @Override
    public ClassworkDto save(ClassworkDto classworkDto) {
        return classworkRepository.save(classworkDto);
    }

    @Override
    public Iterable<ClassworkDto> saveAll(Collection<ClassworkDto> classworkDtos) {
        return classworkRepository.saveAll(classworkDtos);
    }

    @Override
    public Optional<ClassworkDto> findById(Integer classworkId) {
        return classworkRepository.findById(classworkId);
    }

    @Override
    public boolean existsById(Integer classworkId) {
        return classworkRepository.existsById(classworkId);
    }

    @Override
    public Iterable<ClassworkDto> findAll() {
        return classworkRepository.findAll();
    }

    @Override
    public void deleteById(Integer classworkId) {
        classworkRepository.deleteById(classworkId);
    }

    @Override
    public void delete(ClassworkDto classworkDto) {
        classworkRepository.delete(classworkDto);
    }

    @Override
    public void deleteAll(Collection<ClassworkDto> classworkDtos) {
        classworkRepository.deleteAll(classworkDtos);
    }

    @Override
    public void deleteAll() {
        classworkRepository.deleteAll();
    }
}
