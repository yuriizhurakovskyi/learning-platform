package ua.lviv.yuriizhurakovskyi.dto.lesson;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoResponse;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class LessonDtoResponse {
    private Long id;

    private String lectureTopic;

    private String description;

    private CourseDtoResponse courseDtoResponse;
}
