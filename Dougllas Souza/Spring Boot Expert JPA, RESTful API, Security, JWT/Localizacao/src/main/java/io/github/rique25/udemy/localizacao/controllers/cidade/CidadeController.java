package io.github.rique25.udemy.localizacao.controllers.cidade;

import io.github.rique25.udemy.localizacao.controllers.ControllerImpl;
import io.github.rique25.udemy.localizacao.models.Cidade;
import io.github.rique25.udemy.localizacao.services.Service;
import io.github.rique25.udemy.localizacao.services.cidade.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController extends ControllerImpl<Cidade> {

    @Autowired
    public CidadeService service;

    @Override
    public Service<Cidade> getService() {
        return service;
    }
}
