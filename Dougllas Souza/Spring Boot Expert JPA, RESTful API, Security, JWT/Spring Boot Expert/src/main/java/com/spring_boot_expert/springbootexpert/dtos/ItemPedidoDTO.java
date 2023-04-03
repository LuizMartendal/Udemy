package com.spring_boot_expert.springbootexpert.dtos;

import java.io.Serializable;
import java.util.UUID;

public class ItemPedidoDTO implements Serializable {

    private UUID produto;
    private int quantidade;

    public ItemPedidoDTO() {
    }

    public ItemPedidoDTO(UUID produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public UUID getProduto() {
        return produto;
    }

    public void setProduto(UUID produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
