package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.model.ClassworkDto;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<ClassworkDto> findById(@PathVariable Integer classworkId) {
        return classworkService.findById(classworkId);
    }

    @GetMapping("/existsById/{classworkId}")
    public boolean existsById(@PathVariable Integer classworkId) {
        return classworkService.existsById(classworkId);
    }

    @GetMapping("/findAll")
    public Iterable<ClassworkDto> findAll() {
        return classworkService.findAll();
    }

    @DeleteMapping("/deleteById/{classworkId}")
    public void deleteById(@PathVariable Integer classworkId) {
        classworkService.deleteById(classworkId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody ClassworkDto classworkDto) {
        classworkService.delete(classworkDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<ClassworkDto> classworkDtos) {
        classworkService.deleteAll(classworkDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        classworkService.deleteAll();
    }
}
