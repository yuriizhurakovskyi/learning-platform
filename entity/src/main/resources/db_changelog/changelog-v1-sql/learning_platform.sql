-- begin;
CREATE SEQUENCE IF NOT EXISTS learning_platform.user_serial START 1;

DROP TABLE IF EXISTS learning_platform.users CASCADE;

CREATE TABLE learning_platform.users (
    u_id                    BIGINT  DEFAULT NEXTVAL('learning_platform.user_serial') NOT NULL PRIMARY KEY,
    u_firstname             VARCHAR(180)                                             NOT NULL,
    u_lastname              VARCHAR(180)                                             NOT NULL,
    u_level                 VARCHAR(5),
    u_date_of_birth         TIMESTAMP,
    u_role                  VARCHAR(20)                                              NOT NULL,
    u_email                 VARCHAR(100)                                             NOT NULL UNIQUE,
    u_password              VARCHAR(100),
    account_non_expired     BOOLEAN DEFAULT TRUE,
    account_non_locked      BOOLEAN DEFAULT TRUE,
    credentials_non_expired BOOLEAN DEFAULT TRUE,
    enabled                 BOOLEAN DEFAULT TRUE
);

CREATE SEQUENCE IF NOT EXISTS learning_platform.course_serial START 1;

DROP TABLE IF EXISTS learning_platform.course CASCADE;

CREATE TABLE learning_platform.course (
    cs_id       BIGINT DEFAULT NEXTVAL('learning_platform.course_serial') NOT NULL PRIMARY KEY,
    cs_name     VARCHAR(180)                                              NOT NULL,
    cs_level    VARCHAR(5)                                                NOT NULL,
    cs_added_by BIGINT                                                    NOT NULL
);

ALTER TABLE learning_platform.course
    ADD FOREIGN KEY (cs_added_by)
        REFERENCES learning_platform.users(u_id) ON DELETE CASCADE;

CREATE SEQUENCE IF NOT EXISTS learning_platform.test_serial START 1;

DROP TABLE IF EXISTS learning_platform.test CASCADE;

CREATE TABLE learning_platform.test (
    tst_id       BIGINT DEFAULT NEXTVAL('learning_platform.test_serial') NOT NULL PRIMARY KEY,
    tst_name     VARCHAR(180),
    tst_added_by BIGINT
);

ALTER TABLE learning_platform.test
    ADD FOREIGN KEY (tst_added_by)
        REFERENCES learning_platform.users(u_id) ON DELETE CASCADE;

CREATE SEQUENCE IF NOT EXISTS learning_platform.lesson_serial START 1;

DROP TABLE IF EXISTS learning_platform.lesson CASCADE;

CREATE TABLE learning_platform.lesson (
    ls_id            BIGINT DEFAULT NEXTVAL('learning_platform.lesson_serial') NOT NULL PRIMARY KEY,
    ls_lecture_topic VARCHAR(480),
    ls_description   VARCHAR(500),
    ls_course_id     BIGINT
);

ALTER TABLE learning_platform.lesson
    ADD FOREIGN KEY (ls_course_id)
        REFERENCES learning_platform.course(cs_id) ON DELETE CASCADE;

CREATE SEQUENCE IF NOT EXISTS learning_platform.test_question_serial START 1;

DROP TABLE IF EXISTS learning_platform.test_question CASCADE;

CREATE TABLE learning_platform.test_question (
    tq_id       BIGINT DEFAULT NEXTVAL('learning_platform.test_question_serial') NOT NULL PRIMARY KEY,
    tq_question VARCHAR(180),
    tq_answer   VARCHAR(500),
    tq_test_id  BIGINT
);

ALTER TABLE learning_platform.test_question
    ADD FOREIGN KEY (tq_test_id)
        REFERENCES learning_platform.test(tst_id) ON DELETE CASCADE;

CREATE SEQUENCE IF NOT EXISTS learning_platform.task_serial START 1;

DROP TABLE IF EXISTS learning_platform.task CASCADE;

CREATE TABLE learning_platform.task (
    tsk_id          BIGINT DEFAULT NEXTVAL('learning_platform.task_serial') NOT NULL PRIMARY KEY,
    tsk_description VARCHAR(500),
    tsk_lesson_id   BIGINT
);

ALTER TABLE learning_platform.task
    ADD FOREIGN KEY (tsk_lesson_id)
        REFERENCES learning_platform.lesson(ls_id) ON DELETE CASCADE;

CREATE SEQUENCE IF NOT EXISTS learning_platform.classwork_serial START 1;

DROP TABLE IF EXISTS learning_platform.classwork CASCADE;

CREATE TABLE learning_platform.classwork (
    cw_id       BIGINT DEFAULT NEXTVAL('learning_platform.classwork_serial') NOT NULL PRIMARY KEY,
    cw_date     TIMESTAMP,
    cw_solution VARCHAR(500),
    cw_result   VARCHAR(500),
    cw_task     BIGINT,
    cw_teacher  BIGINT,
    cw_student  BIGINT
);

