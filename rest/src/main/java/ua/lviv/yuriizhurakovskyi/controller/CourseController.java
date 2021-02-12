package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<CourseDtoResponse> save(@RequestBody CourseDtoRequest courseDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(courseDtoRequest));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDtoResponse> findById(@PathVariable Long courseId) {
        return ResponseEntity.ok().body(courseService.findById(courseId));
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDtoResponse>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long courseId) {
        courseService.deleteById(courseId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<CourseDtoResponse> updateCourse(@RequestBody CourseDtoRequest courseDtoRequest) {
        return ResponseEntity.ok(this.courseService.update(courseDtoRequest));
    }
}
