# Sistema Gestão de Entidades com Spring Boot


<p align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

</p>
Uma aplicação em Java utilizando o Spring Boot, com implementação de operações básicas de um sistema CRUD.

## Index

- [Requisitos Funcionais](#requisitos-funcionais)
- [Requisitos Técnicos](#requisitos-técnicos)
- [Requisitos Extras](#requisitos-extras)
- [Instalação](#instalação)
- [Configuração de Uso](#configuração-de-uso)
- [API EndPoins](#api-endpoints)
- [Banco de dados](#banco-de-dados)
- [Exceções](#exceções)

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
- [x] Criar filtro para buscar pelo nome
- [x] Implementar paginação na listagem das entidades
- [~] Criar testes unitários para as classes de serviço e/ou controller



## Instalação

1. Clone o repositório git

```bash
$ git clone https://github.com/lucas-valencia/gestao.git
```

2. Garanta pelo menos a versão 3.8.7 do Maven instalada
```bash
$ mvn --version
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
$ ../gestao mvn spring-boot:run
```

2. A API é acessivel em: http://localhost:8080

## API Endpoints

A API fornece os seguintes endpoints:

```markdown
GET /clients - Retorna uma lista de todos os clientes cadastrados

Retorno:

[{"idClient":1,"nome":"Exemplo","cpf":"98765432112","dataCriacao":"06-12-2024 08:49"},
{"idClient":2,"nome":"ExemploDois","cpf":"98765432114","dataCriacao":"06-12-2024 08:49"}]

```

```markdown

GET /clients/listar/paginando?page=0&size=2 - Retorna uma lista de todos os clientes <br /> cadastrados informando a pagina a ser acessada e o número de clientes por página.

Key     | Value |
page    | 0     |
size    | 2     |

Retorno:

{
    "content": [
        {
            "nome": "Exemplo",
            "cpf": "98765432112"
        },
        {
            "nome": "Teste",
            "cpf": "98765432110"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 2,
        "sort": {
            "sorted": false,
            "empty": true,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 3,
    "totalPages": 2,
    "first": true,
    "size": 2,
    "number": 0,
    "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
    },
    "numberOfElements": 2,
    "empty": false
}

```

```markdown
GET /clients/filtar?nome=exemplo&cpf=10 - Retorna uma lista de clients que possuem <br /> algum componente das keys passadas

Key     | Value     |
nome    | exemplo   |
cpf     | 10        |

Retorno:

{
    "content": [
        {
            "nome": "Exemplo",
            "cpf": "98765432112"
        },
        {
            "nome": "Teste",
            "cpf": "98765432110"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "sorted": false,
            "empty": true,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "first": true,
    "size": 20,
    "number": 0,
    "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
    },
    "numberOfElements": 2,
    "empty": false
}

Podem ser passados as keys page e size para criar uma filtro com paginação

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

```markdown

DELETE /clients/{id} - Deleta o cliente do respectivo ID informado

Retorno:

Cliente deletado com sucesso!

```

## Banco de dados

O projeto utiliza [H2](https://h2database.com/html/main.html) como banco de dados em memória.

## Exceções

### Cliente não encontrado

```markdown

GET /clients/{id} - Caso seja passado um valor de ID que não existe no banco de dados

Retorno:

HttpStatus: 404 Not Found

Cliente não encontrado

```

### Cliente com CPF já cadastrado

```markdown

POST /clients - Caso seja informado um valor de CPF no body que já exista no banco de dados

Retorno:

HttpStatus: 409 Conflict

Cliente com CPF já cadastrado

```

### Cliente com CPF já cadastrado

```markdown

POST /clients - Caso seja informado um valor de CPF no body que possua um valor diferente de 11 dígitos numéricos

Retorno:

HttpStatus: 400 Bad Request

O CPF deve conter exatamente 11 dígitos numéricos

```