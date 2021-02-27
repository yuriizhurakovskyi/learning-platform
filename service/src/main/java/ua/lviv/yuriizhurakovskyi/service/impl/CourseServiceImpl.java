package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.CourseDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.CourseDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.CourseRepository;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseDtoRequestMapper courseDtoRequestMapper;
    private final CourseDtoResponseMapper courseDtoResponseMapper;

    @Override
    public CourseDtoResponse save(CourseDtoRequest courseDtoRequest) {
        Course course = courseDtoRequestMapper.map(courseDtoRequest);
        course = courseRepository.save(course);
        return courseDtoResponseMapper.map(course);
    }

    @Override
    public CourseDtoResponse findById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Course with id=" + courseId + " not found exception "));
        return courseDtoResponseMapper.map(course);
    }

    @Override
    public List<CourseDtoResponse> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(courseDtoResponseMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long courseId) {
        this.findById(courseId);
        courseRepository.deleteById(courseId);
    }

    @Override
    public CourseDtoResponse update(CourseDtoRequest courseDtoRequest) {
        Course course = courseDtoRequestMapper.map(courseDtoRequest);
        Long courseId = courseDtoRequest.getId();
        Course c = courseRepository.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Course with id=" + courseId + " not found exception "));
        c.setName(course.getName());
        c.setLevel(course.getLevel());
        c.setAddedBy(course.getAddedBy());
        c = courseRepository.save(c);
        return courseDtoResponseMapper.map(c);
    }
}
