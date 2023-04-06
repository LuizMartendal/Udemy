package com.spring_boot_expert.springbootexpert.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class UsuarioDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    private String usuario;

    private boolean admin;

    public UsuarioDTO(UUID id, String usuario, boolean admin) {
        this.id = id;
        this.usuario = usuario;
        this.admin = admin;
    }

    public UsuarioDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
