package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/")
    public Task save(Task task) {
        return taskService.save(task);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> findById(@PathVariable Integer taskId) {
        return ResponseEntity.ok().body(taskService.findById(taskId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer taskId) {
        taskService.deleteById(taskId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(this.taskService.update(task));
    }
}
