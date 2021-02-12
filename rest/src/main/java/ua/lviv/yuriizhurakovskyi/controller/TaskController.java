package ua.lviv.yuriizhurakovskyi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.entity.Task;
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
    public Task save(Task task) {
        return taskService.save(task);
    }

    @PostMapping("/saveTasks")
    public Iterable<Task> saveAll(Collection<Task> tasks) {
        return taskService.saveAll(tasks);
    }

    @GetMapping("/findById/{taskId}")
    public ResponseEntity<Task> findById(@PathVariable Integer taskId) {
        Task task = taskService.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task not found"));
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/existsById/{taskId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer taskId) {
        return ResponseEntity.ok().body(taskService.existsById(taskId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Task>> findAll() {
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
    public ResponseEntity<Void> delete(@RequestBody Task task) {
        taskService.findById(task.getId())
                .orElseThrow(() -> new DataNotFoundException("Task not found"));
        taskService.delete(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCollection")
    public ResponseEntity<Void> deleteAll(List<Task> tasks) {
        tasks.forEach(t -> taskService
                .findById(t.getId())
                .orElseThrow(() -> new DataNotFoundException("Lesson not found")));
        taskService.deleteAll(tasks);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        taskService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer taskId,
                                           @RequestBody Task task) {
        Task t = taskService.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Task with id=" + taskId + " not found exception "));
        t.setDescription(task.getDescription());

        return ResponseEntity.ok(this.taskService.save(t));
    }
}
