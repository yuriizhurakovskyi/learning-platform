package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.CourseDto;
import ua.lviv.yuriizhurakovskyi.repository.CourseRepository;
import ua.lviv.yuriizhurakovskyi.service.CourseService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseDto save(CourseDto courseDto) {
        return courseRepository.save(courseDto);
    }

    @Override
    public Iterable<CourseDto> saveAll(Collection<CourseDto> cours) {
        return courseRepository.saveAll(cours);
    }

    @Override
    public Optional<CourseDto> findById(Integer courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public boolean existsById(Integer courseId) {
        return courseRepository.existsById(courseId);
    }

    @Override
    public Iterable<CourseDto> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteById(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void delete(CourseDto courseDto) {
        courseRepository.delete(courseDto);
    }

    @Override
    public void deleteAll(Collection<CourseDto> cours) {
        courseRepository.deleteAll(cours);
    }

    @Override
    public void deleteAll() {
        courseRepository.deleteAll();
    }
}
