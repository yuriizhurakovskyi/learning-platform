package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
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
    public Iterable<Lesson> saveAll(Collection<Lesson> lessons) {
        return lessonRepository.saveAll(lessons);
    }

    @Override
    public Optional<Lesson> findById(Integer lessonId) {
        return lessonRepository.findById(lessonId);
    }

    @Override
    public boolean existsById(Integer lessonId) {
        return lessonRepository.existsById(lessonId);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void deleteById(Integer lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public void delete(Lesson lesson) {
        lessonRepository.delete(lesson);
    }

    @Override
    public void deleteAll(Collection<Lesson> lessons) {
        lessonRepository.deleteAll(lessons);
    }

    @Override
    public void deleteAll() {
        lessonRepository.deleteAll();
    }
}
