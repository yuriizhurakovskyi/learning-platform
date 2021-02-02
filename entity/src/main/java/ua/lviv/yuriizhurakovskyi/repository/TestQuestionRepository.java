package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.yuriizhurakovskyi.entity.TestQuestion;

public interface TestQuestionRepository extends CrudRepository<TestQuestion, Integer> {
}