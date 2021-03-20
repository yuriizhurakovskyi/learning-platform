package ua.lviv.yuriizhurakovskyi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDtoResponse save(UserDtoRequest userDtoRequest);

    UserDtoResponse findById(Long userId);

    List<UserDtoResponse> findAll();

    void deleteById(Long userId);

    UserDtoResponse update(UserDtoRequest userDtoRequest);

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
