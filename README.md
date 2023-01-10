# Cadastro

**Licença**

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT)

### _**O que é?**_

- Cadastro é um projeto para cadastro de pessoas e endereços desenvolvido em Spring Boot com banco de dados H2.

**- Requisitos básicos do sistema:**

    - Criar uma pessoa
    - Editar uma pessoa
    - Consultar uma pessoa
    - Listar pessoas
    - Criar endereço para pessoa
    - Listar endereços da pessoa
    - Informar qual endereço é o principal da pessoa

### _**Principais ferramentas utilizadas:**_

- **Backend:** Java 11 com Spring Boot
- **Banco de dados:** H2
- **Gerenciamento de projeto:** Maven
- **Versionamento de banco de dados:** Flyway

---

### **Passo a passo para testar o Cadastro em sua máquina:**

1. clone o projeto [Cadastro](https://github.com/evandroafonso/cadastro-backend) em sua máquina.
2. para baixar as dependencias e compilar localmente o projeto, rode o comando abaixo na pasta raiz do projeto:

```bash
mvn clean compile
```

3. para rodar o projeto você precisará ter alguns programas instalados em sua máquina, são eles:

   - [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
   - [Spring Tools Suite - STS](https://spring.io/tools)
   - [Banco de dados H2](https://www.h2database.com/html/main.html)
   - [Postman](https://www.postman.com/downloads/) após o download, você pode importar a collection do Daily Menu utilizando esse [link](https://api.postman.com/collections/17110208-efa0ad09-26d6-433e-8200-270cb30bfcc3?access_key=PMAT-01GPDN9NH5F909GG11BY21NKZ2)

4. para criar as tabelas no banco de dados basta conectar o banco de dados e inciar o projeto no STS que o Flyway criará automaticamente as tabelas necessárias.
