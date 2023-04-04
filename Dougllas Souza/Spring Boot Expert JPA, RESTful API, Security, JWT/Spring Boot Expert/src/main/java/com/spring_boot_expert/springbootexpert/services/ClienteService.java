package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.controllers.ClienteController;
import com.spring_boot_expert.springbootexpert.dtos.ClienteDTO;
import com.spring_boot_expert.springbootexpert.exceptions.NaoEncontradoException;
import com.spring_boot_expert.springbootexpert.models.ClienteModel;
import com.spring_boot_expert.springbootexpert.repositories.ClienteRepository;
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
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public PagedModel<EntityModel<ClienteDTO>> findAll(Pageable pageable) {
        Page<ClienteDTO> clientes = repository.findAll(pageable)
                .map(clienteModel -> {
                    ClienteDTO cliente = new ClienteDTO();
                    BeanUtils.copyProperties(clienteModel, cliente);
                    return cliente.add(linkTo(methodOn(ClienteController.class).findById(cliente.getId())).withSelfRel());
                });
        PagedResourcesAssembler<ClienteDTO> assembler = new PagedResourcesAssembler<>(null, null);
        Link link =linkTo(methodOn(ClienteController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "ASC")).withSelfRel();
        return assembler.toModel(clientes, link);
    }

    public ClienteDTO findById(UUID id) {
        return repository.findById(id)
                .map(clienteModel -> {
                    ClienteDTO clienteDTO = new ClienteDTO();
                    BeanUtils.copyProperties(clienteModel, clienteDTO);
                    return clienteDTO.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
                }).orElseThrow(() -> new NaoEncontradoException("Cliente com o id " + id + " não foi encontrado!"));
    }

    public ClienteDTO create(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new NullPointerException("Cliente null!");
        }

        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO, clienteModel);
        repository.save(clienteModel);

        return clienteDTO.add(linkTo(methodOn(ClienteController.class).findById(clienteModel.getId())).withSelfRel());
    }

    public ClienteDTO update(ClienteDTO clienteDTO, UUID id) {
        return repository.findById(id)
                .map(clienteModel -> {
                    BeanUtils.copyProperties(clienteDTO, clienteModel);
                    repository.save(clienteModel);
                    return clienteDTO.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
                }).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado com o id " + id));
    }

    public void delete(UUID id) {
        repository.findById(id)
                .map(clienteModel -> {
                    repository.delete(clienteModel);
                    return id;
                }).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado com o id " + id));
    }
}
