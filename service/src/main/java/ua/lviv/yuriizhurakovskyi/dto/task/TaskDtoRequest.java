package ua.lviv.yuriizhurakovskyi.dto.task;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TaskDtoRequest {

    private Long id;

    private String description;

    private Long lessonId;
}
