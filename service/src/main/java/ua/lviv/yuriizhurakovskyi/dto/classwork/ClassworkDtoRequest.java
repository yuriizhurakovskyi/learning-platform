package ua.lviv.yuriizhurakovskyi.dto.classwork;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ClassworkDtoRequest {
    private Long id;

    private LocalDateTime date;

    private String solution;

    private String result;

    private Long taskId;

    private Long teacherId;

    private Long studentId;
}
