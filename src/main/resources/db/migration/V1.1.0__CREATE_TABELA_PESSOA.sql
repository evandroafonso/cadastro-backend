CREATE TABLE IF NOT EXISTS cadastro.pessoa (
  id int NOT NULL AUTO_INCREMENT,
  uuid varchar(255) NOT NULL,
  dataAlteracao datetime(6) DEFAULT NULL,
  dataInclusao datetime(6) DEFAULT NULL,
  nome varchar(255) NOT NULL,
  dataNascimento varchar(255) NOT NULL,
  PRIMARY KEY (id)
)
