package com.spring_boot_expert.springbootexpert.dtos;

import com.spring_boot_expert.springbootexpert.enuns.StatusPedido;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class InformacoesPedidoDTO {

    private UUID codigo;
    private String cfp;
    private String nomeCliente;
    private Double total;
    private Date dataPedido;
    private StatusPedido status;
    private List<InformacoesItemPedidoDTO> itens;

    public InformacoesPedidoDTO() {
    }

    public InformacoesPedidoDTO(UUID codigo, String cfp, String nomeCliente, Double total, Date dataPedido, StatusPedido status, List<InformacoesItemPedidoDTO> itens) {
        this.codigo = codigo;
        this.cfp = cfp;
        this.nomeCliente = nomeCliente;
        this.total = total;
        this.dataPedido = dataPedido;
        this.status = status;
        this.itens = itens;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<InformacoesItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<InformacoesItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
