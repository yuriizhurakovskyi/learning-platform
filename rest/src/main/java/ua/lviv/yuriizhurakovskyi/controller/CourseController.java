package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.CourseDto;
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
    public CourseDto save(CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @PostMapping("/saveCourses")
    public Iterable<CourseDto> saveAll(Collection<CourseDto> courseDtos) {
        return courseService.saveAll(courseDtos);
    }

    @GetMapping("/findById/{courseId}")
    public ResponseEntity<CourseDto> findById(@PathVariable Integer courseId) {
        CourseDto courseDto = courseService.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        return ResponseEntity.ok().body(courseDto);
    }

    @GetMapping("/existsById/{courseId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer courseId) {
        return ResponseEntity.ok().body(courseService.existsById(courseId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CourseDto>> findAll() {
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
    public ResponseEntity<Void> delete(@RequestBody CourseDto courseDto) {
        courseService.findById(courseDto.getId())
                .orElseThrow(() -> new DataNotFoundException("Course not found"));
        courseService.delete(courseDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<CourseDto> courseDtos) {
        courseDtos.forEach(c -> courseService
                .findById(c.getId())
                .orElseThrow(() -> new DataNotFoundException("Classwork not found")));
        courseService.deleteAll(courseDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        courseService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
