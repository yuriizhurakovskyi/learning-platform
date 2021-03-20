package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Course;

@Component
@AllArgsConstructor
public class CourseDtoResponseMapper {

    private final UserDtoResponseMapper userDtoResponseMapper;

    public CourseDtoResponse map(Course course) {
        UserDtoResponse userDtoResponse = userDtoResponseMapper.map(course.getAddedBy());

        return CourseDtoResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .level(course.getLevel())
                .addedBy(userDtoResponse)
                .build();
    }
}
