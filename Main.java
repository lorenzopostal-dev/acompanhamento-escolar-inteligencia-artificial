import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Aluno[] aluno = new Aluno[10];
        BolsistaIC[] bolsista = new BolsistaIC[10];
        acompanhamentoIA[] alunoAcompanhado = new acompanhamentoIA[10];
        int totalAlunos = 5;
        int totalBolsistas = 3;
        int totalAcompanhados = 5;

        Pessoa pessoa1 = new Pessoa("Lorenzo Luís Postal", 18, "Lajeado");
        Aluno aluno1 = new Aluno(pessoa1, "Engenharia de Software", 26103919, 1, 2026, false);
        acompanhamentoIA acompanhado1 = new acompanhamentoIA(aluno1, 10, 7, 6, 4, 2);
        acompanhado1.setRiscoPedagogico(acompanhamentoIA.calcularRisco(10, 7, 6, 4, 2));
        aluno[0] = aluno1;
        alunoAcompanhado[0] = acompanhado1;

        Pessoa pessoa2 = new Pessoa("Daniel dos Santos García", 18, "Tramandaí");
        Aluno aluno2 = new Aluno(pessoa2, "Engenharia de Software", 26104567, 1, 2026,false);
        acompanhamentoIA acompanhado2 = new acompanhamentoIA(aluno2, 15, 5, 5, 12, 1);
        acompanhado2.setRiscoPedagogico(acompanhamentoIA.calcularRisco(15, 5, 5, 12, 1));
        aluno[1] = aluno2;
        alunoAcompanhado[1] = acompanhado2;

        Pessoa pessoa3 = new Pessoa("João Silva", 19, "Porto Alegre");
        Aluno aluno3 = new Aluno(pessoa3, "Ciência de Dados e Inteligência Artificial", 35898903, 8, 2026, true);
        acompanhamentoIA acompanhado3 = new acompanhamentoIA(aluno3, 8, 8, 7, 3, 5);
        BolsistaIC bolsista1 = new BolsistaIC(aluno3, "Tecnologias Digitais Aplicadas à Educação", "Silvia Queiroz");
        acompanhado3.setRiscoPedagogico(acompanhamentoIA.calcularRisco(8, 8, 7, 3, 5));
        aluno[2] = aluno3;
        bolsista[0] = bolsista1;
        alunoAcompanhado[2] = acompanhado3;

        Pessoa pessoa4 = new Pessoa("Rafael Teixeira", 21, "Caxias do Sul");
        Aluno aluno4 = new Aluno(pessoa4, "Ciência da Computação", 46735122, 5, 2026, true);
        acompanhamentoIA acompanhado4 = new acompanhamentoIA(aluno4, 20, 11, 9, 18, 4);
        BolsistaIC bolsista2 = new BolsistaIC(aluno4, "Estudos sobre o Uso de Inteligência Artificial em Ambientes Educacionais", "Geovane Gedoz");
        acompanhado4.setRiscoPedagogico(acompanhamentoIA.calcularRisco(20, 11, 9, 18, 4));
        aluno[3] = aluno4;
        bolsista[1] = bolsista2;
        alunoAcompanhado[3] = acompanhado4;

        Pessoa pessoa5 = new Pessoa("Arthur Soares", 19, "Porto Alegre");
        Aluno aluno5 = new Aluno(pessoa5, "Engenharia de Software", 56786712, 3,2026, true);
        BolsistaIC bolsista3 = new BolsistaIC(aluno5, "Desenvolvimento de um Chatbot para Apoio ao Ensino", "Gustavo Cardoso");
        acompanhamentoIA acompanhado5 = new acompanhamentoIA(aluno5, 12, 3, 2, 10, 0);
        acompanhado5.setRiscoPedagogico(acompanhamentoIA.calcularRisco(12, 3, 2, 10, 0));
        aluno[4] = aluno5;
        bolsista[2] = bolsista3;
        alunoAcompanhado[4] = acompanhado5;

        int opcao;
        do {
            System.out.println("MENU");
            System.out.println();
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar bolsista de IC");
            System.out.println("3 - Registrar acompanhamento do uso de IA");
            System.out.println("4 - Listar todos os alunos");
            System.out.println("5 - Listar bolsistas de IC");
            System.out.println("6 - Mostrar nome mais longo");
            System.out.println("7 - Contar vogais nos nomes cadastrados");
            System.out.println("8 - Percentual de alunos por curso");
            System.out.println("9 - Média de idade dos alunos");
            System.out.println("10 - Criar ou atulizar lista de chamada");
            System.out.println("11 - Exibir lista de chamada");
            System.out.println("12 - Calcular risco pedagógico relacionado ao uso de IA");
            System.out.println("13 - Exibir alunos em risco alto");
            System.out.println("14 - Estatística da turma");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            if(sc.hasNextInt()){
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Entrada inválida! Digite um número.");
                sc.nextLine();
                opcao = -1;
            }

            if (opcao == 1) {
                totalAlunos = acompanhamentoIA.cadastrarAluno(aluno, totalAlunos, sc);
            }
            if (opcao == 2) {
                totalBolsistas = acompanhamentoIA.cadastrarAlunoBolsista(aluno, totalAlunos, totalBolsistas, bolsista, sc);

            }
            if (opcao == 3) {
                totalAcompanhados = acompanhamentoIA.registrarAcompanhamentoIA(alunoAcompanhado, aluno, totalAlunos, totalAcompanhados, sc);

            }
            if (opcao == 4) {
                acompanhamentoIA.listarAlunos(aluno, totalAlunos);

            }
            if (opcao == 5) {
                acompanhamentoIA.listarBolsista(bolsista, totalBolsistas, totalAlunos);

            }
            if (opcao == 6) {
                System.out.println(acompanhamentoIA.mostrarNomeMaisLongo(aluno, totalAlunos));

            }
            if (opcao == 7) {
                acompanhamentoIA.contarVogais(aluno, totalAlunos);

            }
            if (opcao == 8) {
                acompanhamentoIA.percentualPorCurso(aluno, totalAlunos);

            }
            if (opcao == 9){
                if(totalAlunos == 0) {
                    System.out.println("Nenhum aluno cadastrado até o momento.");
                }else {
                    System.out.printf("Média da idade dos alunos cadastrados: %.2f%n", acompanhamentoIA.mediaIdade(aluno, totalAlunos));
                }
            }
            if (opcao == 10) {
                acompanhamentoIA.criarOuAtualizarListaDeChamada(aluno, totalAlunos, sc);

            }
            if (opcao == 11) {
                acompanhamentoIA.exibirListadeChamada(aluno, totalAlunos);

            }
            if (opcao == 12) {

                if(totalAlunos == 0){
                    System.out.println("Nenhum aluno cadastrado até o momento.");
                } else if(totalAcompanhados == 0) {
                    System.out.println("Nenhum acompanhamento cadastrado até o momento.");
                } else {
                    for (int i = 0; i < totalAcompanhados; i++) {

                        System.out.println("Aluno: " + alunoAcompanhado[i].getAluno().getPessoa().getNome());

                        System.out.println("Risco: " + alunoAcompanhado[i].getRiscoPedagogico());
                        }
                }

            }
            if (opcao == 13) {
                acompanhamentoIA.alunosRiscoAlto(alunoAcompanhado, totalAcompanhados);
            }

            if (opcao == 14) {
                acompanhamentoIA.mostrarEstatisticasDaTurma(aluno, totalAlunos, totalAcompanhados, alunoAcompanhado, totalBolsistas);
            }

            if (opcao > 14|| opcao < 0) {
                System.out.println("Opcção inválida");
            }

        } while (0 != opcao);
        System.out.println("Você saiu do programa.");
        sc.close();

    }
}