ALTER TABLE learning_platform.classwork
    ADD FOREIGN KEY (cw_task)
        REFERENCES learning_platform.task(tsk_id) ON DELETE CASCADE;

ALTER TABLE learning_platform.classwork
    ADD FOREIGN KEY (cw_teacher)
        REFERENCES learning_platform.users(u_id) ON DELETE CASCADE;

ALTER TABLE learning_platform.classwork
    ADD FOREIGN KEY (cw_student)
        REFERENCES learning_platform.users(u_id) ON DELETE CASCADE;
INSERT INTO learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email,
                                    u_password)
VALUES (NEXTVAL('learning_platform.user_serial'), 'Oleh', 'SCD', NULL, '2014-01-01T00:00:00', 'ADMINISTRATOR',
        '111@1.com', '$2y$10$tHw/mE6tXawjq9mFgK1FaOzPmw33IsZrcIybWe6aphg4OoAdn3Bsy');

INSERT INTO learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email,
                                    u_password)
VALUES (NEXTVAL('learning_platform.user_serial'), 'Olena', 'LNV', 'C1', '2014-01-01T00:00:00', 'TEACHER', '222@1.com',
        '$2y$10$PA0YB/nNFYMb5E5BO/BOR.GXCcrwExAmjGHEzTV.8l/1lo.TxA4ZO');

INSERT INTO learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email,
                                    u_password)
VALUES (NEXTVAL('learning_platform.user_serial'), 'Vasyl', 'TFG', 'A1', '2014-01-01T00:00:00', 'STUDENT', '333@1.com',
        '$2y$10$FLSi0xJBdys5fzmtmjwGDOEM5VGLbnaEMomuXvB4avLgPfHeLnv.u');

INSERT INTO learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email,
                                    u_password)
VALUES (NEXTVAL('learning_platform.user_serial'), 'Vasyl', 'BSL', NULL, '2014-01-01T00:00:00', 'REGULAR_USER',
        '444@1.com', '$2y$10$z7Jt84I5Jbcbb1A/3x7EyursKiQ7BYViaYN0Q/1PheHLT.sr3m11u');

INSERT INTO learning_platform.course(cs_id, cs_name, cs_level, cs_added_by)
VALUES (NEXTVAL('learning_platform.course_serial'), 'Course for beginners', 'A1',
        (SELECT us.u_id FROM learning_platform.users us WHERE us.u_role = 'TEACHER' LIMIT 1));

INSERT INTO learning_platform.course(cs_id, cs_name, cs_level, cs_added_by)
VALUES (NEXTVAL('learning_platform.course_serial'), 'Business course', 'B2',
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role = 'TEACHER' LIMIT 1));

