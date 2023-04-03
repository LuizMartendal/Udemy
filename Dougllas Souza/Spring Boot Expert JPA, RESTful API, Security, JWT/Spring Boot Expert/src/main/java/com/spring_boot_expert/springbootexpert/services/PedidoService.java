package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.dtos.ItemPedidoDTO;
import com.spring_boot_expert.springbootexpert.dtos.PedidoDTO;
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
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public Page<PedidoModel> findAll(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    @Transactional
    public PedidoModel save(PedidoDTO pedidoDTO) {
        UUID idCliente = pedidoDTO.getCliente();

        ClienteModel clienteModel = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new NullPointerException("Cliente não encontrado com o id " + idCliente));

        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setDataPedido(new Date());

        final double[] total = {0};
        pedidoDTO.getItens().forEach(item -> {
            int quantidade = item.getQuantidade();
            ProdutoModel produtoModel = produtoRepository.findById(item.getProduto())
                    .orElseThrow(() -> new NullPointerException("Produto não encontrado com o id " + item.getProduto()));
            total[0] += (quantidade * produtoModel.getPrecoUnitario());
        });

        pedidoModel.setTotal(total[0]);
        pedidoModel.setCliente(clienteModel);

        List<ItemPedidoModel> itemPedido = convertItens(pedidoModel, pedidoDTO.getItens());
        pedidoRepository.save(pedidoModel);
        itemPedidoRepository.saveAll(itemPedido);
        pedidoModel.setItens(itemPedido);
        return pedidoModel;
    }

    private List<ItemPedidoModel> convertItens(PedidoModel pedido, List<ItemPedidoDTO> itens) {
        if(itens.isEmpty()){
            throw new NullPointerException("Não é possível realizar um pedido sem items.");
        }

        return itens
                .stream()
                .map(dto -> {
                    UUID idProduto = dto.getProduto();
                    ProdutoModel produto = produtoRepository.findById(idProduto)
                            .orElseThrow(() -> new NullPointerException("Produto não encontrado com o id" + idProduto));
                    ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
                    itemPedidoModel.setQuantidade(dto.getQuantidade());
                    itemPedidoModel.setPedido(pedido);
                    itemPedidoModel.setProduto(produto);
                    return itemPedidoModel;
                }).collect(Collectors.toList());
    }
}
