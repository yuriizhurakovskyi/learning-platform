package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.TestDto;
import ua.lviv.yuriizhurakovskyi.service.TestService;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<TestDto> findById(@PathVariable Integer testId) {
        return testService.findById(testId);
    }

    @GetMapping("/existsById/{testId}")
    public boolean existsById(@PathVariable Integer testId) {
        return testService.existsById(testId);
    }

    @GetMapping("/findAll")
    public Iterable<TestDto> findAll() {
        return testService.findAll();
    }

    @DeleteMapping("/deleteById/{testId}")
    public void deleteById(@PathVariable Integer testId) {
        testService.deleteById(testId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody TestDto testDto) {
        testService.delete(testDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<TestDto> testDtos) {
        testService.deleteAll(testDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        testService.deleteAll();
    }

}
