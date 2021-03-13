package ua.lviv.yuriizhurakovskyi.dto.jwt;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class JwtResponse {
    private final String jwtToken;
}
