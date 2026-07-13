import java.util.Scanner;
public class acompanhamentoIA {

    Scanner sc = new Scanner(System.in);

    private Aluno aluno;
    private int atividadesEntregues;
    private int atividadesComIA;
    private int atividadesExplicadasCorretamente;
    private int codigosModificadosSemAjuda;
    private int entregasComConteudosNaoEstudados;
    private String riscoPedagogico;
    private static String disciplina;
    private static String professor;

    public acompanhamentoIA(Aluno aluno, int atividadesEntregues, int atividadesComIA, int atividadesExplicadasCorretamente, int codigosModificadosSemAjuda, int entregaComConteudosNaoEstudados){
        this.aluno = aluno;
        this.atividadesEntregues = atividadesEntregues;
        this.atividadesComIA = atividadesComIA;
        this.atividadesExplicadasCorretamente = atividadesExplicadasCorretamente;
        this.codigosModificadosSemAjuda = codigosModificadosSemAjuda;
        this.entregasComConteudosNaoEstudados = entregaComConteudosNaoEstudados;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getAtividadesEntregues() {
        return atividadesEntregues;
    }

    public void setAtividadesEntregues(int atividadesEntregues) {
        this.atividadesEntregues = atividadesEntregues;
    }

    public int getAtividadesComIA() {
        return atividadesComIA;
    }

    public void setAtividadesComIA(int atividadesComIA) {
        this.atividadesComIA = atividadesComIA;
    }

    public int getAtividadesExplicadasCorretamente() {
        return atividadesExplicadasCorretamente;
    }

    public void setAtividadesExplicadasCorretamente(int atividadesExplicadasCorretamente) {
        this.atividadesExplicadasCorretamente = atividadesExplicadasCorretamente;
    }

    public int getCodigosModificadosSemAjuda() {
        return codigosModificadosSemAjuda;
    }

    public void setCodigosModificadosSemAjuda(int codigosModificadosSemAjuda) {
        this.codigosModificadosSemAjuda = codigosModificadosSemAjuda;
    }

    public int getEntregasComConteudosNaoEstudados() {
        return entregasComConteudosNaoEstudados;
    }

    public void setEntregasComConteudosNaoEstudados(int entregasComConteudosNaoEstudados) {
        this.entregasComConteudosNaoEstudados = entregasComConteudosNaoEstudados;
    }

    public String getRiscoPedagogico() {
        return riscoPedagogico;
    }

    public void setRiscoPedagogico(String riscoPedagogico) {
        this.riscoPedagogico = riscoPedagogico;
    }

    public static String calcularRisco(int atividadesEntregues, int atividadesComIA, int atividadesExplicadasCorretamente, int codigosModificadosSemAjuda, int entregasComConteudosNaoEstudados){
        double porcentagemDeIA = ((double) atividadesComIA * 100 ) / atividadesEntregues;
        double porcentagemAtividadesExplicadasCorretamente = ((double) atividadesExplicadasCorretamente * 100) / atividadesEntregues;
        double porcentagemCodigosModificadosSemAjuda = ((double) codigosModificadosSemAjuda * 100) / atividadesEntregues;
        double porcentagemEntregasConteudosNaoEstudados = ((double) entregasComConteudosNaoEstudados * 100) / atividadesEntregues;

        int contador = 0;

        if(atividadesEntregues == 0){
            return "Sem dados o suficiente!";
        }

        if(porcentagemDeIA > 60){
            contador++;
        }
        if(porcentagemAtividadesExplicadasCorretamente < 40){
            contador++;
        }
        if(porcentagemCodigosModificadosSemAjuda < 40){
            contador++;
        }
        if(porcentagemEntregasConteudosNaoEstudados > 60){
            contador++;
        }

        if(contador == 0){
            return "Risco baixo";
        }
        if(contador > 0 && contador < 3){
            return "Risco moderado";
        }
        return "Risco alto";
    }

    public static int cadastrarAluno(Aluno[] aluno, int totalAlunos, Scanner sc){

        if(totalAlunos >= aluno.length){
            System.out.println("O número total de alunos cadastrados já foi atingido!");
            return totalAlunos;

        }

        System.out.println("Cadastro de aluno");
        System.out.println();

        System.out.print("Nome: ");
        String nome = sc.nextLine();


        System.out.println();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println();
        System.out.print("Local de nascimento: ");
        String localDeNascimento = sc.nextLine();

        System.out.println();
        System.out.print("Curso: ");
        String curso = sc.nextLine();


        System.out.println();
        System.out.print("Matrícula: ");
        int matricula = sc.nextInt();

        for(int i = 0; i < totalAlunos; i++){
            if(aluno[i].getMatricula() == matricula) {
                System.out.println("Esta matrícula já está cadastrada!");
               return totalAlunos;
            }
        }


        System.out.println();
        System.out.print("Semestre: ");
        int semestre = sc.nextInt();

        System.out.println();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();



        System.out.println();
        System.out.print("Cadastro realizado com sucesso!");

        Pessoa novaPessoa = new Pessoa(nome, idade, localDeNascimento);
        Aluno novoAluno = new Aluno(novaPessoa, curso, matricula, semestre, ano, false);

        aluno[totalAlunos] = novoAluno;
        totalAlunos++;

        return totalAlunos;
    }

    public static int cadastrarAlunoBolsista(Aluno[] aluno, int totalAlunos, int totalBolsistas, BolsistaIC[] bolsista, Scanner sc) {

        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return -1;
        }

        System.out.println();
        System.out.println("Para se cadastrar como bolsista de Iniciação Científica digite a sua matrícula!");
        System.out.print("Matrícula: ");
        int matricula = sc.nextInt();
        sc.nextLine();

        Aluno alunoEncontrado = null;
        for(int i = 0; i < totalAlunos; i++) {
            if (aluno[i].getMatricula() == matricula) {
                alunoEncontrado = aluno[i];
                break;
            }
        }

        if(alunoEncontrado == null){
            System.out.print("Matrícula inexistente! Cadastre o aluno primeiro!");
            return totalBolsistas;
        }

        if(totalBolsistas >= bolsista.length){
            System.out.println("Limite total de alunos bolsistas cadastrados já foi atingido!");
            return totalBolsistas;
        }

        System.out.println("Cadastro do aluno bolsista de Iniciação Científica");

        System.out.println();
        System.out.print("Projeto: ");
        String projeto = sc.nextLine();

        System.out.println();
        System.out.print("Orientador: ");
        String orientador = sc.nextLine();



        BolsistaIC novoBolsista = new BolsistaIC(alunoEncontrado, projeto, orientador);
        bolsista[totalBolsistas] = novoBolsista;

        System.out.println("Cadastro realizado com sucesso!");

        totalBolsistas++;

        return totalBolsistas;

    }

