package com.spring_boot_expert.springbootexpert.controllers;

import com.spring_boot_expert.springbootexpert.dtos.ClienteDTO;
import com.spring_boot_expert.springbootexpert.dtos.PedidoDTO;
import com.spring_boot_expert.springbootexpert.models.PedidoModel;
import com.spring_boot_expert.springbootexpert.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PedidoModel> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    @RequestParam(value = "direction", defaultValue = "asc") String direction)
    {
        var sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "id"));
        return service.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID save(@RequestBody PedidoDTO pedidoDTO) {
        PedidoModel pedido = service.save(pedidoDTO);
        return pedido.getId();
    }
}
