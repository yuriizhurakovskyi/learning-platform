package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.model.TaskDto;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.Collection;
import java.util.List;

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
    public ResponseEntity<TaskDto> findById(@PathVariable Integer taskId) {
        TaskDto taskDto = taskService.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task not found"));
        return ResponseEntity.ok().body(taskDto);
    }

    @GetMapping("/existsById/{taskId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer taskId) {
        return ResponseEntity.ok().body(taskService.existsById(taskId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TaskDto>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @DeleteMapping("/deleteById/{taskId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer taskId) {
        taskService.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task not found"));
        taskService.deleteById(taskId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody TaskDto taskDto) {
        taskService.findById(taskDto.getId())
                .orElseThrow(() -> new DataNotFoundException("Task not found"));
        taskService.delete(taskDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<TaskDto> taskDtos) {
        taskDtos.forEach(t -> taskService
                .findById(t.getId())
                .orElseThrow(() -> new DataNotFoundException("Lesson not found")));
        taskService.deleteAll(taskDtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        taskService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Integer taskId,
                                              @RequestBody TaskDto taskDto) {
        TaskDto t = taskService.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Task with id=" + taskId + " not found exception "));
        t.setDescription(taskDto.getDescription());

        return ResponseEntity.ok(this.taskService.save(t));
    }
}
