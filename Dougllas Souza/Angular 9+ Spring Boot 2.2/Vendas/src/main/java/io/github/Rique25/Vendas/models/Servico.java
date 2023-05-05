package io.github.Rique25.Vendas.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "servico")
@Data
public class Servico {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    private UUID id;

    @NotEmpty
    @NotNull
    @Column(name = "servico")
    private String servico;

    @NotNull
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull
    @Column
    private BigDecimal valor;
}
