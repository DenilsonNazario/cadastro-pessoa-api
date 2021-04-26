insert into source_model values (1, 'Link swagger local','http://localhost:8080/swagger-ui.html');
insert into source_model values (2, 'Link Repositório git hub','https://github.com/DenilsonNazario/cadastro-pessoa-api');


insert into enderecos (endereco_id, logradouro) values (1, 'Teste');
insert into pessoa (pessoa_id, cpf , nascimento, nome, endereco_id) values (1, '11111111111', now(), 'teste ',1);
