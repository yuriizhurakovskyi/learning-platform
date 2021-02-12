package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public Course save(Course course) {
        return courseService.save(course);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> findById(@PathVariable Integer courseId) {
        return ResponseEntity.ok().body(courseService.findById(courseId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer courseId) {
        courseService.deleteById(courseId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return ResponseEntity.ok(this.courseService.update(course));
    }
}
