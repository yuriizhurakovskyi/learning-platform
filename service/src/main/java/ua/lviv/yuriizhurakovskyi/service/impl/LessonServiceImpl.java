package ua.lviv.yuriizhurakovskyi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.yuriizhurakovskyi.entity.Lesson;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.repository.LessonRepository;
import ua.lviv.yuriizhurakovskyi.service.LessonService;

import java.util.Collection;
import java.util.Optional;

public class LessonServiceImpl implements LessonService {
    private Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson save(Lesson lesson) {
        if (lesson != null) {
            logger.debug("Save Task: " + lesson);
        }
        return lessonRepository.save(lesson);
    }

    @Override
    public Iterable<Lesson> saveAll(Collection<Lesson> lessons) {
        if (!lessons.isEmpty()) {
            logger.debug("Save all lessons: " + lessons);
        }
        return lessonRepository.saveAll(lessons);
    }

    @Override
    public Optional<Lesson> findById(Integer lessonId) {
        logger.debug("Find Lesson by id" + lessonId);
        return lessonRepository.findById(lessonId);
    }

    @Override
    public boolean existsById(Integer lessonId) {
        logger.debug("Exists Lesson by id: " + lessonId);
        return lessonRepository.existsById(lessonId);
    }

    @Override
    public Iterable<Lesson> findAll() {
        logger.debug("Find All Lessons");
        return lessonRepository.findAll();
    }

    @Override
    public void deleteById(Integer lessonId) {
        logger.debug("Delete Lesson by id");
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public void delete(Lesson lesson) {
        logger.debug("Delete lesson: " + lesson);
        lessonRepository.delete(lesson);
    }

    @Override
    public void deleteAll(Collection<Lesson> lessons) {
        logger.debug("Delete collections of lessons: " + lessons);
        lessonRepository.deleteAll(lessons);
    }

    @Override
    public void deleteAll() {
        logger.debug("Delete all lessons");
        lessonRepository.deleteAll();
    }
}
