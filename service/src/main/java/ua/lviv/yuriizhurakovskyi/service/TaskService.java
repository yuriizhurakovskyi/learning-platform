package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Task;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TaskService{
    Task save(Task task);

    Task findById(Integer testId);

    List<Task> findAll();

    void deleteById(Integer testId);

    Task update(Task task);
}
