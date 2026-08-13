import java.util.ArrayList;

/**
 * Classe Banco
 *
 * Responsável por gerenciar VÁRIAS contas — não apenas uma.
 * Isso é o que o seu projeto original não tinha: no código antigo,
 * existia só um saldo (uma única "conta" implícita). Agora o Banco
 * pode abrir várias contas e encontrar cada uma pelo número.
 *
 * Usamos um ArrayList<Conta>, uma lista dinâmica de objetos Conta.
 */
public class Banco {

    private ArrayList<Conta> contas;
    private int proximoNumeroConta;

    public Banco() {
        this.contas = new ArrayList<>();
        this.proximoNumeroConta = 1;
    }

    public Conta abrirConta(Cliente cliente) {
        Conta novaConta = new Conta(proximoNumeroConta, cliente);
        contas.add(novaConta);
        proximoNumeroConta++;
        System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumero());
        return novaConta;
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null; // não encontrada
    }

    public boolean existemContas() {
        return !contas.isEmpty();
    }
}
