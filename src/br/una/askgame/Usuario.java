package br.una.askgame;

public class Usuario {
    
    int	id;
    String usuario;
    String apelido;
    String email;
    String telefone;
    String senha;
    
    public Usuario(String usuario, String apelido, String email, String telefone, String senha){
        this.usuario = usuario;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    
    public Usuario(int id, String usuario, String senha){
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }  
    
    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
