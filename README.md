# Sistema Gestão de Entidades com Spring Boot


<p align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

</p>
Uma aplicação em Java utilizando o Spring Boot, com implementação de operações básicas de um sistema CRUD.

## Requisitos Funcionais

- [x] Listagem geral
- [x] Consulta por ID
- [x] Cadastro de Entidades
- [x] Atualização de dados
- [x] Remoção de Registros

## Requisitos Técnicos

- [x] Construção em Spring Boot
- [x] Arquitetura em camadas
    - [x] Controller
    - [x] Repository
    - [x] Service
- [x] Mapeamento ORM e acesso aos dados com Hibernate
- [x] Modelo de dados com:
    - [x] Long ID
    - [x] String nome
    - [x] String cpf
    - [x] LocalDateTime dataCriacao
- [x] Verificação de duplicidade por CPF

## Requisitos Extras
- [x] Validação por Bean Validation
- [x] Mensagens customizadas de erro no retorno das APIs
- [] Criar filtro para buscar pelo nome
- [] Implementar paginação na listagem das entidades
- [] Criar testes unitários para as classes de serviço e/ou controller



## Instalação

1. Clone o repositório git

```bash
git clone https://github.com/lucas-valencia/gestao.git
```

2. Garanta pelo menos a versão 3.8.7 do Maven instalada
```bash
mvn --version
```

Retorno esperado:

```markdown
Apache Maven 3.8.7
Maven home: /usr/share/maven
Java version: 21.0.5, vendor: Ubuntu, runtime: /usr/lib/jvm/java-21-openjdk-amd64
```


## Configuração de uso

1. Rode a aplicação com Maven

```bash
mvn spring-boot:run
```

2. A API é acessivel em: http://localhost:8080

## API Endpoints

A API fornece os seguintes endpoints:

```markdown
GET /clients - Retorna uma lista de todos os clientes cadastrados

[{"idClient":1,"nome":"Exemplo","cpf":"98765432112","dataCriacao":"06-12-2024 08:49"},
{"idClient":2,"nome":"ExemploDois","cpf":"98765432114","dataCriacao":"06-12-2024 08:49"}]

```

```markdown
GET /clients/{idClient} - Retorna um cliente específico pelo ID.

[
    {
        "idClient": 1,
        "nome": "Exemplo",
        "cpf": "12345678912",
        "dataCriacao": "06-12-2024 08:17"
    }
]

```

```markdown

POST /clients - Registra um novo cliente

body(JSON):

{
    "nome": "ExemploDois",
    "cpf": "98765432114"
}

Retorno:

{
    "idClient": 2,
    "nome": "ExemploDois",
    "cpf": "98765432114",
    "dataCriacao": "06-12-2024 08:49"
}

```

```markdown
PUT /clients/{id} - Atualiza os dados de um cliente com o respectivo ID

body(JSON):

{
    "nome": "ExemploTrês",
    "cpf": "12345678923"
}

Retorno:

{
    "idClient": 1,
    "nome": "ExemploTrês",
    "cpf": "12345678923",
    "dataCriacao": "06-12-2024 08:49"
}

```
```markdonw

DELETE /clients/{id} - Deleta o cliente do respectivo ID informado

Retorno:

Cliente deletado com sucesso!

```

### Banco de dados

O projeto utiliza [H2](https://h2database.com/html/main.html) como banco de dados em memória.

