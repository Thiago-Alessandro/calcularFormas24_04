public class Professor {

    public Professor(String nome,String senha){

        this.nome = nome;
        this.senha = senha;

    }

    private String nome;
    private String senha;

    //region getters e setters

    public String getSenha(){
        return this.senha;
    }

    public String getNome(){
        return this.nome;
    }

    //endregion

}
