package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Task;

@Component
@AllArgsConstructor
public class TaskDtoResponseMapper {
    private final LessonDtoResponseMapper lessonDtoResponseMapper;

    public TaskDtoResponse map(Task task) {
        LessonDtoResponse lessonDtoResponse = lessonDtoResponseMapper.map(task.getLesson());
        return TaskDtoResponse.builder()
                .id(task.getId())
                .description(task.getDescription())
                .lessonDtoResponse(lessonDtoResponse)
                .build();
    }
}
