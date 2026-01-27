# Agenda de Contatos (Java + JDBC)

Projeto desenvolvido para aplicar conceitos fundamentais de conexão entre **Java** e Banco de Dados Relacional (**MySQL**) utilizando boas práticas de desenvolvimento.

---

## 📋 Sobre o Projeto

Este é um sistema de gerenciamento de contatos (CRUD) que opera via terminal.

O objetivo principal foi implementar a persistência de dados sem o uso de frameworks automáticos, garantindo o entendimento profundo do funcionamento do **JDBC** e do padrão **DAO**.

### Destaques Técnicos

- Arquitetura DAO (Data Access Object)
- Uso de PreparedStatement para prevenir SQL Injection
- Gerenciamento de recursos com try-with-resources

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- MySQL
- JDBC
- Maven

---

## 🗄️ Documentação do Banco de Dados

Para o projeto funcionar, copie e execute o script abaixo no MySQL:

```sql
CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

```
---
## 🚀 Como Rodar e Testar
 1. Clonar o repositório
git clone https://github.com/Erica2632/meu-portifolio-java.git

2. Configurar o banco
- Edite as credenciais em: src/main/java/agenda/Conexao.javat

3. Executar o projeto
- Abra a classe Main.java
- Execute pela IDE
- O menu será exibido no terminal


