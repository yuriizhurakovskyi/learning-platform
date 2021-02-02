package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.repository.ClassworkRepository;
import ua.lviv.yuriizhurakovskyi.service.ClassworkService;

import java.util.Collection;
import java.util.Optional;

public class ClassworkServiceImpl implements ClassworkService {
    private Logger logger = LoggerFactory.getLogger(ClassworkServiceImpl.class);
    private final ClassworkRepository classworkRepository;

    @Autowired
    public ClassworkServiceImpl(ClassworkRepository classworkRepository) {
        this.classworkRepository = classworkRepository;
    }

    @Override
    public Classwork save(Classwork classwork) {
        if (classwork != null) {
            logger.debug("Save Classwork: " + classwork);
        }
        return classworkRepository.save(classwork);
    }

    @Override
    public Iterable<Classwork> saveAll(Collection<Classwork> classworks) {
        if (!classworks.isEmpty()) {
            logger.debug("Save all classworks: " + classworks);
        }
        return classworkRepository.saveAll(classworks);
    }

    @Override
    public Optional<Classwork> findById(Integer classworkId) {
        logger.debug("Find Classwork by id" + classworkId);
        return classworkRepository.findById(classworkId);
    }

    @Override
    public boolean existsById(Integer classworkId) {
        logger.debug("Exists Classwork by id: " + classworkId);
        return classworkRepository.existsById(classworkId);
    }

    @Override
    public Iterable<Classwork> findAll() {
        logger.debug("Find All Classworks");
        return classworkRepository.findAll();
    }

    @Override
    public void deleteById(Integer classworkId) {
        logger.debug("Delete Classwork by id");
        classworkRepository.deleteById(classworkId);
    }

    @Override
    public void delete(Classwork classwork) {
        logger.debug("Delete classwork: " + classwork);
        classworkRepository.delete(classwork);
    }

    @Override
    public void deleteAll(Collection<Classwork> classworks) {
        logger.debug("Delete collections of classworks: " + classworks);
        classworkRepository.deleteAll(classworks);
    }

    @Override
    public void deleteAll() {
        logger.debug("Delete all classworks");
        classworkRepository.deleteAll();
    }
}
