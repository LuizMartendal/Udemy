package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.controllers.ProdutoController;
import com.spring_boot_expert.springbootexpert.exceptions.IsNullException;
import com.spring_boot_expert.springbootexpert.exceptions.NaoEncontradoException;
import com.spring_boot_expert.springbootexpert.models.ProdutoModel;
import com.spring_boot_expert.springbootexpert.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public PagedModel<EntityModel<ProdutoModel>> findAll(Pageable pageable) {
        Page<ProdutoModel> produtos =  repository.findAll(pageable);
        produtos.map(produto -> {
            produto.add(linkTo(methodOn(ProdutoController.class).findById(produto.getId())).withSelfRel());
            return produto;
        });
        Link link = linkTo(methodOn(ProdutoController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "ASC")).withSelfRel();
        PagedResourcesAssembler<ProdutoModel> assembler = new PagedResourcesAssembler<>(null, null);
        return assembler.toModel(produtos, link);
    }

    public ProdutoModel findById(UUID id) {
        return repository.findById(id)
                .map(produto -> produto.add(linkTo(methodOn(ProdutoController.class).findById(produto.getId())).withSelfRel()))
                .orElseThrow(() -> new NaoEncontradoException("Produto com o id " + id + " não foi encontrado!"));
    }

    public ProdutoModel create(ProdutoModel produtoModel) {
        if (produtoModel == null) {
            throw new IsNullException("Produto == null!");
        }

        ProdutoModel produtoModelAtualizado = new ProdutoModel();
        BeanUtils.copyProperties(produtoModel, produtoModelAtualizado);
        repository.save(produtoModelAtualizado);

        return produtoModel.add(linkTo(methodOn(ProdutoController.class).findById(produtoModel.getId())).withSelfRel());
    }

    public ProdutoModel update(ProdutoModel produtoModel, UUID id) {
        return repository.findById(id)
                .map(produtoAchado -> {
                    BeanUtils.copyProperties(produtoModel, produtoAchado);
                    return repository.save(produtoModel).add(linkTo(methodOn(ProdutoController.class).findById(produtoModel.getId())).withSelfRel());
                }).orElseThrow(() -> new NaoEncontradoException("Produto não encontrado com o id " + id));
    }

    public void delete(UUID id) {
        repository.findById(id)
                .map(produtoModel -> {
                    repository.delete(produtoModel);
                    return id;
                }).orElseThrow(() -> new NaoEncontradoException("Produto não encontrado com o id " + id));
    }
}
