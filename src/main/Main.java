package main;

import projetoRH.*; // importa todas as classes do pacote
import java.util.Scanner; // entrada de dados
import java.util.InputMismatchException; // tratamento de erro

public class Main {

    public static void main(String[] args) {

        SistemaRH sistema = new SistemaRH(); // gerencia os funcionarios
        Scanner sc = new Scanner(System.in);  // recebe dados digitados
        int opcao = 0; // guarda opção escolhida

        sistema.carregarDoArquivo("funcionarios.txt"); // carrega os registros salvos no txt

        System.out.println("BEM-VINDO AO SISTEMA DE GESTÃO DE RH!");

        while (opcao != 7)  // Loop do menu ate clicar 7
        {

            exibirMenu(); // mostra as opções

            try {
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt(); // lê número
                sc.nextLine(); // limpa buffer

                switch (opcao) {

                    case 1:  //cadastra o funcionario
                        cadastrarFuncionario(sc, sistema);
                        break;

                    case 2:  //remove o funcionario
                        removerFuncionario(sc, sistema);
                        break;

                    case 3:  //lista os funcionarios
                        sistema.listarFuncionarios();
                        break;

                    case 4:  //consulta o funcionario
                        consultarFuncionario(sc, sistema);
                        break;

                    case 5:  //calcula a folha de pagamento
                        calcularFolha(sistema);
                        break;

                    case 6:  //lista por cargo
                        listarPorCargo(sc, sistema);
                        break;

                    case 7:  //sai do sistema e cadastra no banco
                        System.out.println("Saindo do sistema. Salvando dados...");
                        sistema.salvarEmArquivo("funcionarios.txt");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

                //captura um erro quando o usuário digita um tipo de dado errado
            } catch (InputMismatchException e) {
                System.err.println("ERRO: Digite apenas números.");
                sc.nextLine(); // limpa entrada errada
            }
        }

        sc.close(); // encerra o scanner
    }

    // Mostra menu
    private static void exibirMenu() {
        System.out.println("\n MENU ");
        System.out.println("1. Cadastrar Novo Funcionário");
        System.out.println("2. Remover Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Consultar Funcionário");
        System.out.println("5. Calcular Folha");
        System.out.println("6. Listar por Cargo");
        System.out.println("7. Sair");
    }

    // Cadastrar funcionário
    private static void cadastrarFuncionario(Scanner sc, SistemaRH sistema) {

        try {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("CPF (11 dígitos): ");
            String cpf = sc.nextLine();

            System.out.print("Salário Base: R$ ");
            double salarioBase = sc.nextDouble();
            sc.nextLine();

            System.out.println("1 - Analista | 2 - Assistente | 3 - Gerente");
            int tipo = sc.nextInt();
            sc.nextLine();

            Funcionario novo = null;

            if (tipo == 1) {
                System.out.print("Área: ");
                String area = sc.nextLine();
                novo = new Analista(nome, cpf, salarioBase, area);

            } else if (tipo == 2) {
                System.out.print("Horas extras: ");
                int horas = sc.nextInt();
                sc.nextLine();
                novo = new Assistente(nome, cpf, salarioBase, horas);

            } else if (tipo == 3) {
                novo = new Gerente(nome, cpf, salarioBase);
            }

            sistema.adicionarFuncionario(novo);

        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void removerFuncionario(Scanner sc, SistemaRH sistema) {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        sistema.removerFuncionario(cpf);
    }

    private static void consultarFuncionario(Scanner sc, SistemaRH sistema) {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        Funcionario f = sistema.buscarFuncionario(cpf);

        if (f == null) {
            System.out.println("Não encontrado.");
        } else {
            System.out.println(f);
        }
    }

    private static void calcularFolha(SistemaRH sistema) {
        double total = sistema.calcularFolhaPagamento();
        System.out.println("Folha total: R$ " + String.format("%.2f", total));
    }

    private static void listarPorCargo(Scanner sc, SistemaRH sistema) {
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        sistema.listarPorCargo(cargo);
    }
}
