package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.model.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {
}
