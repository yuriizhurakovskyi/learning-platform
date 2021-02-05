package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.TestDto;
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
    public TestDto save(TestDto testDto) {
        return testService.save(testDto);
    }

    @PostMapping("/saveTests")
    public Iterable<TestDto> saveAll(Collection<TestDto> testDtos) {
        return testService.saveAll(testDtos);
    }

    @GetMapping("/findById/{testId}")
    public ResponseEntity<TestDto> findById(@PathVariable Integer testId) {
        TestDto testDto = testService.findById(testId)
                .orElseThrow(() -> new DataNotFoundException("Test not found"));
        return ResponseEntity.ok().body(testDto);
    }

    @GetMapping("/existsById/{testId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer testId) {
        return ResponseEntity.ok().body(testService.existsById(testId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TestDto>> findAll() {
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
    public ResponseEntity<Void> delete(@RequestBody TestDto testDto) {
        testService.findById(testDto.getId())
                .orElseThrow(() -> new DataNotFoundException("Test not found"));
        testService.delete(testDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<TestDto> testDtos) {
        testDtos.forEach(t -> testService
                .findById(t.getId())
                .orElseThrow(() -> new DataNotFoundException("Test not found")));
        testService.deleteAll(testDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        testService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
