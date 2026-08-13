/**
 * Classe Cliente
 *
 * Representa o dono da conta bancária.
 * Aqui aplicamos ENCAPSULAMENTO: os atributos (nome, cpf) são "private",
 * ou seja, não podem ser acessados diretamente de fora da classe.
 * Para ler ou alterar esses valores, usamos métodos públicos (getters).
 * Isso protege os dados e é um dos 4 pilares da Orientação a Objetos.
 */
public class Cliente {

    private String nome;
    private String cpf;

    // Construtor: é chamado toda vez que criamos um novo Cliente.
    // Ex: new Cliente("Fernando", "123.456.789-00")
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters: métodos públicos para "pegar" os valores privados
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Sobrescrevemos o toString() para que, quando imprimirmos um Cliente,
    // ele apareça de forma legível em vez de algo como "Cliente@1b6d3586"
    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}
