import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0.0;
        boolean continuar = true;

        System.out.println("=== BEM-VINDO AO INFOBANK ===");

        while (continuar) {
            // Menu de opções do sistema
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Verificar Saldo");
            System.out.println("2 - Depositar Valor");
            System.out.println("3 - Sacar Valor");
            System.out.println("4 - Sair do Sistema");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Exibe o saldo formatado com duas casas decimais
                    System.out.printf("Seu saldo atual é: R$ %.2f\n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor que deseja depositar: R$ ");
                    double deposito = scanner.nextDouble();
                    
                    // Validação lógica para evitar depósitos negativos
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", deposito);
                    } else {
                        System.out.println("Erro: O valor do depósito deve ser maior que zero.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor que deseja sacar: R$ ");
                    double saque = scanner.nextDouble();

                    // Validações lógicas de saldo e valores
                    if (saque > 0 && saque <= saldo) {
                        saldo -= saque;
                        System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", saque);
                    } else if (saque > saldo) {
                        System.out.println("Erro: Saldo insuficiente para realizar a operação.");
                    } else {
                        System.out.println("Erro: O valor do saque deve ser maior que zero.");
                    }
                    break;

                case 4:
                    System.out.println("Obrigado por utilizar o InfoBank. Até logo!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção de 1 a 4.");
            }
        }

        scanner.close();
    }
}
