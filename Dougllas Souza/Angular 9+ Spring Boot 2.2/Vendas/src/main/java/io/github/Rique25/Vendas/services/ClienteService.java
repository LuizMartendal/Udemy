package io.github.Rique25.Vendas.services;

import io.github.Rique25.Vendas.exceptions.BadRequestException;
import io.github.Rique25.Vendas.models.Cliente;
import io.github.Rique25.Vendas.repositories.ClienteRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente create(Cliente cliente) {
        if (cliente.getId() != null) {
            throw new BadRequestException("Id deve ser null");
        }
        return repository.save(cliente);
    }
}
