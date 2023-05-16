package io.github.Rique25.Vendas.models;

import io.github.Rique25.Vendas.enums.Sexo;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    private UUID id;

    @NotNull(message = "Nome é um campo obrigatório")
    @NotEmpty(message = "Nome é um campo obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 11, max = 11, message = "CPF deve conter 11 caracteres!")
    @Column(nullable = false, length = 11)
    private String cpf;

    @NotNull
    @Column(nullable = false)
    private Sexo sexo;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }
}
