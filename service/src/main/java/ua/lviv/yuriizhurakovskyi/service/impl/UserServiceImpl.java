package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.UserDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.UserDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDtoRequestMapper userDtoRequestMapper;
    private final UserDtoResponseMapper userDtoResponseMapper;

    public UserDtoResponse save(UserDtoRequest userDtoRequest) {
        User user = userDtoRequestMapper.map(userDtoRequest);
        user = userRepository.save(user);
        return userDtoResponseMapper.map(user);
    }

    public UserDtoResponse findById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User with id=" + userId + " not found exception "));
        return userDtoResponseMapper.map(user);
    }

    public List<UserDtoResponse> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userDtoResponseMapper::map).collect(Collectors.toList());
    }

    public void deleteById(Long userId) {
        this.findById(userId);
        userRepository.deleteById(userId);
    }

    public UserDtoResponse update(UserDtoRequest userDtoRequest) {
        User user = userDtoRequestMapper.map(userDtoRequest);
        Long userId = user.getId();
        User u = userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User with id=" + userId + " not found exception "));
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setLevel(user.getLevel());
        u.setDateOfBirth(user.getDateOfBirth());
        u.setRole(user.getRole());
        u = userRepository.save(u);
        return userDtoResponseMapper.map(u);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
    }
}
