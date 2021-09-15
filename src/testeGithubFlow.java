import java.util.HashMap;
import java.util.Scanner;

public class testeGithubFlow {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Variáveis
        int escolhaMenu;
        int qtdeFuncionariosADD;
        String cpf;
        String nome;
        String telefone;
        String email;
        String confirmarADD;
        String repeticaoMenu = "sim";

        // Lista
        HashMap<String, String> cadastro = new HashMap<>();


        // Primeira parte do console
        System.out.println();
        System.out.println("Sistema de gerenciamento de funcionários");
        System.out.println();

        // Repetição do Menu ao final de uma escolha do usuário
        while (repeticaoMenu.equalsIgnoreCase("sim")) {
            System.out.println("Utilize os números indicados para navegar pelo menu");
            System.out.println("1 - Adicionar funcionários");
            System.out.println("2 - Exibir a lista de funcionários");
            escolhaMenu = leitor.nextInt();

            // Estrutura de decisão - Menu
            switch (escolhaMenu) {
                case 1: // Sistema para adicionar funcionários
                    // O próximo while permite a repetição da adição de novos funcionários
                    confirmarADD = "Sim";
                    while (confirmarADD.equalsIgnoreCase("sim")) {
                        System.out.println("Quantos funcionários deseja adicionar?");
                        qtdeFuncionariosADD = leitor.nextInt();
                        for (int i = 1; i <= qtdeFuncionariosADD; i++) {
                            System.out.println("Por favor insira o CPF do funcionário");
                            cpf = leitor.next();
                            // Condicional que verificará se o CPF é repetido
                            if (cadastro.containsKey(cpf)) {
                                System.out.print("Este CPF já foi cadastrado");
                            }
                            else {
                                System.out.println("Nome");
                                leitor.nextLine();
                                nome = leitor.nextLine();
                                System.out.println("Telefone");
                                telefone = leitor.nextLine();
                                System.out.println("E-mail");
                                email = leitor.next();
                                cadastro.put(cpf, "Nome do funcionário: " + nome + "\n" + "Dados de contato - "
                                        + "Telefone: " + telefone + " E-mail: " + email);
                            }
                            }
                        }
                        System.out.println();
                        System.out.println("Deseja inserir mais algum funcionário? Responda com Sim ou Não");
                        confirmarADD = leitor.next();
                    break;
                case 2: // Exibir a lista de funcionários
                    for (String referencia : cadastro.values()) {
                        System.out.println(referencia);
                    }
                    break;
                default: // Número inválido
                    System.out.println("Você digitou uma opção inválida");
            }

            System.out.println("Deseja voltar ao menu principal? Responda com Sim ou Não");
            repeticaoMenu = leitor.next();
        }
        System.out.println("Encerrando o sistema");
    }
}