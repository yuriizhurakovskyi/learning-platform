package ua.lviv.yuriizhurakovskyi.dto.task;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.dto.lesson.LessonDtoResponse;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TaskDtoResponse {
    private Long id;

    private String description;

    private LessonDtoResponse lessonDtoResponse;
}
