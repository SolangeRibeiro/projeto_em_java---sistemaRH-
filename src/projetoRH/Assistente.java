package projetoRH;

// Herda de Funcionario
public class Assistente extends Funcionario {

    private int horasExtras; // quantidade de horas extras

    // Construtor
    public Assistente(String nome, String cpf, double salarioBase, int horasExtras) {
        super(nome, cpf, salarioBase); // chama classe mãe
        this.horasExtras = horasExtras;
    }

    // Getter e Setter
    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (horasExtras * 20); // Salário com valor de horas extras (20 reais cada)
    }

    @Override
    public double calcularBonificacao() {
        return horasExtras * 5;  // Bônus adicional de R$5 por hora (não interfere no salário total)
    }

    @Override
    public String toString() {
        return "Assistente | Nome: " + getNome() +
                " | CPF: " + formatarCPF() +
                " | Salário Base: R$ " + String.format("%.2f", getSalarioBase()) +
                " | Horas Extras: " + horasExtras +
                " | Salário Total: R$ " + String.format("%.2f", calcularSalario());
    }
}
