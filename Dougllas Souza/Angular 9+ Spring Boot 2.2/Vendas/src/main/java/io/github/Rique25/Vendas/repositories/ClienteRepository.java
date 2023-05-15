package io.github.Rique25.Vendas.repositories;

import io.github.Rique25.Vendas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Cliente findByCpf(String cpf);
}
