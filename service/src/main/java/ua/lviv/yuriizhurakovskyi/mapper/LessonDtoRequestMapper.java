package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.CourseRepository;

@Component
@AllArgsConstructor
public class LessonDtoRequestMapper {

    private final CourseRepository courseRepository;

    public Lesson map(LessonDtoRequest lessonDtoRequest) {
        Long courseId = lessonDtoRequest.getCourseId();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new DataNotFoundException("Course with id=" + courseId + " not found exception "));
        return Lesson.builder()
                .id(lessonDtoRequest.getId())
                .course(course)
                .lectureTopic(lessonDtoRequest.getLectureTopic())
                .description(lessonDtoRequest.getDescription())
                .build();
    }
}
