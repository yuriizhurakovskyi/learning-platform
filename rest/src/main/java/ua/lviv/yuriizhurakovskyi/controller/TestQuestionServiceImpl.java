package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestionDto;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.Collection;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/test_question")
@RequiredArgsConstructor
public class TestQuestionServiceImpl {
    private final TestQuestionService testQuestionService;

    @PostMapping("/saveTestQuestion")
    public TestQuestionDto save(TestQuestionDto testQuestionDto) {
        return testQuestionService.save(testQuestionDto);
    }

    @PostMapping("/saveTestQuestions")
    public Iterable<TestQuestionDto> saveAll(Collection<TestQuestionDto> testQuestionDtos) {
        return testQuestionService.saveAll(testQuestionDtos);
    }

    @GetMapping("/findById/{testQuestionId}")
    public Optional<TestQuestionDto> findById(@PathVariable Integer testQuestionId) {
        return testQuestionService.findById(testQuestionId);
    }

    @GetMapping("/existsById/{testQuestionId}")
    public boolean existsById(@PathVariable Integer testQuestionId) {
        return testQuestionService.existsById(testQuestionId);
    }

    @GetMapping("/findAll")
    public Iterable<TestQuestionDto> findAll() {
        return testQuestionService.findAll();
    }

    @DeleteMapping("/deleteById/{testQuestionId}")
    public void deleteById(@PathVariable Integer testQuestionId) {
        testQuestionService.deleteById(testQuestionId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody TestQuestionDto testQuestionDto) {
        testQuestionService.delete(testQuestionDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<TestQuestionDto> testQuestionDtos) {
        testQuestionService.deleteAll(testQuestionDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        testQuestionService.deleteAll();
    }

}