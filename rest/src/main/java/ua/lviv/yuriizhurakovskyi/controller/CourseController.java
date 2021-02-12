package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/saveCourse")
    public Course save(Course course) {
        return courseService.save(course);
    }

    @PostMapping("/saveCourses")
    public Iterable<Course> saveAll(Collection<Course> courses) {
        return courseService.saveAll(courses);
    }

    @GetMapping("/findById/{courseId}")
    public ResponseEntity<Course> findById(@PathVariable Integer courseId) {
        Course course = courseService.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        return ResponseEntity.ok().body(course);
    }

    @GetMapping("/existsById/{courseId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer courseId) {
        return ResponseEntity.ok().body(courseService.existsById(courseId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @DeleteMapping("/deleteById/{courseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer courseId) {
        courseService.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Course not found"));
        courseService.deleteById(courseId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Course course) {
        courseService.findById(course.getId())
                .orElseThrow(() -> new DataNotFoundException("Course not found"));
        courseService.delete(course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<Course> courses) {
        courses.forEach(c -> courseService
                .findById(c.getId())
                .orElseThrow(() -> new DataNotFoundException("Classwork not found")));
        courseService.deleteAll(courses);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        courseService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer courseId,
                                               @RequestBody Course course) {
        Course c = courseService.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Course with id=" + courseId + " not found exception "));
        c.setName(course.getName());
        c.setLevel(course.getLevel());

        return ResponseEntity.ok(this.courseService.save(c));
    }
}
