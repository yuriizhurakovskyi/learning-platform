package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.User;

import java.util.List;

public interface UserService {
    UserDtoResponse save(UserDtoRequest userDtoRequest);

    UserDtoResponse findById(Long userId);

    List<UserDtoResponse> findAll();

    void deleteById(Long userId);

    UserDtoResponse update(UserDtoRequest userDtoRequest);
}
