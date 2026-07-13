public class Aluno {

    private Pessoa pessoa;
    private String curso;
    private int matricula;
    private int semestre;
    private int ano;
    private boolean eBolsista;

    public Aluno(Pessoa pessoa, String curso, int matricula, int semestre, int ano, boolean eBolsista) {
        this.pessoa = pessoa;
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
        this.ano = ano;
        this.eBolsista = eBolsista;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isEBolsista() {
        return eBolsista;
    }

    public void setEBolsista(boolean eBolsista) {
        this.eBolsista = eBolsista;
    }
}