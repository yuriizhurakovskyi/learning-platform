package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.model.TaskDto;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.Collection;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/saveTask")
    public TaskDto save(TaskDto taskDto) {
        return taskService.save(taskDto);
    }

    @PostMapping("/saveTasks")
    public Iterable<TaskDto> saveAll(Collection<TaskDto> taskDtos) {
        return taskService.saveAll(taskDtos);
    }

    @GetMapping("/findById/{taskId}")
    public Optional<TaskDto> findById(@PathVariable Integer taskId) {
        return taskService.findById(taskId);
    }

    @GetMapping("/existsById/{taskId}")
    public boolean existsById(@PathVariable Integer taskId) {
        return taskService.existsById(taskId);
    }

    @GetMapping("/findAll")
    public Iterable<TaskDto> findAll() {
        return taskService.findAll();
    }

    @DeleteMapping("/deleteById/{taskId}")
    public void deleteById(@PathVariable Integer taskId) {
        taskService.deleteById(taskId);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody TaskDto taskDto) {
        taskService.delete(taskDto);
    }

    @DeleteMapping("/deleteCollection")
    public void deleteAll(Collection<TaskDto> taskDtos) {
        taskService.deleteAll(taskDtos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        taskService.deleteAll();
    }
}
