package it.epicode.progettoW5.service;

import it.epicode.progettoW5.bean.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/utenti")
    public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente) {
        Utente utenteCreato = utenteService.creaUtente(utente);
        return ResponseEntity.ok(utenteCreato);
    }
}
