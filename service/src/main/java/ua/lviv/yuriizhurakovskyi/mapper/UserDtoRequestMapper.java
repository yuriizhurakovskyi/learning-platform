package ua.lviv.yuriizhurakovskyi.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.User;

@Component
public class UserDtoRequestMapper {

    public User map(UserDtoRequest userDtoRequest) {
        return User.builder()
                .id(userDtoRequest.getId())
                .firstName(userDtoRequest.getFirstName())
                .lastName(userDtoRequest.getLastName())
                .dateOfBirth(userDtoRequest.getDateOfBirth())
                .level(userDtoRequest.getLevel())
                .role(userDtoRequest.getRole())
                .build();
    }
}