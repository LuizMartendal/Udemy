package com.rique25.agenda.services;

import com.rique25.agenda.models.Contato;
import com.rique25.agenda.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato save( Contato contato ) {
        return this.contatoRepository.save( contato );
    }

    public Contato update ( UUID id, Contato contato ) {
        Optional<Contato> contatoRetornado = this.contatoRepository.findById(id);
        if ( contatoRetornado.isPresent() ) {
            contato.setId(contatoRetornado.get().getId());
            return this.contatoRepository.save(contato);
        }
        throw new RuntimeException( "Contato não encontrado!" );
    }

    public Page<Contato> list( Pageable pageable ) {
        return this.contatoRepository.findAll(pageable);
    }

    public Contato findById( UUID id ) {
        return this.contatoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Contato não encontrado!"));
    }

    public Contato setFavorito( UUID id, Boolean favorito ) {
        Optional<Contato> contatoRetornado = this.contatoRepository.findById(id);

        if (contatoRetornado.isPresent()) {
            contatoRetornado.get()
                    .setFavorito(favorito);
            return this.contatoRepository.save(contatoRetornado.get());
        }

        throw new RuntimeException("Contato não encontrado!");
    }
}
