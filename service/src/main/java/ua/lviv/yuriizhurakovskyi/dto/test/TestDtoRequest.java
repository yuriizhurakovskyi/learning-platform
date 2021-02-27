package ua.lviv.yuriizhurakovskyi.dto.test;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TestDtoRequest {
    private Long id;

    private String name;

    private Long addedBy;
}
