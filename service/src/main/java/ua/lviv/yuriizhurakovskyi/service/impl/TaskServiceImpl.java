package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.model.TaskDto;
import ua.lviv.yuriizhurakovskyi.repository.TaskRepository;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskDto save(TaskDto taskDto) {
        return taskRepository.save(taskDto);
    }

    @Override
    public Iterable<TaskDto> saveAll(Collection<TaskDto> taskDtos) {
        return taskRepository.saveAll(taskDtos);
    }

    @Override
    public Optional<TaskDto> findById(Integer taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public boolean existsById(Integer taskId) {
        return taskRepository.existsById(taskId);
    }

    @Override
    public Iterable<TaskDto> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void delete(TaskDto taskDto) {
        taskRepository.delete(taskDto);
    }

    @Override
    public void deleteAll(Collection<TaskDto> taskDtos) {
        taskRepository.deleteAll(taskDtos);
    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
