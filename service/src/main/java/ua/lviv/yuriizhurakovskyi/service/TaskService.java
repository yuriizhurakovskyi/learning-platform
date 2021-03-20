package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoRequest;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Task;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskDtoResponse save(TaskDtoRequest taskDtoRequest);

    TaskDtoResponse findById(Long testId);

    List<TaskDtoResponse> findAll();

    void deleteById(Long testId);

    TaskDtoResponse update(TaskDtoRequest taskDtoRequest);
}
