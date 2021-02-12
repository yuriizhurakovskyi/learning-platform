package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/classwork")
@RequiredArgsConstructor
public class ClassworkController {
    private final ClassworkService classworkService;

    @PostMapping("/saveClasswork")
    public Classwork save(@RequestBody Classwork classwork) {
        return classworkService.save(classwork);
    }

    @PostMapping("/saveClassworks")
    public Iterable<Classwork> saveAll(Collection<Classwork> classworks) {
        return classworkService.saveAll(classworks);
    }

    @GetMapping("/findById/{classworkId}")
    public ResponseEntity<Classwork> findById(@PathVariable Integer classworkId) {
        Classwork classwork = classworkService.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        return ResponseEntity.ok().body(classwork);
    }

    @GetMapping("/existsById/{classworkId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer classworkId) {
        return ResponseEntity.ok().body(classworkService.existsById(classworkId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Classwork>> findAll() {
        return ResponseEntity.ok(classworkService.findAll());
    }

    @DeleteMapping("/deleteById/{classworkId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer classworkId) {
        classworkService.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        classworkService.deleteById(classworkId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Classwork classwork) {
        classworkService.findById(classwork.getId())
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        classworkService.delete(classwork);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<Classwork> classworks) {
        classworks.forEach(cwd -> classworkService
                .findById(cwd.getId())
                .orElseThrow(() -> new DataNotFoundException("Classwork not found")));
        classworkService.deleteAll(classworks);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        classworkService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{classworkId}")
    public ResponseEntity<Classwork> updateClasswork(@PathVariable Integer classworkId,
                                                     @RequestBody Classwork classwork) {
        Classwork c = classworkService.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Classwork with id=" + classworkId + " not found exception "));

        return ResponseEntity.ok(this.classworkService.save(c));
    }
}
