insert into learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email, u_password)
values (nextval('learning_platform.user_serial'),'Oleh', 'SCD', null, '2014-01-01T00:00:00', 'ADMINISTRATOR', '111@1.com', '$2y$10$tHw/mE6tXawjq9mFgK1FaOzPmw33IsZrcIybWe6aphg4OoAdn3Bsy');

insert into learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email, u_password)
values (nextval('learning_platform.user_serial'),'Olena', 'LNV', 'C1', '2014-01-01T00:00:00', 'TEACHER', '222@1.com', '$2y$10$PA0YB/nNFYMb5E5BO/BOR.GXCcrwExAmjGHEzTV.8l/1lo.TxA4ZO');

insert into learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email, u_password)
values (nextval('learning_platform.user_serial'), 'Vasyl', 'TFG', 'A1', '2014-01-01T00:00:00', 'STUDENT', '333@1.com', '$2y$10$FLSi0xJBdys5fzmtmjwGDOEM5VGLbnaEMomuXvB4avLgPfHeLnv.u');

insert into learning_platform.users(u_id, u_firstname, u_lastname, u_level, u_date_of_birth, u_role, u_email, u_password)
values (nextval('learning_platform.user_serial'), 'Vasyl', 'BSL', null, '2014-01-01T00:00:00', 'REGULAR_USER', '444@1.com', '$2y$10$z7Jt84I5Jbcbb1A/3x7EyursKiQ7BYViaYN0Q/1PheHLT.sr3m11u');