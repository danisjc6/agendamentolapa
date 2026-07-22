# Sistema de Agendamento do Laboratório de Anatomia - LAPA

Sistema desenvolvido para gerenciamento dos agendamentos das salas do Laboratório de Anatomia da UFAPE.

O sistema permite o cadastro de estudantes, servidores e salas, além da realização de solicitações de agendamento, aprovação por servidores e controle da utilização dos espaços.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Eclipse IDE

---

## Arquitetura

O projeto segue a arquitetura em camadas:

```
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de Dados
```

Também utiliza o padrão DTO + Mapper para separar as entidades persistidas da comunicação da API.

---

## Funcionalidades implementadas

### Estudantes

- Cadastrar estudante
- Atualizar estudante
- Buscar estudante por ID
- Listar estudantes
- Excluir estudante

---

### Servidores

- Cadastrar servidor
- Atualizar servidor
- Buscar servidor por ID
- Listar servidores
- Excluir servidor

---

### Salas

- Cadastrar sala
- Atualizar sala
- Buscar sala por ID
- Listar salas
- Excluir sala

---

### Agendamentos

- Solicitar agendamento
- Atualizar agendamento
- Buscar agendamento por ID
- Listar agendamentos
- Excluir agendamento

Além disso:

- associação entre solicitante, sala e aprovador;
- validação de datas;
- validação de horários;
- verificação de conflito de agendamento;
- tratamento de exceções.

---

## Regras de negócio

O sistema impede:

- horário final anterior ao horário inicial;
- data final anterior à data inicial;
- agendamentos conflitantes para a mesma sala e horário;
- utilização de solicitantes inexistentes;
- utilização de salas inexistentes;
- utilização de aprovadores inexistentes.

---

## Modelo de Dados

### Pessoa

- id
- nome
- email
- cpf
- telefone

Classe abstrata.

---

### Estudante

Herda Pessoa.

Campos adicionais:

- curso
- matrícula

---

### Servidor

Herda Pessoa.

Campos adicionais:

- siape
- categoria

---

### Sala

- id
- nome
- capacidade
- tipo

---

### Agendamento

- id
- dataInicio
- dataFim
- horarioInicial
- horarioFinal
- finalidade
- frequência
- status
- solicitante
- aprovador
- sala

---

## Diagrama UML

![Diagrama UML](agendamento%20LAPA%20UML.png)

---

## Estrutura do projeto

```
src
 └── main
      ├── controller
      ├── dto
      ├── exception
      ├── mapper
      ├── model
      ├── repository
      ├── service
      └── AgendamentoLapaApplication.java
```

---

## Endpoints disponíveis

### Estudantes

| Método | Endpoint |
|---------|----------|
| GET | /estudantes |
| GET | /estudantes/{id} |
| POST | /estudantes |
| PUT | /estudantes/{id} |
| DELETE | /estudantes/{id} |

---

### Servidores

| Método | Endpoint |
|---------|----------|
| GET | /servidores |
| GET | /servidores/{id} |
| POST | /servidores |
| PUT | /servidores/{id} |
| DELETE | /servidores/{id} |

---

### Salas

| Método | Endpoint |
|---------|----------|
| GET | /salas |
| GET | /salas/{id} |
| POST | /salas |
| PUT | /salas/{id} |
| DELETE | /salas/{id} |

---

### Agendamentos

| Método | Endpoint |
|---------|----------|
| GET | /agendamentos |
| GET | /agendamentos/{id} |
| POST | /agendamentos |
| PUT | /agendamentos/{id} |
| DELETE | /agendamentos/{id} |

---

## Tratamento de exceções

A API possui tratamento centralizado de exceções utilizando:

- GlobalExceptionHandler
- EntityNotFoundException
- BusinessException
- ErrorResponse

Retornos padronizados:

- 200 OK
- 201 Created
- 204 No Content
- 400 Bad Request
- 404 Not Found
- 500 Internal Server Error

---

## Como executar

### Clonar o projeto

```bash
git clone <url-do-repositório>
```

---

### Configurar o banco

Criar um banco MySQL chamado:

```
agendamentolapa
```

Configurar o arquivo:

```
src/main/resources/application.properties
```

---

### Executar

```bash
mvn spring-boot:run
```

ou executar diretamente a classe

```
AgendamentoLapaApplication
```

---

## Melhorias futuras

- Documentação automática com Swagger/OpenAPI
- Testes unitários
- Testes de integração
- Autenticação e autorização
- Controle de disponibilidade recorrente
- Notificações por e-mail
- Paginação dos endpoints
- Filtros de busca


## Autora

Daniela Oliveira

Curso de Bacharelado em Ciência da Computação

Universidade Federal do Agreste de Pernambuco (UFAPE)