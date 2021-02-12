package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
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
    public Lesson save(Lesson lesson) {
        return lessonService.save(lesson);
    }

    @PostMapping("/saveLessons")
    public Iterable<Lesson> saveAll(Collection<Lesson> lessons) {
        return lessonService.saveAll(lessons);
    }

    @GetMapping("/findById/{lessonId}")
    public ResponseEntity<Lesson> findById(@PathVariable Integer lessonId) {
        Lesson lesson = lessonService.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        return ResponseEntity.ok().body(lesson);
    }

    @GetMapping("/existsById/{lessonId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer lessonId) {
        return ResponseEntity.ok().body(lessonService.existsById(lessonId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Lesson>> findAll() {
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
    public ResponseEntity<Void> delete(@RequestBody Lesson lesson) {
        lessonService.findById(lesson.getId())
                .orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        lessonService.delete(lesson);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<Lesson> lessons) {
        lessons.forEach(l -> lessonService
                .findById(l.getId())
                .orElseThrow(() -> new DataNotFoundException("Lesson not found")));
        lessonService.deleteAll(lessons);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        lessonService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Integer lessonId,
                                               @RequestBody Lesson lesson) {
        Lesson l = lessonService.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Lesson with id=" + lessonId + " not found exception "));
        l.setDescription(lesson.getDescription());
        l.setLectureTopic(lesson.getLectureTopic());

        return ResponseEntity.ok(this.lessonService.save(l));
    }
}
