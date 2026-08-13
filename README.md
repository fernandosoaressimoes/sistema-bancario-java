# ☕ Sistema Bancário via Console — Java (versão POO)

Projeto de estudos em **Java** e **Programação Orientada a Objetos (POO)**, evoluído a partir de uma primeira versão procedural (tudo em um único arquivo/método).

## 🎯 O que mudou em relação à primeira versão

A versão original tinha toda a lógica (menu, saldo, validações) misturada dentro do `main()`. Nesta versão, o sistema foi reestruturado em **4 classes**, cada uma com uma responsabilidade única:

| Classe | Responsabilidade |
|---|---|
| `Cliente` | Guarda os dados do titular da conta (nome, CPF) |
| `Conta` | Guarda o saldo e contém as regras de negócio (depositar, sacar, validações) |
| `Banco` | Gerencia uma coleção de contas (agora o sistema suporta múltiplas contas, não só uma) |
| `Main` | Cuida apenas do menu e da interação com o usuário — não tem nenhuma regra de negócio |

## 🧠 Conceitos de POO aplicados

- **Encapsulamento:** atributos são `private`; acesso controlado por métodos públicos (getters)
- **Construtores:** cada classe define como seus objetos devem nascer (`new Cliente(nome, cpf)`)
- **Associação entre classes:** uma `Conta` tem um `Cliente`; um `Banco` tem várias `Conta`
- **Responsabilidade única:** cada classe faz uma coisa só — isso facilita manutenção e teste
- **Coleções (`ArrayList`):** o `Banco` armazena múltiplas contas dinamicamente

## ▶️ Como rodar

```bash
cd src
javac *.java
java Main
```

## 🚀 Próximos passos (evolução futura)

- Persistência de dados (salvar contas em arquivo ou banco de dados)
- Herança: criar `ContaCorrente` e `ContaPoupanca` como subclasses de `Conta`
- Transferência entre contas
- Testes unitários (JUnit)
