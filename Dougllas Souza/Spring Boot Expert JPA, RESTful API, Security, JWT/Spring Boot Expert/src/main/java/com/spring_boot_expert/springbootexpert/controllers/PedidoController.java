package com.spring_boot_expert.springbootexpert.controllers;

import com.spring_boot_expert.springbootexpert.dtos.InformacoesItemPedidoDTO;
import com.spring_boot_expert.springbootexpert.dtos.InformacoesPedidoDTO;
import com.spring_boot_expert.springbootexpert.dtos.PedidoDTO;
import com.spring_boot_expert.springbootexpert.dtos.StatusPedidoDTO;
import com.spring_boot_expert.springbootexpert.exceptions.NaoEncontradoException;
import com.spring_boot_expert.springbootexpert.models.ItemPedidoModel;
import com.spring_boot_expert.springbootexpert.models.PedidoModel;
import com.spring_boot_expert.springbootexpert.services.PedidoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID save(@RequestBody PedidoDTO pedidoDTO) {
        PedidoModel pedido = service.save(pedidoDTO);
        return pedido.getId();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<EntityModel<InformacoesPedidoDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                @RequestParam(value = "size", defaultValue = "10") int size,
                                                                @RequestParam(value = "direction", defaultValue = "asc") String direction)
    {
        Sort.Direction d = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(d, "cliente"));
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InformacoesPedidoDTO findById(@PathVariable @NotNull UUID id) {
        return this.service.findById(id)
                .map(this::converterPedidoToDto).orElseThrow(() -> new NaoEncontradoException("Pedido não encontrado!"));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStatus(@PathVariable @NotNull UUID id,
                             @RequestBody StatusPedidoDTO status)
    {
        this.service.updateStatus(id, status);
    }

    private InformacoesPedidoDTO converterPedidoToDto(@NotNull PedidoModel pedidoModel) {
        InformacoesPedidoDTO dto = new InformacoesPedidoDTO();

        dto.setCodigo(pedidoModel.getId());
        dto.setCfp(pedidoModel.getCliente().getCpf());
        dto.setNomeCliente(pedidoModel.getCliente().getNome());
        dto.setDataPedido(pedidoModel.getDataPedido());
        dto.setTotal(pedidoModel.getTotal());
        dto.setStatus(pedidoModel.getStatus());
        dto.setItens(converterItensToDto(pedidoModel.getItens()));
        return dto;
    }

    private List<InformacoesItemPedidoDTO> converterItensToDto(@NotNull List<ItemPedidoModel> itens) {
        List<InformacoesItemPedidoDTO> itensDto = new ArrayList<>();
        for (ItemPedidoModel item: itens) {
            InformacoesItemPedidoDTO itemDto = new InformacoesItemPedidoDTO();
            itemDto.setDescricaoProduto(item.getProduto().getDescricao());
            itemDto.setQuantidade(item.getQuantidade());
            itemDto.setPrecoUnitario(item.getProduto().getPrecoUnitario());
            itensDto.add(itemDto);
        }
        return itensDto;
    }
}
