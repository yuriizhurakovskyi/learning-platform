package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
import ua.lviv.yuriizhurakovskyi.service.TestQuestionService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/test_question")
@RequiredArgsConstructor
public class TestQuestionController {
    private final TestQuestionService testQuestionService;

    @PostMapping("/")
    public TestQuestion save(@RequestBody TestQuestion testQuestion) {
        return testQuestionService.save(testQuestion);
    }

    @GetMapping("/{testQuestionId}")
    public ResponseEntity<TestQuestion> findById(@PathVariable Integer testQuestionId) {
        return ResponseEntity.ok().body(testQuestionService.findById(testQuestionId));
    }

    @GetMapping("/")
    public ResponseEntity<List<TestQuestion>> findAll() {
        return ResponseEntity.ok(testQuestionService.findAll());
    }

    @DeleteMapping("/{testQuestionId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer testQuestionId) {
        testQuestionService.deleteById(testQuestionId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<TestQuestion> updateTestQuestion(@RequestBody TestQuestion testQuestion) {
        return ResponseEntity.ok(this.testQuestionService.update(testQuestion));
    }
}