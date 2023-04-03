package com.spring_boot_expert.springbootexpert.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class PedidoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @Column
    private Date dataPedido;

    @Column
    private Double total;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedidoModel> itens;

    public PedidoModel() {
    }

    public PedidoModel(UUID id, ClienteModel cliente, Date dataPedido, Double total) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemPedidoModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoModel> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoModel that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCliente(), that.getCliente()) && Objects.equals(getDataPedido(), that.getDataPedido()) && Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getItens(), that.getItens());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCliente(), getDataPedido(), getTotal(), getItens());
    }
}
