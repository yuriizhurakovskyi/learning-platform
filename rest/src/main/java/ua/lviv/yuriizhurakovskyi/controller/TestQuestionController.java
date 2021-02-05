package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.TestQuestionDto;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/test_question")
@RequiredArgsConstructor
public class TestQuestionController {
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
    public ResponseEntity<TestQuestionDto> findById(@PathVariable Integer testQuestionId) {
        TestQuestionDto testQuestionDto = testQuestionService.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException("Test question not found"));
        return ResponseEntity.ok().body(testQuestionDto);
    }

    @GetMapping("/existsById/{testQuestionId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer testQuestionId) {
        return ResponseEntity.ok().body(testQuestionService.existsById(testQuestionId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TestQuestionDto>> findAll() {
        return ResponseEntity.ok(testQuestionService.findAll());
    }

    @DeleteMapping("/deleteById/{testQuestionId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer testQuestionId) {
        testQuestionService.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException("Test question not found"));
        testQuestionService.deleteById(testQuestionId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody TestQuestionDto testQuestionDto) {
        testQuestionService.findById(testQuestionDto.getId())
                .orElseThrow(() -> new DataNotFoundException("Test question not found"));
        testQuestionService.delete(testQuestionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<TestQuestionDto> testQuestionDtos) {
        testQuestionDtos.forEach(t -> testQuestionService
                .findById(t.getId())
                .orElseThrow(() -> new DataNotFoundException("Test question not found")));
        testQuestionService.deleteAll(testQuestionDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        testQuestionService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{testQuestionId}")
    public ResponseEntity<TestQuestionDto> updateTestQuestion(@PathVariable Integer testQuestionId,
                                                      @RequestBody TestQuestionDto testQuestionDto) {
        TestQuestionDto qd = testQuestionService.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Test Question with id=" + testQuestionId + " not found exception "));
        qd.setQuestion(testQuestionDto.getQuestion());
        qd.setAnswer(testQuestionDto.getAnswer());

        return ResponseEntity.ok(this.testQuestionService.save(qd));
    }
}