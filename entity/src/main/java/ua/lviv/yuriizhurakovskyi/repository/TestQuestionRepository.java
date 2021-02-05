package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestionDto;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestionDto, Integer> {
}