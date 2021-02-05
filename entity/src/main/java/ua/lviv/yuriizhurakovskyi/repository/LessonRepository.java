package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.entity.LessonDto;

@Repository
public interface LessonRepository extends JpaRepository<LessonDto, Integer> {
}
