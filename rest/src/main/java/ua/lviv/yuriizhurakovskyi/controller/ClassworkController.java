package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/classwork")
@RequiredArgsConstructor
public class ClassworkController {
    private final ClassworkService classworkService;

    @PostMapping("/")
    public Classwork save(@RequestBody Classwork classwork) {
        return classworkService.save(classwork);
    }

    @GetMapping("/{classworkId}")
    public ResponseEntity<Classwork> findById(@PathVariable Integer classworkId) {
        return ResponseEntity.ok().body(classworkService.findById(classworkId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Classwork>> findAll() {
        return ResponseEntity.ok(classworkService.findAll());
    }

    @DeleteMapping("/{classworkId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer classworkId) {
        classworkService.deleteById(classworkId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Classwork> updateClasswork(@RequestBody Classwork classwork) {
        return ResponseEntity.ok(this.classworkService.update(classwork));
    }
}
