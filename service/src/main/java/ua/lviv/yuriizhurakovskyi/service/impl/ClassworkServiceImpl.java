package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.ClassworkRepository;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassworkServiceImpl implements ClassworkService {
    private final ClassworkRepository classworkRepository;

    @Override
    public Classwork save(Classwork classwork) {
        return classworkRepository.save(classwork);
    }

    @Override
    public Classwork findById(Integer classworkId) {
        return classworkRepository.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException("Classwork with id=" + classworkId + " not found exception "));
    }

    @Override
    public List<Classwork> findAll() {
        return classworkRepository.findAll();
    }

    @Override
    public void deleteById(Integer classworkId) {
        this.findById(classworkId);
        classworkRepository.deleteById(classworkId);
    }

    @Override
    public Classwork update(Classwork classwork) {
        Integer classworkId = classwork.getId();
        Classwork c = this.findById(classworkId);
        c.setDate(classwork.getDate());
        c.setTask(classwork.getTask());
        c.setResult(classwork.getResult());
        c.setSolution(classwork.getSolution());
        c.setStudent(classwork.getStudent());
        c.setTeacher(classwork.getTeacher());
        return classworkRepository.save(c);
    }
}
