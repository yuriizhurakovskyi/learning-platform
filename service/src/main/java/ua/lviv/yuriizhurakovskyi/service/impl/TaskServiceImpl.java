package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.TaskRepository;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Integer taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task with id=" + taskId + " not found exception "));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Integer taskId) {
        this.findById(taskId);
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task update(Task task) {
        Integer taskId = task.getId();
        Task t = this.findById(taskId);
        t.setDescription(task.getDescription());
        return taskRepository.save(t);
    }
}
