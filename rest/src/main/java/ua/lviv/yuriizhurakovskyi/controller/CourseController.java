package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.model.CourseDto;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<CourseDto> findById(@PathVariable Integer courseId) {
        return courseService.findById(courseId);
    }

    @GetMapping("/existsById/{courseId}")
    public boolean existsById(@PathVariable Integer courseId) {
        return courseService.existsById(courseId);
    }

    @GetMapping("/findAll")
    public Iterable<CourseDto> findAll() {
        return courseService.findAll();
    }

    @DeleteMapping("/deleteById/{courseId}")
    public void deleteById(@PathVariable Integer courseId) {
        courseService.deleteById(courseId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody CourseDto courseDto) {
        courseService.delete(courseDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<CourseDto> courseDtos) {
        courseService.deleteAll(courseDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        courseService.deleteAll();
    }
}
