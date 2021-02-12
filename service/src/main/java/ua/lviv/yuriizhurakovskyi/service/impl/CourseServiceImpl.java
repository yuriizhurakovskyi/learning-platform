package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.CourseRepository;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Integer courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Course with id=" + courseId + " not found exception "));
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteById(Integer courseId) {
        this.findById(courseId);
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course update(Course course) {
        Integer courseId = course.getId();
        Course c = this.findById(courseId);
        c.setName(course.getName());
        c.setLevel(course.getLevel());
        return courseRepository.save(c);
    }
}
