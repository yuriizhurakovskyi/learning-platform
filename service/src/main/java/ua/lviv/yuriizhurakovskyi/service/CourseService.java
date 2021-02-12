package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Course;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course course);

    Course findById(Integer courseId);

    List<Course> findAll();

    void deleteById(Integer courseId);

    Course update(Course course);
}
