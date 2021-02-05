package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.CourseDto;

import java.util.Collection;
import java.util.Optional;

public interface CourseService{
    CourseDto save(CourseDto courseDto);

    Iterable<CourseDto> saveAll(Collection<CourseDto> cours);

    Optional<CourseDto> findById(Integer courseId);

    boolean existsById(Integer courseId);

    Iterable<CourseDto> findAll();

    void deleteById(Integer courseId);

    void delete(CourseDto courseDto);

    void deleteAll(Collection<CourseDto> cours);

    void deleteAll();
}
