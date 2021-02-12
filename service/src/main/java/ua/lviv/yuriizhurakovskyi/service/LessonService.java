package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Lesson;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LessonService{
    Lesson save(Lesson lesson);

    Iterable<Lesson> saveAll(Collection<Lesson> lessons);

    Optional<Lesson> findById(Integer lessonId);

    boolean existsById(Integer lessonId);

    List<Lesson> findAll();

    void deleteById(Integer lessonId);

    void delete(Lesson lesson);

    void deleteAll(Collection<Lesson> lessons);

    void deleteAll();
}
