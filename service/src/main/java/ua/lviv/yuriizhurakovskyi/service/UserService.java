package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User save(User user);

    User findById(Integer userId);

    List<User> findAll();

    void deleteById(Integer userId);

    User update(User user);
}
