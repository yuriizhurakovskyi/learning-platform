package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.LessonDto;
import ua.lviv.yuriizhurakovskyi.repository.LessonRepository;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public LessonDto save(LessonDto lessonDto) {
        return lessonRepository.save(lessonDto);
    }

    @Override
    public Iterable<LessonDto> saveAll(Collection<LessonDto> lessonDtos) {
        return lessonRepository.saveAll(lessonDtos);
    }

    @Override
    public Optional<LessonDto> findById(Integer lessonId) {
        return lessonRepository.findById(lessonId);
    }

    @Override
    public boolean existsById(Integer lessonId) {
        return lessonRepository.existsById(lessonId);
    }

    @Override
    public Iterable<LessonDto> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void deleteById(Integer lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public void delete(LessonDto lessonDto) {
        lessonRepository.delete(lessonDto);
    }

    @Override
    public void deleteAll(Collection<LessonDto> lessonDtos) {
        lessonRepository.deleteAll(lessonDtos);
    }

    @Override
    public void deleteAll() {
        lessonRepository.deleteAll();
    }
}
