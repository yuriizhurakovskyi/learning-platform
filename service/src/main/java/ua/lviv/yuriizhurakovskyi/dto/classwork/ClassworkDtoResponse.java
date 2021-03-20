package ua.lviv.yuriizhurakovskyi.dto.classwork;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ClassworkDtoResponse {

    private Long id;

    private LocalDateTime date;

    private String solution;

    private String result;

    private TaskDtoResponse task;

    private UserDtoResponse teacher;

    private UserDtoResponse student;
}
