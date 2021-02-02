package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.yuriizhurakovskyi.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
