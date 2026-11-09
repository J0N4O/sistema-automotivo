# Sistema Automotivo — Gestão de Estoque de Veículos

Sistema de gerenciamento de estoque de veículos desenvolvido em Java com Spring Boot e MySQL, como projeto acadêmico do curso de Análise e Desenvolvimento de Sistemas.

## Sobre o projeto

O objetivo é facilitar o gerenciamento de veículos em concessionárias e empresas automotivas, permitindo cadastrar, consultar, atualizar, filtrar e excluir veículos.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven
- REST API

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de veículos.
- Cadastro e gerenciamento de marcas.
- Cadastro e gerenciamento de modelos.
- Associação entre marcas e modelos.
- Consulta de veículos por ID.
- Filtros por marca, modelo, ano, faixa de preço e status.
- Atualização de preço, quilometragem e situação do veículo.
- Validação dos dados enviados à API.

## Status dos veículos

- `DISPONIVEL`
- `VENDIDO`
- `DESCONTINUADO`

## Estrutura do projeto

O projeto utiliza uma organização baseada em camadas:

- **Controller:** recebe e responde às requisições HTTP.
- **Service:** concentra as regras de negócio.
- **Repository:** realiza a comunicação com o banco de dados.
- **Model:** representa as entidades do sistema.
- **Exception:** trata erros e validações.

## Banco de dados

O sistema utiliza MySQL com o banco de dados `sistema_automotivo`.

As credenciais são configuradas por variáveis de ambiente:

- `DB_USERNAME`
- `DB_PASSWORD`

## Como executar o projeto

1. Instale o Java 21 e o MySQL 8.
2. Crie o banco de dados `sistema_automotivo`.
3. Configure as variáveis de ambiente `DB_USERNAME` e `DB_PASSWORD`.
4. Abra a pasta do projeto no terminal.
5. Execute:

```powershell
.\mvnw spring-boot:run
```

A aplicação será iniciada na porta 8080.

## Endpoints principais

| Método | Endpoint | Funcionalidade |
|---|---|---|
| GET | `/veiculos` | Listar veículos |
| GET | `/veiculos/{id}` | Buscar veículo |
| POST | `/veiculos` | Cadastrar veículo |
| PUT | `/veiculos/{id}` | Atualizar veículo |
| DELETE | `/veiculos/{id}` | Excluir veículo |
| GET | `/veiculos/filtro` | Filtrar veículos |
| GET/POST | `/marcas` | Consultar e cadastrar marcas |
| GET/POST | `/modelos` | Consultar e cadastrar modelos |

## Autor

Projeto acadêmico desenvolvido durante o curso de Análise e Desenvolvimento de Sistemas — UNIFECAF.