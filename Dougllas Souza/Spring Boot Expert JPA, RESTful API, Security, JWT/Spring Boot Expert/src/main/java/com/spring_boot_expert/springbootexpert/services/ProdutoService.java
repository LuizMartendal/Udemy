package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.models.ProdutoModel;
import com.spring_boot_expert.springbootexpert.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Page<ProdutoModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ProdutoModel findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException("Produto com o id " + id + " não foi encontrado!"));
    }

    public ProdutoModel create(ProdutoModel produtoModel) {
        if (produtoModel == null) {
            throw new NullPointerException("Produto == null!");
        }

        ProdutoModel produtoModelAtualizado = new ProdutoModel();
        BeanUtils.copyProperties(produtoModel, produtoModelAtualizado);
        repository.save(produtoModelAtualizado);

        return produtoModel;
    }

    public ProdutoModel update(ProdutoModel produtoModel, UUID id) {
        return repository.findById(id)
                .map(produtoAchado -> {
                    BeanUtils.copyProperties(produtoModel, produtoAchado);
                    return repository.save(produtoModel);
                }).orElseThrow(() -> new NullPointerException("Produto não encontrado com o id " + id));
    }

    public void delete(UUID id) {
        repository.findById(id)
                .map(produtoModel -> {
                    repository.delete(produtoModel);
                    return id;
                }).orElseThrow(() -> new NullPointerException("Produto não encontrado com o id " + id));
    }
}
