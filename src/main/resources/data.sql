INSERT INTO usuario (login, nome_completo, senha) VALUES ('marcelo', 'Marcelo Adm', '$2a$10$hT85TualuIHi8gUv9aoaR.PRNp7YgNnvN.zCQO4PJsJMMTepbhvfS');

INSERT INTO role (nome_role) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES ('marcelo', 'ROLE_ADMIN');

--INSERT INTO instituicao (id, nome, tipo) VALUES (1, 'Conf', 'Confederação');
--INSERT INTO instituicao (id, nome, tipo) VALUES (2, 'Sing', 'Singular');
--INSERT INTO instituicao (id, nome, tipo) VALUES (3, 'Cent', 'Central');
--INSERT INTO instituicao (id, nome, tipo) VALUES (4, 'Cooper', 'Cooperativa');