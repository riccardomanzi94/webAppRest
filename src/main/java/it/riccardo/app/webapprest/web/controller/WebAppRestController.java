package it.riccardo.app.webapprest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.riccardo.app.webapprest.config.security.JwtProvider;
import it.riccardo.app.webapprest.model.dto.ErrorOutput;
import it.riccardo.app.webapprest.model.dto.LoginInputDto;
import it.riccardo.app.webapprest.model.dto.LoginOutputDto;
import it.riccardo.app.webapprest.model.entities.Articoli;
import it.riccardo.app.webapprest.model.entities.Utenti;
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

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/status")
    @ResponseBody
    public String getStatus(){
        final String serviceUp = "Service UP";
        return  serviceUp;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginInputDto body){

        final Optional<Utenti> user = utentiService.getUserByUsername(body.getUsername());
        if(!user.isPresent()){
            final ErrorOutput ex = new ErrorOutput();
            ex.setCode("401");
            ex.setMessage("Utente non presente");
            return new ResponseEntity<>(ex,HttpStatus.UNAUTHORIZED);
        }

        user.get().setPassword(body.getPassword());
        utentiService.salvaUtente(user.get());

        String jwt = jwtProvider.createJwt();
        LoginOutputDto dto = new LoginOutputDto();
        dto.setToken(jwt);
        return ResponseEntity.ok(dto);
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

    @PostMapping(value = "/articolo/aggiungi")
    public ResponseEntity<?> insArticolo(@RequestBody Articoli articolo){

        articoliService.InsArticolo(articolo);

        HttpHeaders headers = new HttpHeaders();
        ObjectNode responseNode = objectMapper.createObjectNode();

        headers.setContentType(MediaType.APPLICATION_JSON);
        responseNode.put("code",HttpStatus.OK.toString());
        responseNode.put("message","Inserimento articolo : " + articolo.getCodArt() + " avvenuta con successo !!! ");

        return new ResponseEntity<>(responseNode,headers,HttpStatus.CREATED);
    }

    @PostMapping(value = "utente/aggiungi")
    public ResponseEntity<?> aggiungiUser(@RequestBody Utenti user){
        Optional<Utenti> userDB = utentiService.getUserByUsername(user.getUsername());
        ErrorOutput out = new ErrorOutput();
        if(userDB.isPresent()){
            out.setCode("403");
            out.setMessage("Utente già presente sul DB !!!");
            return new ResponseEntity<>(out,HttpStatus.FORBIDDEN);
        }
        utentiService.salvaUtente(user);
        out.setCode("200");
        out.setMessage("Utente inserito nel DB !!!");
        return new ResponseEntity<>(out,HttpStatus.CREATED);
    }

    @PutMapping(value = "utente/aggiorna")
    public ResponseEntity<?> aggiornaUtente(@RequestBody Utenti user,@RequestParam(value = "id") Integer id){
        Optional<Utenti> userDB = utentiService.getUserById(id);
        ErrorOutput out = new ErrorOutput();
        if(!userDB.isPresent()){
            out.setCode("403");
            out.setMessage("Utente non presente sul DB !!!");
            return new ResponseEntity<>(out,HttpStatus.FORBIDDEN);
        }
        utentiService.aggiornaUtente(id,user);
        out.setCode("200");
        out.setMessage("Utente inserito nel DB !!!");
        return new ResponseEntity<>(out,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "utente/elimina")
    public ResponseEntity<?> cancellaUtente(@RequestBody Utenti user,@RequestParam(value = "id") Integer id){
        Optional<Utenti> userDB = utentiService.getUserById(id);
        ErrorOutput out = new ErrorOutput();
        if(!userDB.isPresent()){
            out.setCode("403");
            out.setMessage("Utente non presente sul DB !!!");
            return new ResponseEntity<>(out,HttpStatus.FORBIDDEN);
        }
        utentiService.eliminaUtente(id);
        out.setCode("200");
        out.setMessage("Utente inserito nel DB !!!");
        return new ResponseEntity<>(out,HttpStatus.CREATED);
    }



}
