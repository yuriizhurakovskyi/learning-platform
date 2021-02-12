package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Course;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseService{
    Course save(Course course);

    Iterable<Course> saveAll(Collection<Course> cours);

    Optional<Course> findById(Integer courseId);

    boolean existsById(Integer courseId);

    List<Course> findAll();

    void deleteById(Integer courseId);

    void delete(Course course);

    void deleteAll(Collection<Course> cours);

    void deleteAll();
}
