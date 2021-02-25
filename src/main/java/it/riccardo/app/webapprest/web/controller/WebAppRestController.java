package it.riccardo.app.webapprest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.riccardo.app.webapprest.model.Articoli;
import it.riccardo.app.webapprest.model.Utenti;
import it.riccardo.app.webapprest.service.ArticoliService;
import it.riccardo.app.webapprest.service.UtentiService;
import it.riccardo.app.webapprest.web.exception.NotFoundException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class WebAppRestController {

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private ArticoliService articoliService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/status")
    public String getStatus(){
        return "service UP :-)";
    }

    @SneakyThrows
    @GetMapping(value = "/users",produces = "application/json")
    public List<Utenti> getAllUsers(){
        return utentiService.getAllUsers();
    }

    @SneakyThrows
    @GetMapping(value = "/user/{id}",produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){

        final Optional<Utenti> u =  utentiService.getUserById(id);
        if(!u.isPresent()){
            final NotFoundException ex = new NotFoundException();
            return new ResponseEntity<>(ex.getMessaggio(),HttpStatus.NOT_FOUND);
        }
        log.debug("Utente {} trovato",u.get().getId());

        return new ResponseEntity<>(u.get(),HttpStatus.OK);
    }

    @PostMapping(value = "/aggiungi/articolo")
    public ResponseEntity<?> insArticolo(@RequestBody Articoli articolo){

        articoliService.InsArticolo(articolo);

        HttpHeaders headers = new HttpHeaders();
        ObjectNode responseNode = objectMapper.createObjectNode();

        headers.setContentType(MediaType.APPLICATION_JSON);
        responseNode.put("code",HttpStatus.OK.toString());
        responseNode.put("message","Inserimento articolo : " + articolo.getCodArt() + " avvenuta con successo !!! ");

        return new ResponseEntity<>(responseNode,headers,HttpStatus.CREATED);

    }

}
