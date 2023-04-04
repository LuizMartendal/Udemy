package com.spring_boot_expert.springbootexpert.dtos;

import java.util.Objects;

public class InformacoesItemPedidoDTO {
    private String descricaoProduto;
    private Double precoUnitario;
    private int quantidade;

    public InformacoesItemPedidoDTO() {
    }

    public InformacoesItemPedidoDTO(String descricaoProduto, Double precoUnitario, int quantidade) {
        this.descricaoProduto = descricaoProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformacoesItemPedidoDTO that)) return false;
        return quantidade == that.quantidade && Objects.equals(descricaoProduto, that.descricaoProduto) && Objects.equals(precoUnitario, that.precoUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricaoProduto, precoUnitario, quantidade);
    }
}
