-- begin;
create sequence if not exists learning_platform.user_serial start 1;

drop table if exists learning_platform.users cascade;

create table learning_platform.users
(
    u_id            bigint default nextval('learning_platform.user_serial') not null primary key,
    u_firstname     varchar(180) not null,
    u_lastname      varchar(180) not null,
    u_level         varchar(5),
    u_date_of_birth timestamp,
    u_role          varchar(20)  not null,
    u_email varchar(100) not null unique,
    u_password varchar(100),
    account_non_expired boolean default true,
    account_non_locked boolean default true,
    credentials_non_expired boolean default true,
    enabled boolean default true
);

create sequence if not exists learning_platform.course_serial start 1;

drop table if exists learning_platform.course cascade;

create table learning_platform.course
(
    cs_id       bigint default nextval('learning_platform.course_serial') not null primary key,
    cs_name     varchar(180) not null,
    cs_level    varchar(5)   not null,
    cs_added_by bigint          not null
);

alter table learning_platform.course
    add foreign key (cs_added_by)
        references learning_platform.users (u_id) on delete cascade;

create sequence if not exists learning_platform.test_serial start 1;

drop table if exists learning_platform.test cascade;

create table learning_platform.test
(
    tst_id       bigint default nextval('learning_platform.test_serial') not null primary key,
    tst_name     varchar(180),
    tst_added_by bigint
);

alter table learning_platform.test
    add foreign key (tst_added_by)
        references learning_platform.users (u_id) on delete cascade;

create sequence if not exists learning_platform.lesson_serial start 1;

drop table if exists learning_platform.lesson cascade;

create table learning_platform.lesson
(
    ls_id            bigint default nextval('learning_platform.lesson_serial') not null primary key,
    ls_lecture_topic varchar(480),
    ls_description   varchar(500),
    ls_course_id     bigint
);

alter table learning_platform.lesson
    add foreign key (ls_course_id)
        references learning_platform.course (cs_id) on delete cascade;

create sequence if not exists learning_platform.test_question_serial start 1;

drop table if exists learning_platform.test_question cascade;

create table learning_platform.test_question
(
    tq_id       bigint default nextval('learning_platform.test_question_serial') not null primary key,
    tq_question varchar(180),
    tq_answer   varchar(500),
    tq_test_id  bigint
);

alter table learning_platform.test_question
    add foreign key (tq_test_id)
        references learning_platform.test (tst_id) on delete cascade;

create sequence if not exists learning_platform.task_serial start 1;

drop table if exists learning_platform.task cascade;

create table learning_platform.task
(
    tsk_id          bigint default nextval('learning_platform.task_serial') not null primary key,
    tsk_description varchar(500),
    tsk_lesson_id   bigint
);

alter table learning_platform.task
    add foreign key (tsk_lesson_id)
        references learning_platform.lesson (ls_id) on delete cascade;

create sequence if not exists learning_platform.classwork_serial start 1;

drop table if exists learning_platform.classwork cascade;

create table learning_platform.classwork
(
    cw_id       bigint default nextval('learning_platform.classwork_serial') not null primary key,
    cw_date     timestamp,
    cw_solution varchar(500),
    cw_result   varchar(500),
    cw_task     bigint,
    cw_teacher  bigint,
    cw_student  bigint
);

alter table learning_platform.classwork
    add foreign key (cw_task)
        references learning_platform.task (tsk_id) on delete cascade;

alter table learning_platform.classwork
    add foreign key (cw_teacher)
        references learning_platform.users (u_id) on delete cascade;

alter table learning_platform.classwork
    add foreign key (cw_student)
        references learning_platform.users (u_id) on delete cascade;
-- commit;