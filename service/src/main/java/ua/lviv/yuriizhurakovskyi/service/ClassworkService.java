package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Classwork;

import java.util.Collection;
import java.util.Optional;

public interface ClassworkService {
    Classwork save(Classwork classwork);

    Iterable<Classwork> saveAll(Collection<Classwork> classworks);

    Optional<Classwork> findById(Integer classworkId);

    boolean existsById(Integer classworkId);

    Iterable<Classwork> findAll();

    void deleteById(Integer classworkId);

    void delete(Classwork classwork);

    void deleteAll(Collection<Classwork> classworks);

    void deleteAll();
}
