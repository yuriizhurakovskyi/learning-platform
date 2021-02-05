package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.model.LessonDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LessonService{
    LessonDto save(LessonDto lessonDto);

    Iterable<LessonDto> saveAll(Collection<LessonDto> lessonDtos);

    Optional<LessonDto> findById(Integer lessonId);

    boolean existsById(Integer lessonId);

    List<LessonDto> findAll();

    void deleteById(Integer lessonId);

    void delete(LessonDto lessonDto);

    void deleteAll(Collection<LessonDto> lessonDtos);

    void deleteAll();
}
