**Sistema de Gestão de Recursos Humanos — Java**

Este projeto consiste no desenvolvimento de um **Sistema de Gestão de Recursos Humanos utilizando a linguagem Java, com arquitetura baseada em Programação Orientada a Objetos (POO), polimorfismo e persistência de dados via leitura/escrita de arquivos**
O sistema permite o gerenciamento de funcionários, contemplando cadastro, consulta, listagem, cálculo de folha salarial e armazenamento permanente das informações.

___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**📘 Descrição Geral**

O sistema foi desenvolvido com foco em boas práticas de POO, modularização e simplicidade na persistência de dados.
Os funcionários são organizados por cargos específicos (Analista, Assistente e Gerente), cada qual com regras próprias de cálculo salarial e bonificações, implementadas por meio de polimorfismo.

A aplicação funciona via console e utiliza leitura/escrita em arquivo para garantir que os registros sejam mantidos entre execuções.

___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**🧩 Principais Funcionalidades**
1. Cadastro de Funcionários
   
Permite registrar novos funcionários informando:

- Nome

- CPF

- Salário base

- Cargo

- Atributos adicionais (ex.: área do Analista, horas extras do Assistente)

  
<br>
2. Consultas

- Busca de funcionário por CPF

- Exibição detalhada das informações

- CPF formatado automaticamente


<br>
3. Listagens

- Listar todos os funcionários cadastrados

- Filtrar por cargo

- Exibir salários base e total


<br>
4. Cálculo da Folha de Pagamento

- Soma e apresenta o valor total da folha considerando bonificações e horas extras.


<br>
5. Persistência dos Dados

- Salvamento automático em arquivo de texto utilizando BufferedWriter

- Leitura dos dados na inicialização utilizando BufferedReader

- Armazenamento estruturado em formato delimitado por ponto e vírgula

___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**🛠 Tecnologias e Recursos Utilizados**

- Java (JDK 8+)

- Paradigmas de POO

- Herança

- Polimorfismo

- Encapsulamento

- Classes abstratas e especialização

- Coleções Java

- ArrayList

- Manipulação de Arquivos

- Leitura e escrita com FileWriter, FileReader,
BufferedWriter, BufferedReader

- Tratamento de Exceções

- IllegalArgumentException

- InputMismatchException

___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**🗂 Estrutura do Projeto**

<img width="448" height="413" alt="image" src="https://github.com/user-attachments/assets/dc4b549f-b7a6-41dd-a965-8e923c6ed01d" />

___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**📄 Estratégia de Persistência**

O sistema utiliza um arquivo de texto denominado:

<img width="519" height="105" alt="image" src="https://github.com/user-attachments/assets/9508c606-e7e4-43a5-9533-db936bd73cb8" />



Cada linha representa um funcionário, seguindo o modelo:

<img width="646" height="79" alt="image" src="https://github.com/user-attachments/assets/8757ba46-6f69-477a-b7ee-83110716e1ef" />



Isso garante um método de armazenamento simples, legível e independente de banco de dados, ideal para fins acadêmicos e testes iniciais.
