# Agenda de Contatos (Java + JDBC)

Projeto desenvolvido para aplicar conceitos fundamentais de conexão entre **Java** e Banco de Dados Relacional (**MySQL**) utilizando boas práticas de desenvolvimento.

---

## 📋 Sobre o Projeto

Este é um sistema de gerenciamento de contatos (CRUD) que opera via terminal.  
O objetivo principal foi implementar a persistência de dados sem o uso de frameworks automáticos, garantindo o entendimento profundo do funcionamento do **JDBC** e do padrão **DAO**.

**Destaques Técnicos:**

- **Arquitetura DAO (Data Access Object):** Separação clara entre a regra de negócio e a camada de banco de dados.
- **Segurança:** Uso de `PreparedStatement` para prevenir SQL Injection.
- **Gerenciamento de Recursos:** Implementação de `try-with-resources` para fechar conexões automaticamente.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**  
- **MySQL**  
- **JDBC**  
- **Maven**

---

## 🗄️ Documentação do Banco de Dados

Para o projeto funcionar, copie e rode este script no seu MySQL:

```sql
CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);




🚀 Como Rodar e Testar

Clonar o Repositório

Abra seu terminal e rode:

git clone https://github.com/Erica2632/meu-portifolio-java.git


Configurar o Banco

Vá na pasta src/main/java/agenda

Abra o arquivo Conexao.java

Troque o usuário e a senha pelos seus dados do MySQL

Rodar o Projeto

Abra a classe Main.java na sua IDE

Clique em Run (Executar)

O menu vai aparecer no terminal
