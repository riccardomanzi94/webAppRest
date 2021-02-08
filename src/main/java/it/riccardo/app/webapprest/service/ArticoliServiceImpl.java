package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.Articoli;
import it.riccardo.app.webapprest.repository.ArticoliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArticoliServiceImpl implements ArticoliService{

    @Autowired
    private ArticoliRepository articoliRepository;

    @Override
    @Transactional
    public void InsArticolo(Articoli a) {

        articoliRepository.save(a);

    }

}
