package io.github.rique25.springbootcurso.utils;

import java.util.List;

public class Page<T> {

    private List<T> content;
    private Long totalOfElements;
    private Long totalOfPages;

    public Page(List<T> content, Long totalOfElements, Long totalOfPages) {
        this.content = content;
        this.totalOfElements = totalOfElements;
        this.totalOfPages = totalOfPages;
    }

    public Page() {}

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotalOfElements() {
        return totalOfElements;
    }

    public void setTotalOfElements(Long totalOfElements) {
        this.totalOfElements = totalOfElements;
    }

    public Long getTotalOfPages() {
        return totalOfPages;
    }

    public void setTotalOfPages(Long totalOfPages) {
        this.totalOfPages = totalOfPages;
    }
}