    public static int registrarAcompanhamentoIA(acompanhamentoIA[] alunoAcompanhado, Aluno[] aluno, int totalAlunos,  int totalAcompanhados, Scanner sc){

        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return -1;
        }

        if(totalAcompanhados >= alunoAcompanhado.length){
            System.out.println();
            System.out.println("O limite total de alunos acompanhados já foi atingido");
            return totalAcompanhados;
        }

        System.out.println();
        System.out.println("Para continuar o registro digite a sua matrícula");
        int matricula = sc.nextInt();

        Aluno alunoEncontrado = null;
        for(int i = 0; i < totalAlunos; i++){
            if(aluno[i].getMatricula() == matricula){
                alunoEncontrado = aluno[i];
                break;
            }
        }

        if(alunoEncontrado == null){
            System.out.println("Matrícula inexistente! Cadastre o aluno primeiro!");
            return totalAcompanhados;
        }

        System.out.println("Registo de acompnhamento do uso de IA");

        System.out.println();
        System.out.print("Atividades entregues: ");
        int atividadesEntregues = sc.nextInt();

        System.out.println();
        System.out.print("Atividades com o uso declarado de IA: ");
        int atividadesComIA = sc.nextInt();

        System.out.println();
        System.out.print("Atividades explicadas corretamente: ");
        int atividadesExplicadasCorretamente = sc.nextInt();

        System.out.println();
        System.out.print("Códigos modificados sem ajuda: ");
        int codigosModificadosSemAjuda = sc.nextInt();

        System.out.println();
        System.out.print("Entregas com contéudos ainda não estudados: ");
        int entregasComConteudosNaoEstudados = sc.nextInt();

        String riscoPedagogico = acompanhamentoIA.calcularRisco(atividadesEntregues, atividadesComIA, atividadesExplicadasCorretamente, codigosModificadosSemAjuda, entregasComConteudosNaoEstudados);

        System.out.println();
        System.out.println("Registro de acompanhamento por uso de IA realizado com sucesso. ");

        acompanhamentoIA novoAcompanhado = new acompanhamentoIA(alunoEncontrado, atividadesEntregues, atividadesComIA, atividadesExplicadasCorretamente, codigosModificadosSemAjuda,entregasComConteudosNaoEstudados);
        alunoAcompanhado[totalAcompanhados] = novoAcompanhado;
        novoAcompanhado.setRiscoPedagogico(riscoPedagogico);

        totalAcompanhados++;

