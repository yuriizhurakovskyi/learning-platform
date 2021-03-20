package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoResponse;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/classwork")
@RequiredArgsConstructor
public class ClassworkController {

    private final ClassworkService classworkService;

    @PostMapping("/")
    public ResponseEntity<ClassworkDtoResponse> save(@RequestBody ClassworkDtoRequest classworkDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classworkService.save(classworkDtoRequest));
    }

    @GetMapping("/{classworkId}")
    public ResponseEntity<ClassworkDtoResponse> findById(@PathVariable Long classworkId) {
        return ResponseEntity.ok().body(classworkService.findById(classworkId));
    }

    @GetMapping("/")
    public ResponseEntity<List<ClassworkDtoResponse>> findAll() {
        return ResponseEntity.ok(classworkService.findAll());
    }

    @DeleteMapping("/{classworkId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long classworkId) {
        classworkService.deleteById(classworkId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<ClassworkDtoResponse> updateClasswork(@RequestBody ClassworkDtoRequest classworkDtoRequest) {
        return ResponseEntity.ok(this.classworkService.update(classworkDtoRequest));
    }
}
