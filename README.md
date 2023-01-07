## Considerando um schema em banco de dados relacional com as seguintes tabelas:

##### Cadastro de Produtos
--------------------
COD_PRODUTO  - Código do produto (PK)
NOM_PRODUTO  - Nome do produto
CLS_PRODUTO  - Classificação do produto: '#'=Não classificado, 'A'=Alta rotatividade, 'B'=Média rotatividade,'C'=Baixa rotatividade
COD_DEPARTAMENTO  - Código do Departamento do produto

 
 
##### Cadastro de Departamentos
-------------------------
COD_DEPARTAMENTO  - Código de departamento (PK)
NOM_DEPARTAMENTO  - Nome do Departamento


## Construir um serviço REST em Java com os seguintes endpoints:

1) Endpoint para cadastrar um novo produto.

2) Endpoint que receba uma lista de códigos de departamentos na requisição e retorne, para cada código requerido, a quantidade de produtos pertencentes a ele por classificação (A,B,C, ou #).


## 1. Compilar e executar aplicação.
 - Abra um terminal (git bash, powershell, cmd) dentro da pasta do projeto
 - Executar o comando: mvn clean install
 - Executar o comando: mvn spring-boot:run

## 2. O Swagger da aplicação encontra-se na URL: 
 - http://localhost:8080/swagger-ui.html

## 3. Banco H2
 - http://localhost:8080/h2/
 - URL jdbc:h2:mem:cea
 - username diogo
 - password cea
