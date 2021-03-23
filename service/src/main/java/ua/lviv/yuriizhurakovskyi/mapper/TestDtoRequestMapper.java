package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;

@Component
@AllArgsConstructor
public class TestDtoRequestMapper {

    private final UserRepository userRepository;

    public Test map(TestDtoRequest testDtoRequest) {
        Long addedById = testDtoRequest.getAddedBy();
        User addedBy = userRepository.findById(addedById)
                .orElseThrow(() -> new DataNotFoundException("User with id=" + addedById + " not found exception "));

        return Test.builder()
                .id(testDtoRequest.getId())
                .name(testDtoRequest.getName())
                .addedBy(
                        User.builder()
                                .id(addedBy.getId())
                                .role(addedBy.getRole())
                                .firstName(addedBy.getFirstName())
                                .lastName(addedBy.getLastName())
                                .dateOfBirth(addedBy.getDateOfBirth())
                                .level(addedBy.getLevel())
                                .build()
                )
                .build();
    }
}
