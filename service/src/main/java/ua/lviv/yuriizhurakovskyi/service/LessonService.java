package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Lesson;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LessonService{
    Lesson save(Lesson lesson);

    Lesson findById(Integer lessonId);

    List<Lesson> findAll();

    void deleteById(Integer lessonId);

    Lesson update(Lesson lesson);
}
