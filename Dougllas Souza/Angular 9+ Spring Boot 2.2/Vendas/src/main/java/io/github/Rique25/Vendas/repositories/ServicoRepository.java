package io.github.Rique25.Vendas.repositories;

import io.github.Rique25.Vendas.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
