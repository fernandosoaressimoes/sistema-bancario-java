/**
 * Classe Conta
 *
 * Esta é a classe mais importante do sistema: ela guarda o saldo
 * e contém as REGRAS DE NEGÓCIO (as validações que existiam no seu
 * código original, agora organizadas dentro do objeto responsável
 * por elas).
 *
 * Cada Conta "pertence" a um Cliente — isso é uma associação entre
 * classes, outro conceito central de POO.
 */
public class Conta {

    private int numero;
    private Cliente titular;
    private double saldo;

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0; // toda conta nova começa com saldo zero
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Depositar: só aceita valores positivos.
     * Regra que já existia no seu projeto original — agora vive
     * dentro da própria Conta, que é quem deve ser responsável por ela.
     */
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do depósito deve ser maior que zero.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
    }

    /**
     * Sacar: não permite sacar mais do que o saldo disponível.
     * Retorna true/false para o código que chamou saber se deu certo.
     */
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do saque deve ser maior que zero.");
            return false;
        }
        if (valor > saldo) {
            System.out.println("Erro: saldo insuficiente para este saque.");
            return false;
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
        return true;
    }

    public void exibirExtrato() {
        System.out.println("----------------------------------");
        System.out.println("Conta nº: " + numero);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("----------------------------------");
    }
}
