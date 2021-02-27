package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoResponse;
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
    public ResponseEntity<LessonDtoResponse> save(@RequestBody LessonDtoRequest lessonDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.save(lessonDtoRequest));
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonDtoResponse> findById(@PathVariable Long lessonId) {
        return ResponseEntity.ok().body(lessonService.findById(lessonId));
    }

    @GetMapping("/")
    public ResponseEntity<List<LessonDtoResponse>> findAll() {
        return ResponseEntity.ok(lessonService.findAll());
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long lessonId) {
        lessonService.deleteById(lessonId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<LessonDtoResponse> updateLesson(@RequestBody LessonDtoRequest lessonDtoRequest) {
        return ResponseEntity.ok(this.lessonService.update(lessonDtoRequest));
    }
}
