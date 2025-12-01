package projetoRH; // Pacote onde a classe está

public class Funcionario {

    // Atributos básicos do funcionário
    private String nome;
    private String cpf;
    private double salarioBase;

    // Construtor inicializa nome, cpf e salário
    public Funcionario(String nome, String cpf, double salarioBase) {
        setNome(nome);           // chama o setter (com validação)
        setCpf(cpf);             // idem
        setSalarioBase(salarioBase);
    }

    // Formata o CPF colocando pontos e traço (nao esta funcionando)
    // public String formatarCPF() {
    //    if (cpf == null || cpf.length() != 11) return cpf; // Se estiver errado, retorna normal

    //    return cpf.substring(0, 3) + "." +
     //           cpf.substring(3, 6) + "." +
       //         cpf.substring(6, 9) + "-" +
         //       cpf.substring(9, 11);
    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank())  // Impede nome vazio
    {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) // Valida se possui exatamente 11 números 
    {
            throw new IllegalArgumentException("CPF inválido! Deve conter exatamente 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) // Impede salário negativo
    {
            throw new IllegalArgumentException("O salário base não pode ser negativo.");
        }
        this.salarioBase = salarioBase;
    }

    //POLIMORFISMO

    public double calcularSalario() {
        // Salário total = base + bônus
        return salarioBase + calcularBonificacao();
    }

    public double calcularBonificacao() {
        // Funcionário comum não tem bônus
        return 0;
    }

    // Como o funcionário aparece na listagem
    @Override
    public String toString() {
        return "Nome: " + nome +
                " | CPF: " + formatarCPF() +
                " | Salário Base: R$ " + String.format("%.2f", salarioBase) +
                " | Salário Total: R$ " + String.format("%.2f", calcularSalario());
    }
}
