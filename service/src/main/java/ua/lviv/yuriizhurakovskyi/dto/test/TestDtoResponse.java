package ua.lviv.yuriizhurakovskyi.dto.test;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TestDtoResponse {
    private Long id;

    private String name;

    private UserDtoResponse addedBy;
}
