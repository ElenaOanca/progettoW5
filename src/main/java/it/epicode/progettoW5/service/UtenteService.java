package it.epicode.progettoW5.service;

import it.epicode.progettoW5.bean.Utente;
import it.epicode.progettoW5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente creaUtente(Utente utente) {

        return utenteRepository.save(utente);
    }
}
