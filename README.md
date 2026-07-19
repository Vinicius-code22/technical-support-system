# Technical Support System

Sistema de gestão para assistência técnica, com cadastro de clientes, ordens de serviço e acessórios. Desenvolvido para uso real na Manutenção.exe, negócio de manutenção e reparo de computadores.

## 🛠️ Tecnologias

- **Java**
- **Maven** — gerenciamento de dependências e build
- **SQLite** — persistência de dados
- **JavaFX** — interface gráfica (em desenvolvimento)

## 📌 Status do projeto

- ✅ Camada de acesso a dados (DAO) completa e testada
  - `CustomerDAO` — CRUD de clientes
  - `ServiceOrderDAO` — CRUD de ordens de serviço
  - `AccessoryDAO` — CRUD de acessórios
- ✅ Entidades e regras de domínio modeladas
- 🚧 Interface gráfica (JavaFX) — ainda não iniciada
- ⏳ Execução atual: via terminal

## 📋 Funcionalidades

- Cadastro, consulta, atualização e remoção de **clientes**
- Cadastro, consulta, atualização e remoção de **ordens de serviço**
- Cadastro, consulta, atualização e remoção de **acessórios** vinculados às ordens
- Controle de status da ordem de serviço:
  - `REPAIRING` — em reparo
  - `READY` — pronto

### Regra de negócio

Um **cliente** pode ter várias **ordens de serviço**, mas cada **ordem de serviço** pertence a um único **cliente** (relação 1:N entre `Customer` e `ServiceOrder`).

## 🚀 Como rodar

Pré-requisitos: Java JDK e Maven instalados.

```bash
git clone https://github.com/Vinicius-code22/technical-support-system.git
cd technical-support-system
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

> O banco de dados SQLite é criado localmente e não é versionado no repositório (veja `.gitignore`).

## 📁 Estrutura do projeto

```
src/main/java/org/example/
├── Main.java
├── dao/
│   ├── CustomerDAO.java
│   ├── ServiceOrderDAO.java
│   ├── AccessoryDAO.java
│   ├── DatabaseConnection.java
│   └── DatabaseInitializer.java
└── entity/
    ├── Customer.java
    ├── ServiceOrder.java
    ├── Accessory.java
    └── Status.java
```

## 👤 Autor

Vinicius Rodrigues — desenvolvedor Java em formação, focado em backend.
[GitHub](https://github.com/Vinicius-code22)
