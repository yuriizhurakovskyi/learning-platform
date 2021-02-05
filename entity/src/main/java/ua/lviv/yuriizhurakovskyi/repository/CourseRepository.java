package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.model.CourseDto;

@Repository
public interface CourseRepository extends JpaRepository<CourseDto, Integer> {
}
