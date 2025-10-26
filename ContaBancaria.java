import java.util.Scanner;

public class ContaBancaria {
    private String titular;
    private String agencia;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String titular, String agencia, String numeroConta, double saldoInicial) {
        this.titular = titular;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        ContaBancaria conta = new ContaBancaria("Louro José", "0025-0", "111550", 2500.0);

        System.out.println("------------------------------------------------");
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Conta: " + conta.getNumeroConta());
        System.out.println("Bem-vindo à sua conta, " + conta.getTitular() + "!");
        System.out.println("------------------------------------------------");

        do {
            System.out.println("\nSelecione a opção desejada:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            System.out.println("------------------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    System.out.println("------------------------------------------------");
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    System.out.println("------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    System.out.println("------------------------------------------------");
                    break;
                case 0:
                    System.out.println("Operação finalizada com sucesso, " + conta.getTitular() + "!");
                     System.out.println("Obrigado por utilizar o Banco!");
                    System.out.println("------------------------------------------------");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println("------------------------------------------------");
            }
        } while (opcao != 0);

        sc.close();
    }
}



