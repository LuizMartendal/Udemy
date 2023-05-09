package io.github.Rique25.Vendas.services;

import io.github.Rique25.Vendas.exceptions.BadRequestException;
import io.github.Rique25.Vendas.models.Cliente;
import io.github.Rique25.Vendas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente create(Cliente cliente) {
        if (cliente.getId() != null) {
            throw new BadRequestException("Id deve ser null");
        }
        return repository.save(cliente);
    }

    @Transactional
    public Cliente update(Cliente cliente, UUID id) {
        return this.repository.findById(id).map( c -> {
            cliente.setId(c.getId());
            cliente.setDataCadastro(c.getDataCadastro());
            System.out.println(cliente);
            return this.repository.save(cliente);
        }).orElseThrow(() -> new BadRequestException("Cliente não encontrado!"));
    }

    public Page<Cliente> getClientes(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Cliente getCliente(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado!"));
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
