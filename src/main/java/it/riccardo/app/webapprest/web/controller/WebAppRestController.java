package it.riccardo.app.webapprest.web.controller;

import it.riccardo.app.webapprest.model.Utenti;
import it.riccardo.app.webapprest.service.UtentiService;
import it.riccardo.app.webapprest.web.exception.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WebAppRestController {

    @Autowired
    private UtentiService utentiService;

    @GetMapping("/status")
    public String getStatus(){

        return "daje";
    }

    @SneakyThrows
    @GetMapping(value = "/users",produces = "application/json")
    public List<Utenti> getAllUsers(){
        return utentiService.getAllUsers();
    }

    @SneakyThrows
    @GetMapping(value = "/user/{id}",produces = "application/json")
    public ResponseEntity<Optional<Utenti>> getUserById(@PathVariable Integer id){

        final Optional<Utenti> u =  utentiService.getUserById(id);
        if(!u.isPresent()){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new NotFoundException("Utente non presente nel DB");
        }

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

}
