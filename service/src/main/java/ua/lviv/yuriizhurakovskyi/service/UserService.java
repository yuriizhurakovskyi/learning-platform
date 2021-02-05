package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.model.UserDto;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    UserDto save(UserDto userDto);

    Iterable<UserDto> saveAll(Collection<UserDto> userDtos);

    Optional<UserDto> findById(Integer userId);

    boolean existsById(Integer userId);

    Iterable<UserDto> findAll();

    void deleteById(Integer userId);

    void delete(UserDto userDto);

    void deleteAll(Collection<UserDto> userDtos);

    void deleteAll();
}
