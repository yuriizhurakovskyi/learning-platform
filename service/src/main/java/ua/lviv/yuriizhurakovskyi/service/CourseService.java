package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Course;

import java.util.Collection;
import java.util.Optional;

public interface CourseService{
    Course save(Course course);

    Iterable<Course> saveAll(Collection<Course> courses);

    Optional<Course> findById(Integer courseId);

    boolean existsById(Integer courseId);

    Iterable<Course> findAll();

    void deleteById(Integer courseId);

    void delete(Course course);

    void deleteAll(Collection<Course> courses);

    void deleteAll();
}
