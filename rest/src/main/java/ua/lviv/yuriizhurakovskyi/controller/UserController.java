package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.UserDto;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.Collection;
import java.util.List;

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
    public ResponseEntity<UserDto> findById(@PathVariable Integer userId) {
        UserDto userDto = userService.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/existsById/{userId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(userService.existsById(userId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/deleteById/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer userId) {
        userService.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody UserDto userDto) {
        userService.findById(userDto.getId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        userService.delete(userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<UserDto> userDtos) {
        userDtos.forEach(u -> userService
                .findById(u.getId())
                .orElseThrow(() -> new DataNotFoundException("User not found")));
        userService.deleteAll(userDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        userService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
