package io.github.Rique25.Vendas.services;

import io.github.Rique25.Vendas.exceptions.BadRequestException;
import io.github.Rique25.Vendas.models.Cliente;
import io.github.Rique25.Vendas.models.Servico;
import io.github.Rique25.Vendas.repositories.ClienteRepository;
import io.github.Rique25.Vendas.repositories.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Servico create(Servico servico) {
        return repository.save(servico);
    }

    private Cliente getCliente(String id) {
        return this.clienteRepository.findById(UUID.fromString(id)).get();
    }

    @Transactional
    public Servico update(Servico cliente, UUID id) {
        return this.repository.findById(id).map( c -> {
            cliente.setId(c.getId());
            cliente.setDataCadastro(c.getDataCadastro());
            return this.repository.save(cliente);
        }).orElseThrow(() -> new BadRequestException("Serviço não encontrado!"));
    }

    public Page<Servico> getServicos(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Servico getServico(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Servico não encontrado!"));
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
