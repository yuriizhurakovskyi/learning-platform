package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.LessonDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.LessonDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.LessonRepository;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonDtoRequestMapper lessonDtoRequestMapper;
    private final LessonDtoResponseMapper lessonDtoResponseMapper;

    @Override
    public LessonDtoResponse save(LessonDtoRequest lessonDtoRequest) {
        Lesson lesson = lessonDtoRequestMapper.map(lessonDtoRequest);
        lesson = lessonRepository.save(lesson);
        return lessonDtoResponseMapper.map(lesson);
    }

    @Override
    public LessonDtoResponse findById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson with id=" + lessonId + " not found exception "));
        return lessonDtoResponseMapper.map(lesson);
    }

    @Override
    public List<LessonDtoResponse> findAll() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons.stream().map(lessonDtoResponseMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long lessonId) {
        this.findById(lessonId);
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public LessonDtoResponse update(LessonDtoRequest lessonDtoRequest) {
        Lesson lesson = lessonDtoRequestMapper.map(lessonDtoRequest);
        Long lessonId = lesson.getId();
        Lesson l = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson with id=" + lessonId + " not found exception "));
        l.setDescription(lesson.getDescription());
        l.setLectureTopic(lesson.getLectureTopic());
        l.setCourse(lesson.getCourse());
        l = lessonRepository.save(l);
        return lessonDtoResponseMapper.map(l);
    }
}
