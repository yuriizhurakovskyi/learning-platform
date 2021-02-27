package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Test;

@Component
@AllArgsConstructor
public class TestDtoResponseMapper {
    private final UserDtoResponseMapper userDtoResponseMapper;

    public TestDtoResponse map(Test test) {
        UserDtoResponse userDtoResponse = userDtoResponseMapper.map(test.getAddedBy());
        return TestDtoResponse.builder()
                .id(test.getId())
                .name(test.getName())
                .addedBy(userDtoResponse)
                .build();
    }
}
