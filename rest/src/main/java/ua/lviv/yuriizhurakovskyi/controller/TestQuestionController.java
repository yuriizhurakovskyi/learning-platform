package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.test_question.TestQuestionDtoResponse;
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
    public ResponseEntity<TestQuestionDtoResponse> save(@RequestBody TestQuestionDtoRequest testQuestionDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testQuestionService.save(testQuestionDtoRequest));
    }

    @GetMapping("/{testQuestionId}")
    public ResponseEntity<TestQuestionDtoResponse> findById(@PathVariable Long testQuestionId) {
        return ResponseEntity.ok().body(testQuestionService.findById(testQuestionId));
    }

    @GetMapping("/")
    public ResponseEntity<List<TestQuestionDtoResponse>> findAll() {
        return ResponseEntity.ok(testQuestionService.findAll());
    }

    @DeleteMapping("/{testQuestionId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long testQuestionId) {
        testQuestionService.deleteById(testQuestionId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<TestQuestionDtoResponse> updateTestQuestion(
            @RequestBody TestQuestionDtoRequest testQuestionDtoRequest) {
        return ResponseEntity.ok(this.testQuestionService.update(testQuestionDtoRequest));
    }
}