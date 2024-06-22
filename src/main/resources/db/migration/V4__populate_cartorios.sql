INSERT INTO TB_CARTORIO (nome, observacao, situacao_id)
VALUES ('Cartório do Registro Civil da Paz', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório de Notas e Protestos Primavera', '', 'SIT_BLOQUEADO'),
       ('Cartório de Registro de Imóveis Aurora', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório de Títulos e Documentos Estrela', '', 'SIT_BLOQUEADO'),
       ('Cartório de Registro Civil das Glicínias', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório de Protesto da Esperança', '', 'SIT_BLOQUEADO'),
       ('Cartório de Registro de Títulos e Documentos Sol Nascente', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório de Notas e Títulos Luminar', '', 'SIT_BLOQUEADO'),
       ('Cartório de Registro Civil da Alvorada', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório de Protestos e Títulos do Vale', '', 'SIT_BLOQUEADO'),
       ('Cartório de Registro de Imóveis do Horizonte', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório de Títulos e Documentos do Luar', '', 'SIT_BLOQUEADO');


INSERT INTO TB_ATRIBUICAO_HAS_CARTORIO (cartorio_id, atribuicao_id)
VALUES (1, '1'),
       (1, '2'),
       (2, '2'),
       (2, '3'),
       (3, '3'),
       (4, '4'),
       (5, '5'),
       (6, '6'),
       (7, '7'),
       (8, '1'),
       (9, '2'),
       (10, '1'),
       (11, '4'),
       (12, '5');
