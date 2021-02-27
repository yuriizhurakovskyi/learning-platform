package ua.lviv.yuriizhurakovskyi.dto.test_question;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TestQuestionDtoRequest {
    private Long id;

    private String question;

    private String answer;

    private Long testId;
}
