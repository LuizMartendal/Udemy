package io.github.rique25.udemy.localizacao.repositories.cidade;

import io.github.rique25.udemy.localizacao.models.Cidade;
import io.github.rique25.udemy.localizacao.repositories.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeRepositoryImpl {

    @Autowired
    private CidadeRepository repository;


}