        return totalAcompanhados;
    }

    public static void listarAlunos(Aluno[] aluno, int totalAlunos){

        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }
        System.out.println("Lista de alunos cadastrados na turma: ");
        for(int i = 0; i < totalAlunos; i++){
            System.out.println((i + 1) + ": " + aluno[i].getPessoa().getNome());
            System.out.println("Idade: " + aluno[i].getPessoa().getIdade());
            System.out.println("Local de nascimento: " + aluno[i].getPessoa().getLocalNascimento());
            System.out.println("Curso: " + aluno[i].getCurso());
            System.out.println("Matricula: " + aluno[i].getMatricula());
            System.out.println("Semestre: " + aluno[i].getSemestre());
            System.out.println("Ano: " + aluno[i].getAno());
        }
    }

    public static void listarBolsista(BolsistaIC[] bolsista, int totalBolsistas, int totalAlunos){

        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }
        if(totalBolsistas == 0){
            System.out.println("Nenhum bolsista cadastrado até o momento");
            return;
        }

        System.out.println("Lista de bolsistas de Iniciação Científica: ");
        for(int i = 0; i < totalBolsistas; i++){
            System.out.println((i + 1) + ": " + bolsista[i].getAluno().getPessoa().getNome());
            System.out.println("Idade: " + bolsista[i].getAluno().getPessoa().getIdade());
            System.out.println("Local de nascimento: " + bolsista[i].getAluno().getPessoa().getLocalNascimento());
            System.out.println("Curso: " + bolsista[i].getAluno().getCurso());
            System.out.println("Matricula: " + bolsista[i].getAluno().getMatricula());
            System.out.println("Semestre: " + bolsista[i].getAluno().getSemestre());
            System.out.println("Ano: " + bolsista[i].getAluno().getAno());
            System.out.println("Projeto : " + bolsista[i].getProjeto());
            System.out.println("Orientador: " + bolsista[i].getOrientador());
        }
    }

    public static String mostrarNomeMaisLongo(Aluno[] aluno, int totalAlunos){

        if(totalAlunos == 0){
            return "Nenhum aluno foi cadastrado até o momento";
        }


        String nomeMaisLongo = aluno[0].getPessoa().getNome();
        for(int i = 1; i < totalAlunos; i++){
            if(nomeMaisLongo.length() < aluno[i].getPessoa().getNome().length()){
                nomeMaisLongo = aluno[i].getPessoa().getNome();
            }
        }

        return "Nome mais longo de alunos cadastrados: " + nomeMaisLongo;
    }

    public static void contarVogais(Aluno[] aluno, int totalAlunos){
        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }

        int contador = 0;

        for(int i = 0; i < totalAlunos; i++){
            String nome = aluno[i].getPessoa().getNome();
            nome = nome.toLowerCase();
            for(int j = 0; j < nome.length(); j++){
                char letra = nome.charAt(j);
                if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o'|| letra == 'u' || letra == 'á' || letra == 'à' || letra == 'â' || letra == 'ã' || letra == 'é' || letra == 'ê' || letra == 'í' || letra == 'ó' || letra == 'ô' || letra == 'õ' || letra == 'ú'){
                    contador++;
                }
            }
        }

        System.out.println("Quantidade de vogais em todos os nomes cadastrados: " + contador);

    }

    public static double mediaIdade(Aluno[] aluno, int totalAlunos){

            double soma = 0;
            for (int i = 0; i < totalAlunos; i++) {
                soma += aluno[i].getPessoa().getIdade();
            }

            double media = soma / totalAlunos;
            return media;

    }

    public static void criarOuAtualizarListaDeChamada(Aluno[] aluno, int totalAlunos, Scanner sc){
        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }


        System.out.print("Nome da disciplina: ");
        disciplina = sc.nextLine();

        System.out.println();
        System.out.print("Nome do professor: ");
        professor = sc.nextLine();

        System.out.println("Lista de chamada atualizada com sucesso!");

    }

    public static void exibirListadeChamada(Aluno[] aluno, int totalAlunos){
        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }

        if(disciplina.equals("")){
            System.out.println("A lista de chamada ainda não foi criada.");
            return;

        }

        Aluno[] lista = new Aluno[totalAlunos];
        for(int i = 0; i < totalAlunos; i++){
            lista[i] = aluno[i];
        }

        for(int i = 0; i < totalAlunos - 1; i++){
            for(int j = 0; j < totalAlunos - 1 - i; j++){
                if(lista[j].getPessoa().getNome().compareToIgnoreCase(lista[j + 1].getPessoa().getNome()) > 0){
                    Aluno aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;

                }
            }
        }

        System.out.println("LISTA DE CHAMADA");
        System.out.println();
        System.out.println("Disciplina: " + disciplina);
        System.out.println();
        System.out.println("Professor: " + professor);
        System.out.println();
        for(int i = 0; i < totalAlunos; i++){
            System.out.println((i + 1) + " - " + lista[i].getPessoa().getNome() + " | Matrícula: " + lista[i].getMatricula() + " | Curso: " + lista[i].getCurso());

        }


    }

    public static void alunosRiscoAlto(acompanhamentoIA[] alunoAcompanhado, int totalAcompanhados){
        if(totalAcompanhados == 0){
            System.out.println("Nenhum acompanhamento registrado até o momento.");
            return;
        }

        System.out.println("Alunos classificados em risco alto: ");
        System.out.println();

        boolean encontrouAlguem = false;

        for(int i = 0; i < totalAcompanhados; i++){
            if(alunoAcompanhado[i].getRiscoPedagogico().equals("Risco alto")){
                System.out.println("Nome: " + alunoAcompanhado[i].getAluno().getPessoa().getNome());
                System.out.println("Idade: " + alunoAcompanhado[i].getAluno().getPessoa().getIdade());
                System.out.println("Matrícula: " + alunoAcompanhado[i].getAluno().getMatricula());
                System.out.println("Curso: " + alunoAcompanhado[i].getAluno().getCurso());

                encontrouAlguem = true;
            }
        }

        if(!encontrouAlguem){
            System.out.println("Nenhum aluno classificado em risco alto no momento.");
        }
    }


    public static void mostrarEstatisticasDaTurma(Aluno[] aluno, int totalAlunos, int alunosAcompanhados, acompanhamentoIA[] acompanhados, int totalBolsistas){

        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento");
            return;
        }

        System.out.println("Estatísticas da turma");
        System.out.println();
        System.out.println("Total de alunos: " + totalAlunos);
        System.out.println();
        System.out.println("Total de bolsistas: " + totalBolsistas);
        System.out.println();
        System.out.println("Total de alunos acompanhados: " + alunosAcompanhados);
        System.out.println();

        double percentual1 = (double) alunosAcompanhados * 100 / totalAlunos;
        double percentual2 = (double) totalBolsistas * 100 / totalAlunos;
        System.out.println("Percentual de alunos acompanhados: " + percentual1 + "%");
        System.out.println();
        System.out.println("Percentual de alunos bolsistas: " + percentual2 + "%");

        int contadorBaixo = 0;
        int contadorMedio = 0;
        int contadorAlto = 0;

        for(int i = 0; i < alunosAcompanhados; i++){
            if(acompanhados[i].getRiscoPedagogico().equals("Risco baixo")){
                contadorBaixo++;
            } else if(acompanhados[i].getRiscoPedagogico().equals("Risco moderado")) {
                contadorMedio++;
            } else if(acompanhados[i].getRiscoPedagogico().equals("Risco alto")){
                contadorAlto++;
            }
        }

        System.out.println();
        System.out.println("Risco baixo: " + contadorBaixo);
        System.out.println();
        System.out.println("Risco moderado: " + contadorMedio);
        System.out.println();
        System.out.println("Risco alto: " + contadorAlto);
        System.out.println();

        System.out.printf("Média de idade: %.2f anos%n",  mediaIdade(aluno, totalAlunos));

        String[] cursos = new String[10];
        int[] quantidade = new int[10];
        int totalCursos = 0;

        for(int i = 0; i < totalAlunos; i++){

            String cursoAtual = aluno[i].getCurso();
            boolean encontrado = false;

            for(int j = 0; j < totalCursos; j++){

                if(cursos[j].equalsIgnoreCase(cursoAtual)){
                    quantidade[j]++;
                    encontrado = true;
                    break;
                }

            }

            if(!encontrado){
                cursos[totalCursos] = cursoAtual;
                quantidade[totalCursos] = 1;
                totalCursos++;
            }

        }

        System.out.println();
        System.out.println("Percentual de alunos por curso:");
        System.out.println();

        for(int i = 0; i < totalCursos; i++){

            double percentual = ((double) quantidade[i] / totalAlunos) * 100;

            System.out.printf("%s: %.2f%%%n", cursos[i], percentual, quantidade[i]);
        }

    }

    public static void percentualPorCurso(Aluno[] aluno, int totalAlunos){
        if(totalAlunos == 0){
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }

        String[] cursos = new String[10];
        int[] quantidade = new int[10];
        int totalCursos = 0;

        for(int i = 0; i < totalAlunos; i++){
            String cursoAtual = aluno[i].getCurso();
            boolean encontrado = false;

            for(int j = 0; j < totalCursos; j++){
                if(cursos[j].equalsIgnoreCase(cursoAtual)){
                    quantidade[j]++;
                    encontrado = true;
                    break;
                }
            }

            if(!encontrado){
                cursos[totalCursos] = cursoAtual;
                quantidade[totalCursos] = 1;
                totalCursos++;
            }
        }

        System.out.println("Percentual de alunos por curso:");
        for(int i = 0; i < totalCursos; i++){
            double percentual = ((double) quantidade[i] / totalAlunos) * 100;
            System.out.printf("%s: %.2f%%%n", cursos[i], percentual, quantidade[i]);
        }
    }


}
