package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.yuriizhurakovskyi.entity.Test;

public interface TestRepository extends CrudRepository<Test, Integer> {
}
