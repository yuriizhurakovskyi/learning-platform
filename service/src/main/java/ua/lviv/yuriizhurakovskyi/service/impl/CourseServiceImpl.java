package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Course;
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
    public Iterable<Course> saveAll(Collection<Course> cours) {
        return courseRepository.saveAll(cours);
    }

    @Override
    public Optional<Course> findById(Integer courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public boolean existsById(Integer courseId) {
        return courseRepository.existsById(courseId);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteById(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }

    @Override
    public void deleteAll(Collection<Course> cours) {
        courseRepository.deleteAll(cours);
    }

    @Override
    public void deleteAll() {
        courseRepository.deleteAll();
    }
}
