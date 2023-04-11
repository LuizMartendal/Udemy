package com.spring_boot_expert.springbootexpert.dtos;

public class CredentialsDTO {

    private String usuario;
    private String senha;

    public CredentialsDTO(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public CredentialsDTO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
