package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.entity.Test;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("/saveTest")
    public Test save(Test test) {
        return testService.save(test);
    }

    @PostMapping("/saveTests")
    public Iterable<Test> saveAll(Collection<Test> tests) {
        return testService.saveAll(tests);
    }

    @GetMapping("/findById/{testId}")
    public ResponseEntity<Test> findById(@PathVariable Integer testId) {
        Test test = testService.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test not found"));
        return ResponseEntity.ok().body(test);
    }

    @GetMapping("/existsById/{testId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer testId) {
        return ResponseEntity.ok().body(testService.existsById(testId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Test>> findAll() {
        return ResponseEntity.ok(testService.findAll());
    }

    @DeleteMapping("/deleteById/{testId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer testId) {
        testService.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test not found"));
        testService.deleteById(testId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Test test) {
        testService.findById(test.getId())
                .orElseThrow(() -> new DataNotFoundException("Test not found"));
        testService.delete(test);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<Test> tests) {
        tests.forEach(t -> testService
                .findById(t.getId())
                .orElseThrow(() -> new DataNotFoundException("Test not found")));
        testService.deleteAll(tests);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        testService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{testId}")
    public ResponseEntity<Test> updateTest(@PathVariable Integer testId,
                                           @RequestBody Test test) {
        Test t = testService.findById(testId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Test with id=" + testId + " not found exception "));
     //   t.setLevel(test.getLevel());
     //   t.setCountOfQuestions(test.getCountOfQuestions());
        t.setName(test.getName());

        return ResponseEntity.ok(this.testService.save(t));
    }
}
