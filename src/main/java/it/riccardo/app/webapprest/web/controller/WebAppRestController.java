package it.riccardo.app.webapprest.web.controller;

import it.riccardo.app.webapprest.model.Utenti;
import it.riccardo.app.webapprest.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebAppRestController {



    @Autowired
    private UtentiService utentiService;

    @GetMapping("/status")
    public String getStatus(){

        return "daje";
    }

    @GetMapping("/users")
    public List<Utenti> getAllUsers(){
        return utentiService.getAllUsers();
    }

}
