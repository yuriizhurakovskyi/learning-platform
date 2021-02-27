package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Course;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDtoResponse save(CourseDtoRequest courseDtoRequest);

    CourseDtoResponse findById(Long courseId);

    List<CourseDtoResponse> findAll();

    void deleteById(Long courseId);

    CourseDtoResponse update(CourseDtoRequest courseDtoRequest);
}
