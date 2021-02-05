package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.model.UserDto;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDto save(UserDto userDto) {
        return userRepository.save(userDto);
    }

    public Iterable<UserDto> saveAll(Collection<UserDto> userDtos) {
        return userRepository.saveAll(userDtos);
    }

    public Optional<UserDto> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    public boolean existsById(Integer userId) {
        return userRepository.existsById(userId);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void delete(UserDto userDto) {
        userRepository.delete(userDto);
    }

    public void deleteAll(Collection<UserDto> userDtos) {
        userRepository.deleteAll(userDtos);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
