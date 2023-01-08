CREATE TABLE IF NOT EXISTS cadastro.endereco (
  id int NOT NULL AUTO_INCREMENT,
  uuid varchar(255) NOT NULL,
  dataAlteracao datetime(6) DEFAULT NULL,
  dataInclusao datetime(6) DEFAULT NULL,
  logradouro varchar(255) NOT NULL,
  cep varchar(50) NOT NULL,  
  numero int,
  cidade varchar(150),
  PRIMARY KEY (id)
)
