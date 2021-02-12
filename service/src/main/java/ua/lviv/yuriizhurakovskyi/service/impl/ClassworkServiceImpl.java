package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.ClassworkDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.ClassworkDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.ClassworkRepository;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassworkServiceImpl implements ClassworkService {
    private final ClassworkRepository classworkRepository;
    private final ClassworkDtoRequestMapper classworkDtoRequestMapper;
    private final ClassworkDtoResponseMapper classworkDtoResponseMapper;

    @Override
    public ClassworkDtoResponse save(ClassworkDtoRequest classworkDtoRequest) {
        Classwork classwork = classworkDtoRequestMapper.map(classworkDtoRequest);
        classwork = classworkRepository.save(classwork);
        return classworkDtoResponseMapper.map(classwork);
    }

    @Override
    public ClassworkDtoResponse findById(Long classworkId) {
        Classwork classwork = classworkRepository.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException("Classwork with id=" + classworkId + " not found exception "));
        return classworkDtoResponseMapper.map(classwork);
    }

    @Override
    public List<ClassworkDtoResponse> findAll() {
        List<Classwork> classworks = classworkRepository.findAll();
        return classworks.stream().map(classworkDtoResponseMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long classworkId) {
        this.findById(classworkId);
        classworkRepository.deleteById(classworkId);
    }

    @Override
    public ClassworkDtoResponse update(ClassworkDtoRequest classworkDtoRequest) {
        Classwork classwork = classworkDtoRequestMapper.map(classworkDtoRequest);
        Long classworkId = classwork.getId();
        Classwork c = classworkRepository.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException("Classwork with id=" + classworkId + " not found exception "));
        c.setDate(classwork.getDate());
        c.setTask(classwork.getTask());
        c.setResult(classwork.getResult());
        c.setSolution(classwork.getSolution());
        c.setStudent(classwork.getStudent());
        c.setTeacher(classwork.getTeacher());
        c = classworkRepository.save(c);
        return classworkDtoResponseMapper.map(c);
    }
}
