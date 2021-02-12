package ua.lviv.yuriizhurakovskyi.dto.course;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Level;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class CourseDtoResponse {
    private Long id;

    private String name;

    private Level level;

    private UserDtoResponse addedBy;
}
