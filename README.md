# Projeto de Java: Conta Bancária

Este é o meu primeiro projeto em Java, desenvolvido como exercício acadêmico para aprender **encapsulamento** e **modificadores de acesso**.

---

## Objetivo do Projeto

O objetivo era criar uma classe `ContaBancaria` com os seguintes requisitos:

- **Atributos**:
  - `titular` (String)
  - `numeroConta` (String)
  - `agencia` (String)
  - `saldo` (double)
- Aplicar **encapsulamento**, protegendo os atributos com modificadores de acesso `private`.
- Criar métodos públicos para:
  - Consultar saldo (`getSaldo()`)
  - Depositar valores (`depositar(double valor)`)
  - Sacar valores (`sacar(double valor)`), verificando saldo suficiente.

No `main`, deveria-se criar uma instância da conta, realizar depósitos e saques e mostrar o saldo final.

---

## Implementação

- Classe `ContaBancaria` com **atributos privados** e métodos públicos para acessar e modificar os dados de forma segura.
- Verificação de valores válidos para depósito e saque.
- Menu interativo no terminal, permitindo que o usuário:
  - Deposite valores
  - Saque valores
  - Consulte o saldo atual
- Mensagens de feedback para cada operação.

### Exemplo de Código

```java
ContaBancaria conta = new ContaBancaria("Louro José", "0025-0", "111550", 2500.0);
conta.depositar(500);
conta.sacar(200);
System.out.println("Saldo atual: " + conta.getSaldo());


Observações:
Este projeto foi feito para fins de estudo, aplicando conceitos de POO (Programação Orientada a Objetos) em Java, especialmente encapsulamento.
É possível expandir o projeto incluindo transferência entre contas, histórico de transações, entre outros.