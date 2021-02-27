package ua.lviv.yuriizhurakovskyi.dto.lesson;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class LessonDtoRequest {
    private Long id;

    private String lectureTopic;

    private String description;

    private Long courseId;
}
