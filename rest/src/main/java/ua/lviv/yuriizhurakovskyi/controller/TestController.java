package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.test.TestDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/")
    public ResponseEntity<TestDtoResponse> save(@RequestBody TestDtoRequest testDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testService.save(testDtoRequest));
    }

    @GetMapping("/{testId}")
    public ResponseEntity<TestDtoResponse> findById(@PathVariable Long testId) {
        return ResponseEntity.ok().body(testService.findById(testId));
    }

    @GetMapping("/")
    public ResponseEntity<List<TestDtoResponse>> findAll() {
        return ResponseEntity.ok(testService.findAll());
    }

    @DeleteMapping("/{testId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long testId) {
        testService.deleteById(testId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<TestDtoResponse> updateTest(@RequestBody TestDtoRequest testDtoRequest) {
        return ResponseEntity.ok(this.testService.update(testDtoRequest));
    }
}
