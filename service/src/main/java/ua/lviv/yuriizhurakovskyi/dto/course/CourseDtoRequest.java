package ua.lviv.yuriizhurakovskyi.dto.course;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.entity.Level;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class CourseDtoRequest {

    private Long id;

    private String name;

    private Level level;

    private Long addedBy;
}
