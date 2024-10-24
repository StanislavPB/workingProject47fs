USE group47fs;

INSERT IGNORE INTO `role` (name)
VALUES ('ADMIN'),
       ('USER');

INSERT IGNORE INTO `manager` (`manager_name`,`password`,`email`,`role_id`)
VALUES ('Administrator','pass12345','admin@company.com',1);