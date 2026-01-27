# Agenda de Contatos (Java + JDBC)

Projeto desenvolvido para aplicar conceitos fundamentais de conexão entre **Java** e Banco de Dados Relacional (**MySQL**) utilizando boas práticas de desenvolvimento.

## 📋 Sobre o Projeto
Este é um sistema de gerenciamento de contatos (CRUD) que opera via terminal. O objetivo principal foi implementar a persistência de dados sem o uso de frameworks automáticos (como Hibernate), garantindo o entendimento profundo do funcionamento do **JDBC**.

**Destaques:**
* Uso do padrão **DAO (Data Access Object)** para separar a regra de negócio do acesso ao banco.
* Prevenção contra **SQL Injection** utilizando `PreparedStatement`.
* Gerenciamento eficiente de recursos com `try-with-resources`.

## 🛠️ Tecnologias Utilizadas
* **Java 17**
* **MySQL** (Banco de Dados)
* **JDBC** (Driver de conexão)
* **IntelliJ IDEA** (IDE de desenvolvimento)

## 🗄️ Estrutura do Banco de Dados
Para rodar este projeto, é necessário criar o banco de dados e a tabela no MySQL. Execute o script abaixo no seu cliente de banco de dados (MySQL Workbench, DBeaver ou Terminal):

```sql
CREATE DATABASE agenda;

USE agenda;

CREATE TABLE contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,

🚀 Como Rodar e Testar
Passo 1: Clonar o Repositório

Abra seu terminal e rode este comando:

Bash

git clone [https://github.com/Erica2632/meu-portifolio-java.git](https://github.com/Erica2632/meu-portifolio-java.git)
Passo 2: Configurar o Banco

Vá na pasta src/main/java/agenda e abra o arquivo Conexao.java. Troque o usuário e a senha pelos seus dados do MySQL.

Passo 3: Rodar o Projeto

Abra a classe Main.java na sua IDE. Clique em Run (Executar). O menu vai aparecer no terminal.

✒️ Autora
Érica Cristina Marques

LinkedIn

E-mail


    
    telefone VARCHAR(20),
    email VARCHAR(100)
);
