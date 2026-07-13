public class Pessoa{

    private String nome;
    private int idade;
    private String localNascimento;

    public Pessoa(String nome, int idade, String localNascimento){
        this.nome = nome;
        this.idade = idade;
        this.localNascimento = localNascimento;
    }

    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }

    public String getLocalNascimento(){
        return localNascimento;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setLocalNascimento(String localNascimento){
        this.localNascimento = localNascimento;
    }
}
