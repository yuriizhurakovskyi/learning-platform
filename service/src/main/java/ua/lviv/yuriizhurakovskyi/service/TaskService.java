package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Task;

import java.util.Collection;
import java.util.Optional;

public interface TaskService{
    Task save(Task task);

    Iterable<Task> saveAll(Collection<Task> tasks);

    Optional<Task> findById(Integer testId);

    boolean existsById(Integer testId);

    Iterable<Task> findAll();

    void deleteById(Integer testId);

    void delete(Task task);

    void deleteAll(Collection<Task> testQuestions);

    void deleteAll();
}
