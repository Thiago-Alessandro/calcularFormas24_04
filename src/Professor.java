public class Professor {

    public Professor(String nome,String senha){

        this.nome = nome;
        this.senha = senha;

    }

    private String nome;
    private String senha;

    public String getSenha(){
        return this.senha;
    }

}
