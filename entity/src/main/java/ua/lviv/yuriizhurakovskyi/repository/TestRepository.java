package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
