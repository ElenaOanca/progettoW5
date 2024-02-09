package it.epicode.progettoW5.service;
import it.epicode.progettoW5.bean.Postazione;
import it.epicode.progettoW5.bean.Prenotazione;
import it.epicode.progettoW5.bean.TipoPostazione;
import it.epicode.progettoW5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.findAll();
    }



    @GetMapping("/postazione/{idPostazione}")
    public List<Prenotazione> getPrenotazioniByPostazione(@PathVariable Long idPostazione) {
        return prenotazioneService.trovaPrenotazioniPerPostazione(idPostazione);
    }

    @GetMapping("/utente/{idUtente}")
    public List<Prenotazione> getPrenotazioniByUtente(@PathVariable Long idUtente) {
        return prenotazioneService.trovaPrenotazioniPerUtente(idUtente);
    }

    @GetMapping("/data/{data}")
    public List<Prenotazione> getPrenotazioniByData(@PathVariable LocalDate data) {
        return prenotazioneService.trovaPrenotazioniPerData(data);
    }

    @GetMapping("/città/{città}")
    public List<Prenotazione> getPrenotazioniByCitta(@PathVariable String citta) {
        return prenotazioneService.trovaPrenotazioniPerCitta(citta);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Prenotazione> getPrenotazioniByTipoPostazione(@PathVariable TipoPostazione tipo) {
        return prenotazioneService.trovaPrenotazioniPerTipoPostazione(tipo);
    }

    @PostMapping
    public Prenotazione addPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.creaPrenotazione(prenotazione);
    }

    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.cancellaPrenotazione(id);
    }

    @DeleteMapping("/utente/{idUtente}")
    public void deletePrenotazioniByUtente(@PathVariable Long idUtente) {
        prenotazioneService.cancellaPrenotazioniPerUtente(idUtente);
    }

    @DeleteMapping("/postazione/{idPostazione}")
    public void deletePrenotazioniByPostazione(@PathVariable Long idPostazione) {
        prenotazioneService.cancellaPrenotazioniPerPostazione(idPostazione);
    }

    @DeleteMapping("/data/{data}")
    public void deletePrenotazioniByData(@PathVariable LocalDate data) {
        prenotazioneService.cancellaPrenotazioniPerData(data);
    }



}
