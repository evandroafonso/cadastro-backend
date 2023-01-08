CREATE TABLE IF NOT EXISTS cadastro.enderecoPessoa (
  idPessoa int NULL,
  idEndereco int NULL,
  CONSTRAINT FK_PESSOA_ENDERECO FOREIGN KEY (idPessoa) REFERENCES cadastro.pessoa(id)
)
