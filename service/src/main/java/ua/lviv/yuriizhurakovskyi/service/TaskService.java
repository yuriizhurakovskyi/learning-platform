package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.model.TaskDto;

import java.util.Collection;
import java.util.Optional;

public interface TaskService{
    TaskDto save(TaskDto taskDto);

    Iterable<TaskDto> saveAll(Collection<TaskDto> taskDtos);

    Optional<TaskDto> findById(Integer testId);

    boolean existsById(Integer testId);

    Iterable<TaskDto> findAll();

    void deleteById(Integer testId);

    void delete(TaskDto taskDto);

    void deleteAll(Collection<TaskDto> testQuestions);

    void deleteAll();
}
