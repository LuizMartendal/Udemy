package com.spring_boot_expert.springbootexpert.repositories;

import com.spring_boot_expert.springbootexpert.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
