package com.spring_boot_expert.springbootexpert.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class PedidoDTO implements Serializable {

    private UUID cliente;

    private List<ItemPedidoDTO> itens;

    public PedidoDTO() {
    }

    public PedidoDTO(UUID cliente, List<ItemPedidoDTO> itens) {
        this.cliente = cliente;
        this.itens = itens;
    }

    public UUID getCliente() {
        return cliente;
    }

    public void setCliente(UUID cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
