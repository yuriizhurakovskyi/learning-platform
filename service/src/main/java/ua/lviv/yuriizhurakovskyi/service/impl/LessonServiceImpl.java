package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.LessonRepository;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson findById(Integer lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson with id=" + lessonId + " not found exception "));
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void deleteById(Integer lessonId) {
        this.findById(lessonId);
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public Lesson update(Lesson lesson) {
        Integer lessonId = lesson.getId();
        Lesson l = this.findById(lessonId);
        l.setDescription(lesson.getDescription());
        l.setLectureTopic(lesson.getLectureTopic());
        return lessonRepository.save(l);
    }
}
