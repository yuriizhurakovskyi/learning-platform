package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.LessonRepository;

@Component
@AllArgsConstructor
public class TaskDtoRequestMapper {
    private final LessonRepository lessonRepository;

    public Task map(TaskDtoRequest taskDtoRequest) {
        Long lessonId = taskDtoRequest.getLessonId();
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new DataNotFoundException("Lesson with id=" + lessonId + " not found exception "));
        return Task.builder()
                .id(taskDtoRequest.getId())
                .description(taskDtoRequest.getDescription())
                .lesson(lesson)
                .build();
    }
}
