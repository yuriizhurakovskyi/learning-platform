package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.UserDto;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.Collection;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/saveUser")
    public UserDto save(UserDto userDto) {
        return userService.save(userDto);
    }

    @PostMapping("/saveUsers")
    public Iterable<UserDto> saveAll(Collection<UserDto> userDtos) {
        return userService.saveAll(userDtos);
    }

    @GetMapping("/findById/{userId}")
    public Optional<UserDto> findById(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping("/existsById/{userId}")
    public boolean existsById(@PathVariable Integer userId) {
        return userService.existsById(userId);
    }

    @GetMapping("/findAll")
    public Iterable<UserDto> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/deleteById/{userId}")
    public void deleteById(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody UserDto userDto) {
        userService.delete(userDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<UserDto> userDtos) {
        userService.deleteAll(userDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        userService.deleteAll();
    }

}
