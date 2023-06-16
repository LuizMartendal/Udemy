package com.rique25.agenda.services;

import com.rique25.agenda.models.Contato;
import com.rique25.agenda.repositories.ContatoRepository;
import com.rique25.agenda.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public Contato save( Contato contato ) {
        return this.contatoRepository.save( contato );
    }

    @Transactional
    public Contato update ( UUID id, Contato contato ) {
        Optional<Contato> contatoRetornado = this.contatoRepository.findById(id);
        if ( contatoRetornado.isPresent() ) {
            contato.setId(contatoRetornado.get().getId());
            return this.contatoRepository.save(contato);
        }
        throw new RuntimeException( "Contato não encontrado!" );
    }

    public Page<Contato> list( Pageable pageable ) {
        List<Contato> contatos = this.contatoRepository.findAll();
        return new Page<>(
        this.contatoRepository.findAll(pageable).getContent(),
        (long) pageable.getPageSize() > 0 ? pageable.getPageSize() / contatos.size() : 1L,
        contatos.size());
    }

    public Contato findById( UUID id ) {
        return this.contatoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Contato não encontrado!"));
    }

    @Transactional
    public Contato setFavorito( UUID id, boolean favorito ) {
        Optional<Contato> contatoRetornado = this.contatoRepository.findById(id);

        if (contatoRetornado.isPresent()) {
            contatoRetornado.get()
                    .setFavorito(favorito);
            return this.contatoRepository.save(contatoRetornado.get());
        }

        throw new RuntimeException("Contato não encontrado!");
    }

    @Transactional
    public void delete( UUID id ) {
        Optional<Contato> contatoOptional = this.contatoRepository.findById(id);

        if (contatoOptional.isEmpty()) {
            throw new RuntimeException("Contato não encontrado!");
        }

        this.contatoRepository.delete(contatoOptional.get());
    }
}
