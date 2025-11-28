package projetoRH;

public class Analista extends Funcionario { // Herda de Funcionario

    private String area; // Área do analista

    // Construtor
    public Analista(String nome, String cpf, double salarioBase, String area) {
        super(nome, cpf, salarioBase); // chama o construtor da classe mãe
        this.area = area;
    }

    // Getter e Setter
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    // Salário total (salário base + bônus de analista)
    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBonificacao();
    }

    @Override
    public double calcularBonificacao() {
        return getSalarioBase() * 0.10;    // Bonificação = 10%
    }

    // Como aparece quando listado
    @Override
    public String toString() {
        return "Analista | Nome: " + getNome() +
                " | CPF: " + formatarCPF() +
                " | Salário Base: R$ " + String.format("%.2f", getSalarioBase()) +
                " | Área: " + area +
                " | Salário Total: R$ " + String.format("%.2f", calcularSalario());
    }
}
