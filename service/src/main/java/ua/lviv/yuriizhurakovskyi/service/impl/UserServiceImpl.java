package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;
import ua.lviv.yuriizhurakovskyi.service.UserService;

import java.util.Collection;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        if (user != null) {
            logger.debug("Save a user" + user);
        }
        return userRepository.save(user);
    }

    public Iterable<User> saveAll(Collection<User> users) {
        if (!users.isEmpty()) {
            logger.debug("Save all users: " + users);
        }
        return userRepository.saveAll(users);
    }

    public Optional<User> findById(Integer userId) {
        logger.debug("Find user by id" + userId);
        return userRepository.findById(userId);
    }

    public boolean existsById(Integer userId) {
        logger.debug("Exists user by id: " + userId);
        return userRepository.existsById(userId);
    }

    public Iterable<User> findAll() {
        logger.debug("Find All Users");
        return userRepository.findAll();
    }

    public void deleteById(Integer userId) {
        logger.debug("Delete user by id");
        userRepository.deleteById(userId);
    }

    public void delete(User user) {
        logger.debug("Delete user: " + user);
        userRepository.delete(user);
    }

    public void deleteAll(Collection<User> users) {
        logger.debug("Delete collections of users: " + users);
        userRepository.deleteAll(users);
    }

    public void deleteAll() {
        logger.debug("Delete all users");
        userRepository.deleteAll();
    }
}
