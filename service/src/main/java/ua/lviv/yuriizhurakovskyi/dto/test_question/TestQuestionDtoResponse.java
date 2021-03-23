package ua.lviv.yuriizhurakovskyi.dto.test_question;

import lombok.*;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoResponse;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TestQuestionDtoResponse {

    private Long id;

    private String question;

    private String answer;

    private TestDtoResponse testDtoResponse;
}
