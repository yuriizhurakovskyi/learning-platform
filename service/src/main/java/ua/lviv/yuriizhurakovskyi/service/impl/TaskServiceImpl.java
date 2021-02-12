package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.Task;
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
    public Iterable<Task> saveAll(Collection<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    @Override
    public Optional<Task> findById(Integer taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public boolean existsById(Integer taskId) {
        return taskRepository.existsById(taskId);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deleteAll(Collection<Task> tasks) {
        taskRepository.deleteAll(tasks);
    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
