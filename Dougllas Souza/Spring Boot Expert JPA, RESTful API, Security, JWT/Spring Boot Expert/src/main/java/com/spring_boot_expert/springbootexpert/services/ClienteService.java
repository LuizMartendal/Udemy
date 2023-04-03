package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.dtos.ClienteDTO;
import com.spring_boot_expert.springbootexpert.models.ClienteModel;
import com.spring_boot_expert.springbootexpert.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Page<ClienteDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(clienteModel -> {
                    ClienteDTO clienteDTO = new ClienteDTO();
                    BeanUtils.copyProperties(clienteModel, clienteDTO);
                    return clienteDTO;
                });
    }

    public ClienteDTO findById(UUID id) {
        return repository.findById(id)
                .map(clienteModel -> {
                    ClienteDTO clienteDTO = new ClienteDTO();
                    BeanUtils.copyProperties(clienteModel, clienteDTO);
                    return clienteDTO;
                }).orElseThrow(() -> new NullPointerException("Cliente com o id " + id + " não foi encontrado!"));
    }

    public ClienteDTO create(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new NullPointerException("Cliente null!");
        }

        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO, clienteModel);
        repository.save(clienteModel);

        return clienteDTO;
    }

    public ClienteDTO update(ClienteDTO clienteDTO, UUID id) {
        return repository.findById(id)
                .map(clienteModel -> {
                    BeanUtils.copyProperties(clienteDTO, clienteModel);
                    repository.save(clienteModel);
                    return clienteDTO;
                }).orElseThrow(() -> new NullPointerException("Cliente não encontrado com o id " + id));
    }

    public void delete(UUID id) {
        repository.findById(id)
                .map(clienteModel -> {
                    repository.delete(clienteModel);
                    return id;
                }).orElseThrow(() -> new NullPointerException("Cliente não encontrado com o id " + id));
    }
}
