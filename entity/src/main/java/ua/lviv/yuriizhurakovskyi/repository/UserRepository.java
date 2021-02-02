package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.yuriizhurakovskyi.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
