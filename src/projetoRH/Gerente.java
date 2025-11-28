package projetoRH;

public class Gerente extends Funcionario {

    // Construtor simples (gerente não tem atributos extras)
    public Gerente(String nome, String cpf, double salarioBase) {
        super(nome, cpf, salarioBase);
    }

    @Override
    public double calcularBonificacao() {
        return getSalarioBase() * 0.20;  // Bonificação de gerente = 20%
    }

    @Override
    public String toString() {
        return "Gerente | Nome: " + getNome() +
                " | CPF: " + formatarCPF() +
                " | Salário Base: R$ " + String.format("%.2f", getSalarioBase()) +
                " | Salário Total: R$ " + String.format("%.2f", calcularSalario());
    }
}
