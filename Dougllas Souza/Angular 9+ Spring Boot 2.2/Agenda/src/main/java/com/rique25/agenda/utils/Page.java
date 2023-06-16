package com.rique25.agenda.utils;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private List<T> conteudo;
    private Long totalElementos;
    private Long totalPaginas;

    public Page(List<T> content, long totalPages, long totalElements) {
        this.conteudo = content;
        this.totalElementos = totalElements;
        this.totalPaginas = totalPages;
    }
}
