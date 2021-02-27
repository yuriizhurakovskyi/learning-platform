package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.course.CourseDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.Course;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;

@Component
@AllArgsConstructor
public class CourseDtoRequestMapper {
    private final UserRepository userRepository;

    public Course map(CourseDtoRequest courseDtoRequest) {
        Long userId = courseDtoRequest.getAddedBy();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User with id=" + userId + " not found exception "));

        return Course.builder()
                .id(courseDtoRequest.getId())
                .name(courseDtoRequest.getName())
                .level(courseDtoRequest.getLevel())
                .addedBy(user)
                .build();
    }
}