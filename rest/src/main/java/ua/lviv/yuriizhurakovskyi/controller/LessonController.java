package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.LessonDto;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.Collection;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/saveLesson")
    public LessonDto save(LessonDto lessonDto) {
        return lessonService.save(lessonDto);
    }

    @PostMapping("/saveLessons")
    public Iterable<LessonDto> saveAll(Collection<LessonDto> lessonDtos) {
        return lessonService.saveAll(lessonDtos);
    }

    @GetMapping("/findById/{lessonId}")
    public Optional<LessonDto> findById(@PathVariable Integer lessonId) {
        return lessonService.findById(lessonId);
    }

    @GetMapping("/existsById/{lessonId}")
    public boolean existsById(@PathVariable Integer lessonId) {
        return lessonService.existsById(lessonId);
    }

    @GetMapping("/findAll")
    public Iterable<LessonDto> findAll() {
        return lessonService.findAll();
    }

    @DeleteMapping("/deleteById/{lessonId}")
    public void deleteById(@PathVariable Integer lessonId) {
        lessonService.deleteById(lessonId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody LessonDto lessonDto) {
        lessonService.delete(lessonDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<LessonDto> lessonDtos) {
        lessonService.deleteAll(lessonDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        lessonService.deleteAll();
    }
}
