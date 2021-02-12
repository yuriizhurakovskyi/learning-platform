package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;
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
    public TestQuestion save(TestQuestion testQuestion) {
        return testQuestionService.save(testQuestion);
    }

    @PostMapping("/saveTestQuestions")
    public Iterable<TestQuestion> saveAll(Collection<TestQuestion> testQuestions) {
        return testQuestionService.saveAll(testQuestions);
    }

    @GetMapping("/findById/{testQuestionId}")
    public ResponseEntity<TestQuestion> findById(@PathVariable Integer testQuestionId) {
        TestQuestion testQuestion = testQuestionService.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException("Test question not found"));
        return ResponseEntity.ok().body(testQuestion);
    }

    @GetMapping("/existsById/{testQuestionId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer testQuestionId) {
        return ResponseEntity.ok().body(testQuestionService.existsById(testQuestionId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TestQuestion>> findAll() {
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
    public ResponseEntity<Void> delete(@RequestBody TestQuestion testQuestion) {
        testQuestionService.findById(testQuestion.getId())
                .orElseThrow(() -> new DataNotFoundException("Test question not found"));
        testQuestionService.delete(testQuestion);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<TestQuestion> testQuestions) {
        testQuestions.forEach(t -> testQuestionService
                .findById(t.getId())
                .orElseThrow(() -> new DataNotFoundException("Test question not found")));
        testQuestionService.deleteAll(testQuestions);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        testQuestionService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{testQuestionId}")
    public ResponseEntity<TestQuestion> updateTestQuestion(@PathVariable Integer testQuestionId,
                                                           @RequestBody TestQuestion testQuestion) {
        TestQuestion qd = testQuestionService.findById(testQuestionId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Test Question with id=" + testQuestionId + " not found exception "));
        qd.setQuestion(testQuestion.getQuestion());
        qd.setAnswer(testQuestion.getAnswer());

        return ResponseEntity.ok(this.testQuestionService.save(qd));
    }
}