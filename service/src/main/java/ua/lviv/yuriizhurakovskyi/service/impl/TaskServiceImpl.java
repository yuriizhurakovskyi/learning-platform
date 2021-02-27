package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.mapper.TaskDtoRequestMapper;
import ua.lviv.yuriizhurakovskyi.mapper.TaskDtoResponseMapper;
import ua.lviv.yuriizhurakovskyi.repository.TaskRepository;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskDtoRequestMapper taskDtoRequestMapper;
    private final TaskDtoResponseMapper taskDtoResponseMapper;

    @Override
    public TaskDtoResponse save(TaskDtoRequest taskDtoRequest) {
        Task task = taskDtoRequestMapper.map(taskDtoRequest);
        task = taskRepository.save(task);
        return taskDtoResponseMapper.map(task);
    }

    @Override
    public TaskDtoResponse findById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task with id=" + taskId + " not found exception "));
        return taskDtoResponseMapper.map(task);
    }

    @Override
    public List<TaskDtoResponse> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(taskDtoResponseMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long taskId) {
        this.findById(taskId);
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDtoResponse update(TaskDtoRequest taskDtoRequest) {
        Task task = taskDtoRequestMapper.map(taskDtoRequest);
        Long taskId = task.getId();
        Task t = taskRepository.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task with id=" + taskId + " not found exception "));
        t.setDescription(task.getDescription());
        t = taskRepository.save(t);
        return taskDtoResponseMapper.map(t);
    }
}