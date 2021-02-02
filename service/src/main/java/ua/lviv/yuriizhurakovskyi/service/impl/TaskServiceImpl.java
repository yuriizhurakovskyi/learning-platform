package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.repository.TaskRepository;
import ua.lviv.yuriizhurakovskyi.service.TaskService;

import java.util.Collection;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        if (task != null) {
            logger.debug("Save Task: " + task);
        }
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> saveAll(Collection<Task> tasks) {
        if (!tasks.isEmpty()) {
            logger.debug("Save all tasks: " + tasks);
        }
        return taskRepository.saveAll(tasks);
    }

    @Override
    public Optional<Task> findById(Integer taskId) {
        logger.debug("Find Task by id" + taskId);
        return taskRepository.findById(taskId);
    }

    @Override
    public boolean existsById(Integer taskId) {
        logger.debug("Exists Task by id: " + taskId);
        return taskRepository.existsById(taskId);
    }

    @Override
    public Iterable<Task> findAll() {
        logger.debug("Find All Tasks");
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Integer taskId) {
        logger.debug("Delete Task by id");
        taskRepository.deleteById(taskId);
    }

    @Override
    public void delete(Task task) {
        logger.debug("Delete task: " + task);
        taskRepository.delete(task);
    }

    @Override
    public void deleteAll(Collection<Task> tasks) {
        logger.debug("Delete collections of tasks: " + tasks);
        taskRepository.deleteAll(tasks);
    }

    @Override
    public void deleteAll() {
        logger.debug("Delete all tasks");
        taskRepository.deleteAll();
    }
}
