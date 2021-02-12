package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public Test save(Test test) {
        return testService.save(test);
    }

    @GetMapping("/{testId}")
    public ResponseEntity<Test> findById(@PathVariable Integer testId) {
        return ResponseEntity.ok().body(testService.findById(testId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Test>> findAll() {
        return ResponseEntity.ok(testService.findAll());
    }

    @DeleteMapping("/{testId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer testId) {
        testService.deleteById(testId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Test> updateTest(@RequestBody Test test) {
        return ResponseEntity.ok(this.testService.update(test));
    }
}
