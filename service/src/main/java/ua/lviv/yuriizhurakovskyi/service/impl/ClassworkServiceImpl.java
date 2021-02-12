package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.repository.ClassworkRepository;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassworkServiceImpl implements ClassworkService {
    private final ClassworkRepository classworkRepository;

    @Override
    public Classwork save(Classwork classwork) {
        return classworkRepository.save(classwork);
    }

    @Override
    public Iterable<Classwork> saveAll(Collection<Classwork> classworks) {
        return classworkRepository.saveAll(classworks);
    }

    @Override
    public Optional<Classwork> findById(Integer classworkId) {
        return classworkRepository.findById(classworkId);
    }

    @Override
    public boolean existsById(Integer classworkId) {
        return classworkRepository.existsById(classworkId);
    }

    @Override
    public List<Classwork> findAll() {
        return classworkRepository.findAll();
    }

    @Override
    public void deleteById(Integer classworkId) {
        classworkRepository.deleteById(classworkId);
    }

    @Override
    public void delete(Classwork classwork) {
        classworkRepository.delete(classwork);
    }

    @Override
    public void deleteAll(Collection<Classwork> classworks) {
        classworkRepository.deleteAll(classworks);
    }

    @Override
    public void deleteAll() {
        classworkRepository.deleteAll();
    }
}
