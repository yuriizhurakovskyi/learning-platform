package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;

@Component
@AllArgsConstructor
public class LessonDtoResponseMapper {

    private final CourseDtoResponseMapper courseDtoResponseMapper;

    public LessonDtoResponse map(Lesson lesson) {
        CourseDtoResponse courseDtoResponse = courseDtoResponseMapper.map(lesson.getCourse());

        return LessonDtoResponse.builder()
                .id(lesson.getId())
                .lectureTopic(lesson.getLectureTopic())
                .description(lesson.getDescription())
                .courseDtoResponse(courseDtoResponse)
                .build();
    }
}
