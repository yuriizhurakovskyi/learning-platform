package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LessonService{
    LessonDtoResponse save(LessonDtoRequest lessonDtoRequest);

    LessonDtoResponse findById(Long lessonId);

    List<LessonDtoResponse> findAll();

    void deleteById(Long lessonId);

    LessonDtoResponse update(LessonDtoRequest lessonDtoRequest);
}