INSERT INTO learning_platform.course(cs_id, cs_name, cs_level, cs_added_by)
VALUES (NEXTVAL('learning_platform.course_serial'), 'Grammar course', 'B1',
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role = 'TEACHER' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Greetings',
        'Greetings section contains basic English lesson on Greetings',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%beginners%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Family', 'Family section provides basic English lesson on Family',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%beginners%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Weather',
        'Weather section provides basic English lesson on Weather',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%beginners%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Accounting', 'As an accounting major you’ll learn how to analyze businesses’ stats
 and reports to highlight areas for improvement that could boost profits and minimize inefficiencies',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%beginners%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Business administration',
        'It includes all aspects of overseeing and supervising business operations',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%Business%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Business analysis',
        'Identifying business needs and determining solutions to business problems',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%Business%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Tenses', 'Tenses',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%Grammar%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Conditionals', 'Conditionals',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%Grammar%' LIMIT 1));

INSERT INTO learning_platform.lesson(ls_id, ls_lecture_topic, ls_description, ls_course_id)
VALUES (NEXTVAL('learning_platform.lesson_serial'), 'Reported speech', 'Reported speech',
        (SELECT cs.cs_id FROM learning_platform.course cs WHERE cs.cs_name LIKE '%Grammar%' LIMIT 1));

INSERT INTO learning_platform.task(tsk_id, tsk_description, tsk_lesson_id)
VALUES (NEXTVAL('learning_platform.task_serial'), 'tsk_description1',
        (SELECT ls.ls_id FROM learning_platform.lesson ls WHERE ls_lecture_topic LIKE '%Tens%' LIMIT 1));

INSERT INTO learning_platform.task(tsk_id, tsk_description, tsk_lesson_id)
VALUES (NEXTVAL('learning_platform.task_serial'), 'tsk_description2',
        (SELECT ls.ls_id FROM learning_platform.lesson ls WHERE ls_lecture_topic LIKE '%Tens%' LIMIT 1));

INSERT INTO learning_platform.task(tsk_id, tsk_description, tsk_lesson_id)
VALUES (NEXTVAL('learning_platform.task_serial'), 'tsk_description3',
        (SELECT ls.ls_id FROM learning_platform.lesson ls WHERE ls_lecture_topic LIKE '%Con%' LIMIT 1));

INSERT INTO learning_platform.task(tsk_id, tsk_description, tsk_lesson_id)
VALUES (NEXTVAL('learning_platform.task_serial'), 'tsk_description4',
        (SELECT ls.ls_id FROM learning_platform.lesson ls WHERE ls_lecture_topic LIKE '%Con%' LIMIT 1));

INSERT INTO learning_platform.task(tsk_id, tsk_description, tsk_lesson_id)
VALUES (NEXTVAL('learning_platform.task_serial'), 'tsk_description5',
        (SELECT ls.ls_id FROM learning_platform.lesson ls WHERE ls_lecture_topic LIKE '%Con%' LIMIT 1));

INSERT INTO learning_platform.test(tst_id, tst_name, tst_added_by)
VALUES (NEXTVAL('learning_platform.test_serial'), 'Grammar test',
        (SELECT us.u_id FROM learning_platform.users us WHERE us.u_role = 'TEACHER' LIMIT 1));

INSERT INTO learning_platform.test(tst_id, tst_name, tst_added_by)
VALUES (NEXTVAL('learning_platform.test_serial'), 'Vocabulary test',
        (SELECT us.u_id FROM learning_platform.users us WHERE us.u_role = 'TEACHER' LIMIT 1));

INSERT INTO learning_platform.test(tst_id, tst_name, tst_added_by)
VALUES (NEXTVAL('learning_platform.test_serial'), 'Listening test',
        (SELECT us.u_id FROM learning_platform.users us WHERE us.u_role = 'TEACHER' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question1', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Gram%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question2', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Gram%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question3', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Gram%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question4', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Gram%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question5', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Gram%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question6', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Gram%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question1', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Voc%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question2', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Voc%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question3', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Voc%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question4', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Voc%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question5', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Voc%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question6', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Voc%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question1', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Lis%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question2', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Lis%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question3', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Lis%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question4', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Lis%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question5', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Lis%' LIMIT 1));

INSERT INTO learning_platform.test_question(tq_id, tq_question, tq_answer, tq_test_id)
VALUES (NEXTVAL('learning_platform.test_question_serial'), 'tq_question6', 'tq_answer',
        (SELECT t.tst_id FROM learning_platform.test t WHERE t.tst_name LIKE '%Lis%' LIMIT 1));

INSERT INTO learning_platform.classwork(cw_id, cw_date, cw_solution, cw_result, cw_task, cw_teacher, cw_student)
VALUES (NEXTVAL('learning_platform.classwork_serial'), '2014-01-01T00:00:00', 'cw_solution1', 'cw_result',
        (SELECT tsk.tsk_id FROM learning_platform.task tsk WHERE tsk.tsk_description LIKE '%tsk%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%TE%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%STU%' LIMIT 1));

INSERT INTO learning_platform.classwork(cw_id, cw_date, cw_solution, cw_result, cw_task, cw_teacher, cw_student)
VALUES (NEXTVAL('learning_platform.classwork_serial'), '2014-01-01T00:00:00', 'cw_solution1', 'cw_result',
        (SELECT tsk.tsk_id FROM learning_platform.task tsk WHERE tsk.tsk_description LIKE '%tsk%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%TE%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%STU%' LIMIT 1));

INSERT INTO learning_platform.classwork(cw_id, cw_date, cw_solution, cw_result, cw_task, cw_teacher, cw_student)
VALUES (NEXTVAL('learning_platform.classwork_serial'), '2014-01-01T00:00:00', 'cw_solution1', 'cw_result',
        (SELECT tsk.tsk_id FROM learning_platform.task tsk WHERE tsk.tsk_description LIKE '%tsk%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%TE%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%STU%' LIMIT 1));

INSERT INTO learning_platform.classwork(cw_id, cw_date, cw_solution, cw_result, cw_task, cw_teacher, cw_student)
VALUES (NEXTVAL('learning_platform.classwork_serial'), '2014-01-01T00:00:00', 'cw_solution1', 'cw_result',
        (SELECT tsk.tsk_id FROM learning_platform.task tsk WHERE tsk.tsk_description LIKE '%tsk%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%TE%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%STU%' LIMIT 1));

INSERT INTO learning_platform.classwork(cw_id, cw_date, cw_solution, cw_result, cw_task, cw_teacher, cw_student)
VALUES (NEXTVAL('learning_platform.classwork_serial'), '2014-01-01T00:00:00', 'cw_solution1', 'cw_result',
        (SELECT tsk.tsk_id FROM learning_platform.task tsk WHERE tsk.tsk_description LIKE '%tsk%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%TE%' LIMIT 1),
        (SELECT u.u_id FROM learning_platform.users u WHERE u.u_role LIKE '%STU%' LIMIT 1));

-- commit;