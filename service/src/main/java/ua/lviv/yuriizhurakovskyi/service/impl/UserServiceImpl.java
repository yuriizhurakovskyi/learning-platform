package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> saveAll(Collection<User> users) {
        return userRepository.saveAll(users);
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException( "User with id=" + userId + " not found exception "));
    }

    public boolean existsById(Integer userId) {
        return userRepository.existsById(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Integer userId) {
        this.findById(userId);
        userRepository.deleteById(userId);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll(Collection<User> users) {
        userRepository.deleteAll(users);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User update(User user) {
        Integer userId = user.getId();
        User u = this.findById(userId);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setLevel(user.getLevel());
        u.setDateOfBirth(user.getDateOfBirth());
        u.setRole(user.getRole());
        return this.save(u);
    }
}
