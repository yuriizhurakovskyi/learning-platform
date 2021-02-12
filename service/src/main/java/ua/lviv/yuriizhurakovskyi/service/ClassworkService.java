package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.Classwork;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClassworkService {
    Classwork save(Classwork classwork);

    Classwork findById(Integer classworkId);

    List<Classwork> findAll();

    void deleteById(Integer classworkId);

    Classwork update(Classwork classwork);
}
