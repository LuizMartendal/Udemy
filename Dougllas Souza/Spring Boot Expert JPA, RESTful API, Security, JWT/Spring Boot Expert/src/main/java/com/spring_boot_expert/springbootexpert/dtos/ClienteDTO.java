package com.spring_boot_expert.springbootexpert.dtos;

import com.spring_boot_expert.springbootexpert.models.ClienteModel;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

public class ClienteDTO extends RepresentationModel<ClienteDTO> implements Serializable {

    private UUID id;
    private String nome;
    private String cpf;

    public ClienteDTO(UUID id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
