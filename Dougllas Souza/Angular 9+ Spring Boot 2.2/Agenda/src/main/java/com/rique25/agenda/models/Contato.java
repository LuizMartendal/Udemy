package com.rique25.agenda.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "contato")
@Data
public class Contato {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    private UUID id;

    @Column
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Column
    @NotNull(message = "Email é obrigatório")
    private String email;

    @Column
    private int numero;

    @Column Boolean favorito;
}
