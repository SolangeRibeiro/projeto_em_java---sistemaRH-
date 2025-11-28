package projetoRH;

import java.io.*;
import java.util.ArrayList;

public class SistemaRH {

    // Lista onde os funcionários ficam guardados em memória
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    // salva os funcionarios no txt
    public void salvarEmArquivo(String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {

            // Grava cada funcionário em uma linha
            for (Funcionario f : funcionarios) {

                String cargo = f.getClass().getSimpleName(); // pega o tipo (Analista, Assistente...)
                double salarioBase = f.getSalarioBase();

                String extra1 = ""; // dado extra (área ou horas)
                String extra2 = ""; // não usado, mas mantido para compatibilidade

                if (f instanceof Analista) {
                    extra1 = ((Analista) f).getArea();
                }
                if (f instanceof Assistente) {
                    extra1 = String.valueOf(((Assistente) f).getHorasExtras());
                }

                // Salva tudo separado por ponto e vírgula
                bw.write(
                        f.getNome() + ";" +
                                f.getCpf() + ";" +
                                cargo + ";" +
                                salarioBase + ";" +
                                extra1 + ";" +
                                extra2
                );
                bw.newLine();
            }

            System.out.println("Dados salvos com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    // carrega todos funcionarios armazenados no txt
    public void carregarDoArquivo(String caminho) {

        File arquivo = new File(caminho);

        // Se não existir, começa com lista vazia
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";"); // divide cada campo pelo ;

                if (partes.length < 4) continue; // linha inválida → ignora

                String nome = partes[0];
                String cpf = partes[1];
                String cargo = partes[2];
                double salarioBase = Double.parseDouble(partes[3]);
                String extra = partes.length > 4 ? partes[4] : "";

                Funcionario f;

                // Dependendo do cargo, recria o objeto correto
                switch (cargo.toLowerCase()) {
                    case "analista":
                        f = new Analista(nome, cpf, salarioBase, extra);
                        break;

                    case "assistente":
                        int horas = 0;
                        try { horas = Integer.parseInt(extra); } catch (Exception ignore) {}
                        f = new Assistente(nome, cpf, salarioBase, horas);
                        break;

                    case "gerente":
                        f = new Gerente(nome, cpf, salarioBase);
                        break;

                    default: // caso raro
                        f = new Funcionario(nome, cpf, salarioBase);
                        break;
                }

                // Adiciona na lista
                funcionarios.add(f);
            }

            System.out.println("Funcionários carregados!");

        } catch (Exception e) {
            System.out.println("ERRO AO LER ARQUIVO: " + e.getMessage());
        }
    }

    // MÉTODOS DO SISTEMA
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado: " + funcionario.getNome());
    }

    public boolean removerFuncionario(String cpf) {

        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                funcionarios.remove(f);
                System.out.println("Funcionário removido: " + f.getNome());
                return true;
            }
        }

        System.out.println("CPF não encontrado.");
        return false;
    }

    public Funcionario buscarFuncionario(String cpf) {
        for (Funcionario f : funcionarios)  // Busca um funcionário pelo CPF
        {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    public void listarFuncionarios() {

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("---- LISTA DE FUNCIONÁRIOS ----");

        for (Funcionario f : funcionarios) {
            System.out.println(f); // usa o toString()
        }
    }

    public double calcularFolhaPagamento() {
        double total = 0;

        for (Funcionario f : funcionarios) {
            total += f.calcularSalario(); // salário polimórfico
        }

        return total;
    }

    public void listarPorCargo(String cargo) {

        System.out.println("---- Funcionários do cargo: " + cargo + " ----");

        boolean encontrado = false;

        for (Funcionario f : funcionarios)  // Procura funcionários de um tipo específico
        {

            if (f.getClass().getSimpleName().equalsIgnoreCase(cargo)) {
                encontrado = true;
                System.out.println(f);
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum funcionário encontrado nesse cargo.");
        }
    }
}
