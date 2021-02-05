package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.ClassworkDto;
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
    public ClassworkDto save(ClassworkDto classworkDto) {
        return classworkService.save(classworkDto);
    }

    @PostMapping("/saveClassworks")
    public Iterable<ClassworkDto> saveAll(Collection<ClassworkDto> classworkDtos) {
        return classworkService.saveAll(classworkDtos);
    }

    @GetMapping("/findById/{classworkId}")
    public ResponseEntity<ClassworkDto> findById(@PathVariable Integer classworkId) {
        ClassworkDto classworkDto = classworkService.findById(classworkId)
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        return ResponseEntity.ok().body(classworkDto);
    }

    @GetMapping("/existsById/{classworkId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer classworkId) {
        return ResponseEntity.ok().body(classworkService.existsById(classworkId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ClassworkDto>> findAll() {
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
    public ResponseEntity<Void> delete(@RequestBody ClassworkDto classworkDto) {
        classworkService.findById(classworkDto.getId())
                .orElseThrow(() -> new DataNotFoundException("Classwork not found"));
        classworkService.delete(classworkDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<ClassworkDto> classworkDtos) {
        classworkDtos.forEach(cwd -> classworkService
                .findById(cwd.getId())
                .orElseThrow(() -> new DataNotFoundException("Classwork not found")));
        classworkService.deleteAll(classworkDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        classworkService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
