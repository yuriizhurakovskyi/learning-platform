package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/")
    public Lesson save(Lesson lesson) {
        return lessonService.save(lesson);
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> findById(@PathVariable Integer lessonId) {
        return ResponseEntity.ok().body(lessonService.findById(lessonId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Lesson>> findAll() {
        return ResponseEntity.ok(lessonService.findAll());
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer lessonId) {
        lessonService.deleteById(lessonId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(this.lessonService.update(lesson));
    }
}
