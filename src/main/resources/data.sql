INSERT INTO user (id, birth_date, name) VALUES (10, sysdate(), 'A');
INSERT INTO user (id, birth_date, name) VALUES (11, sysdate(), 'B');
INSERT INTO user (id, birth_date, name) VALUES (12, sysdate(), 'C');

INSERT INTO post (id, description, user_id) VALUES (20, 'First post', 10);
INSERT INTO post (id, description, user_id) VALUES (21, 'Second post', 10);