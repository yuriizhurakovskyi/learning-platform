package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.repository.CourseRepository;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.Collection;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    private Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        if (course != null) {
            logger.debug("Save Course: " + course);
        }
        return courseRepository.save(course);
    }

    @Override
    public Iterable<Course> saveAll(Collection<Course> courses) {
        if (!courses.isEmpty()) {
            logger.debug("Save all courses: " + courses);
        }
        return courseRepository.saveAll(courses);
    }

    @Override
    public Optional<Course> findById(Integer courseId) {
        logger.debug("Find Course by id" + courseId);
        return courseRepository.findById(courseId);
    }

    @Override
    public boolean existsById(Integer courseId) {
        logger.debug("Exists Course by id: " + courseId);
        return courseRepository.existsById(courseId);
    }

    @Override
    public Iterable<Course> findAll() {
        logger.debug("Find All Courses");
        return courseRepository.findAll();
    }

    @Override
    public void deleteById(Integer courseId) {
        logger.debug("Delete Course by id");
        courseRepository.deleteById(courseId);
    }

    @Override
    public void delete(Course course) {
        logger.debug("Delete course: " + course);
        courseRepository.delete(course);
    }

    @Override
    public void deleteAll(Collection<Course> courses) {
        logger.debug("Delete collections of courses: " + courses);
        courseRepository.deleteAll(courses);
    }

    @Override
    public void deleteAll() {
        logger.debug("Delete all courses");
        courseRepository.deleteAll();
    }
}
