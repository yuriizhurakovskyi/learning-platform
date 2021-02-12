package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;

@Repository
public interface ClassworkRepository extends JpaRepository<Classwork, Integer> {
}
