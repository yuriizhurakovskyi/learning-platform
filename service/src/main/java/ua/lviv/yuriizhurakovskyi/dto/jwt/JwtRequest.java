package ua.lviv.yuriizhurakovskyi.dto.jwt;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class JwtRequest{
    private String username;
    private String password;
}