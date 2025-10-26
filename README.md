Projeto de Java: Conta Bancária

#Este é o meu primeiro projeto em Java, desenvolvido como exercício acadêmico para aprender encapsulamento e modificadores de acesso.


1.Objetivo do Projeto
O objetivo era criar uma classe ContaBancaria com os seguintes requisitos:
Atributos:
    -titular (String)
    -numeroConta (String)
    -agencia (String)
    -saldo (double)

2.Aplicar encapsulamento, protegendo os atributos com modificadores de acesso private.
Criar métodos públicos para:
    -Consultar saldo (getSaldo())
    -Depositar valores (depositar(double valor))
    -Sacar valores (sacar(double valor)), verificando saldo suficiente.

3.No main, deveria-se criar uma instância da conta, realizar depósitos e saques e mostrar o saldo final.

O que foi implementado:

Classe ContaBancaria com atributos privados e métodos públicos para acessar e modificar os dados de forma segura.

    1.Verificação de valores válidos para depósito e saque.

    2.Menu interativo no terminal, permitindo que o usuário:
        -Deposite valores.
        -Saque valores.
        -Consulte o saldo atual.
        -Mensagens de feedback para cada operação.

#Observações
Este projeto foi feito para fins de estudo, aplicando conceitos de POO (Programação Orientada a Objetos) em Java, especialmente encapsulamento.
É possível expandir o projeto incluindo transferência entre contas, histórico de transações, entre outros.