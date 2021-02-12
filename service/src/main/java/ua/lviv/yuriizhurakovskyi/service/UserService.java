package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User save(User user);

    Iterable<User> saveAll(Collection<User> users);

    User findById(Integer userId);

    boolean existsById(Integer userId);

    List<User> findAll();

    void deleteById(Integer userId);

    void delete(User user);

    void deleteAll(Collection<User> users);

    void deleteAll();

    User update(User user);
}
