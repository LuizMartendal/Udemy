package com.spring_boot_expert.springbootexpert.repositories;

import com.spring_boot_expert.springbootexpert.models.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, UUID> {
}
