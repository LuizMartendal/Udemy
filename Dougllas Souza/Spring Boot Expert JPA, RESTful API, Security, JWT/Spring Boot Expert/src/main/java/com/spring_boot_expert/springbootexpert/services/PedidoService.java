package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.controllers.PedidoController;
import com.spring_boot_expert.springbootexpert.controllers.ProdutoController;
import com.spring_boot_expert.springbootexpert.dtos.*;
import com.spring_boot_expert.springbootexpert.exceptions.IsNullException;
import com.spring_boot_expert.springbootexpert.exceptions.NaoEncontradoException;
import com.spring_boot_expert.springbootexpert.models.ClienteModel;
import com.spring_boot_expert.springbootexpert.models.ItemPedidoModel;
import com.spring_boot_expert.springbootexpert.models.PedidoModel;
import com.spring_boot_expert.springbootexpert.models.ProdutoModel;
import com.spring_boot_expert.springbootexpert.repositories.ClienteRepository;
import com.spring_boot_expert.springbootexpert.repositories.ItemPedidoRepository;
import com.spring_boot_expert.springbootexpert.repositories.PedidoRepository;
import com.spring_boot_expert.springbootexpert.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public PagedModel<EntityModel<InformacoesPedidoDTO>> findAll(Pageable pageable) {
        Page<InformacoesPedidoDTO> pedidos = pedidoRepository.findAll(pageable)
                .map(pedido -> {
                    InformacoesPedidoDTO dto = converterPedidoToDto(pedido);
                    return dto.add(linkTo(methodOn(PedidoController.class).findById(dto.getCodigo())).withSelfRel());
                });
        Link link = linkTo(methodOn(PedidoController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "ASC")).withSelfRel();
        PagedResourcesAssembler<InformacoesPedidoDTO> assembler = new PagedResourcesAssembler<>(null, null);
        return assembler.toModel(pedidos, link);
    }

    @Transactional
    public PedidoModel save(PedidoDTO pedidoDTO) {
        UUID idCliente = pedidoDTO.getCliente();

        ClienteModel clienteModel = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado com o id " + idCliente));

        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setDataPedido(new Date());

        final double[] total = {0};
        pedidoDTO.getItens().forEach(item -> {
            int quantidade = item.getQuantidade();
            ProdutoModel produtoModel = produtoRepository.findById(item.getProduto())
                    .orElseThrow(() -> new NaoEncontradoException("Produto não encontrado com o id " + item.getProduto()));
            total[0] += (quantidade * produtoModel.getPrecoUnitario());
        });

        pedidoModel.setTotal(total[0]);
        pedidoModel.setCliente(clienteModel);

        List<ItemPedidoModel> itemPedido = convertItens(pedidoModel, pedidoDTO.getItens());
        pedidoRepository.save(pedidoModel);
        itemPedidoRepository.saveAll(itemPedido);
        pedidoModel.setItens(itemPedido);
        return pedidoModel.add(linkTo(methodOn(PedidoController.class).findById(pedidoModel.getId())).withSelfRel());
    }

    public Optional<PedidoModel> findById(UUID id) {
        return this.pedidoRepository.findById(id)
                .map(pedidoModel -> pedidoModel.add(
                        linkTo(methodOn(PedidoController.class).findById(pedidoModel.getId()))
                                .withSelfRel()));
    }

    public void updateStatus(UUID id, StatusPedidoDTO status) {
         this.pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setStatus(status.getStatus());
                    return pedidoRepository.save(pedido);
                }).orElseThrow(() -> new NaoEncontradoException("Pedido não encontrado"));
    }

    private List<ItemPedidoModel> convertItens(PedidoModel pedido, List<ItemPedidoDTO> itens) {
        if(itens.isEmpty()){
            throw new IsNullException("Não é possível realizar um pedido sem items.");
        }

        return itens
                .stream()
                .map(dto -> {
                    UUID idProduto = dto.getProduto();
                    ProdutoModel produto = produtoRepository.findById(idProduto)
                            .orElseThrow(() -> new NaoEncontradoException("Produto não encontrado com o id" + idProduto));
                    ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
                    itemPedidoModel.setQuantidade(dto.getQuantidade());
                    itemPedidoModel.setPedido(pedido);
                    itemPedidoModel.setProduto(produto);
                    return itemPedidoModel;
                }).collect(Collectors.toList());
    }

    private InformacoesPedidoDTO converterPedidoToDto(PedidoModel pedidoModel) {
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

    private List<InformacoesItemPedidoDTO> converterItensToDto(List<ItemPedidoModel> itens) {
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
