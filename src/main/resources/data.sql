INSERT INTO app_user (id, username, password) VALUES (1, 'admin', 'admin'), (2, 'bartek', '123');
INSERT INTO user_role (id, name) VALUES (1, 'ADMIN'), (2, 'USER');

INSERT INTO app_user_roles (app_user_id, roles_id) VALUES (1, 1), (2, 2);