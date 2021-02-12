package ua.lviv.yuriizhurakovskyi.dto.user;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.entity.Level;
import ua.lviv.yuriizhurakovskyi.entity.Role;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserDtoResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private Level level;

    private LocalDateTime dateOfBirth;

    private Role role;
}
