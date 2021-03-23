package ua.lviv.yuriizhurakovskyi.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoResponse;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

@Validated
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/")
    public ResponseEntity<TaskDtoResponse> save(@RequestBody TaskDtoRequest taskDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskDtoRequest));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDtoResponse> findById(@PathVariable Long taskId) {
        return ResponseEntity.ok().body(taskService.findById(taskId));
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskDtoResponse>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long taskId) {
        taskService.deleteById(taskId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<TaskDtoResponse> updateTask(@RequestBody TaskDtoRequest taskDtoRequest) {
        return ResponseEntity.ok(this.taskService.update(taskDtoRequest));
    }
}
