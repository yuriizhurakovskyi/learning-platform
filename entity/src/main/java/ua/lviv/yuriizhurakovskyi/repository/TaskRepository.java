package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.entity.TaskDto;

@Repository
public interface TaskRepository extends JpaRepository<TaskDto, Integer> {
}
