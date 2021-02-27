package ua.lviv.yuriizhurakovskyi.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.User;

@Component
public class UserDtoResponseMapper {

    public UserDtoResponse map(User user) {
        return UserDtoResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .level(user.getLevel())
                .role(user.getRole())
                .build();
    }
}
