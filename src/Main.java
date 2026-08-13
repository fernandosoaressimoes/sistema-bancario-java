import java.util.Scanner;

/**
 * Classe Main (ponto de entrada do programa)
 *
 * Repare a diferença de responsabilidade em relação ao projeto original:
 * ela NÃO guarda saldo, NÃO valida saque, NÃO valida depósito.
 * Ela só conversa com o usuário (menu) e delega o trabalho para os
 * objetos certos (Banco e Conta). Isso é Orientação a Objetos na prática:
 * cada classe cuida só da sua própria responsabilidade.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Conta contaAtiva = null;

        int opcao;

        do {
            System.out.println("\n===== SISTEMA BANCÁRIO (POO) =====");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Selecionar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Ver extrato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerOpcaoInt(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    contaAtiva = banco.abrirConta(cliente);
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    int numero = lerOpcaoInt(scanner);
                    Conta encontrada = banco.buscarConta(numero);
                    if (encontrada == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        contaAtiva = encontrada;
                        System.out.println("Conta " + numero + " selecionada.");
                    }
                    break;

                case 3:
                    if (contaAtiva == null) {
                        System.out.println("Nenhuma conta selecionada.");
                        break;
                    }
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = lerOpcaoDouble(scanner);
                    contaAtiva.depositar(valorDeposito);
                    break;

                case 4:
                    if (contaAtiva == null) {
                        System.out.println("Nenhuma conta selecionada.");
                        break;
                    }
                    System.out.print("Valor do saque: ");
                    double valorSaque = lerOpcaoDouble(scanner);
                    contaAtiva.sacar(valorSaque);
                    break;

                case 5:
                    if (contaAtiva == null) {
                        System.out.println("Nenhuma conta selecionada.");
                        break;
                    }
                    contaAtiva.exibirExtrato();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Métodos auxiliares para ler números com segurança (evita o
    // programa quebrar se o usuário digitar texto em vez de número)
    private static int lerOpcaoInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa o "\n" que sobra no buffer
        return valor;
    }

    private static double lerOpcaoDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um valor válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}
