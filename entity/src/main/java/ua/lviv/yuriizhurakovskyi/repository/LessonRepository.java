package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
