package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.LessonDto;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.Collection;
import java.util.List;

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
    public ResponseEntity<LessonDto> findById(@PathVariable Integer lessonId) {
        LessonDto lessonDto = lessonService.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        return ResponseEntity.ok().body(lessonDto);
    }

    @GetMapping("/existsById/{lessonId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer lessonId) {
        return ResponseEntity.ok().body(lessonService.existsById(lessonId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<LessonDto>> findAll() {
        return ResponseEntity.ok(lessonService.findAll());
    }

    @DeleteMapping("/deleteById/{lessonId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer lessonId) {
        lessonService.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        lessonService.deleteById(lessonId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody LessonDto lessonDto) {
        lessonService.findById(lessonDto.getId())
                .orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        lessonService.delete(lessonDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<LessonDto> lessonDtos) {
        lessonDtos.forEach(l -> lessonService
                .findById(l.getId())
                .orElseThrow(() -> new DataNotFoundException("Lesson not found")));
        lessonService.deleteAll(lessonDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        lessonService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
