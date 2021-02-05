package ua.lviv.yuriizhurakovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.yuriizhurakovskyi.entity.ClassworkDto;

@Repository
public interface ClassworkRepository extends JpaRepository<ClassworkDto, Integer> {
}
