package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDtoResponse> save(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDtoRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDtoResponse> findById(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.findById(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDtoResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<UserDtoResponse> updateUser(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.ok(this.userService.update(userDtoRequest));
    }
}
