package it.epicode.progettoW5.service;

import io.micrometer.observation.ObservationFilter;
import it.epicode.progettoW5.bean.Prenotazione;
import it.epicode.progettoW5.bean.TipoPostazione;
import it.epicode.progettoW5.repository.PostazioneRepository;
import it.epicode.progettoW5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import it.epicode.progettoW5.bean.Postazione;
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findByPostazioneIdAndData(prenotazione.getPostazione().getId(), prenotazione.getData());
        if (prenotazioneEsistente.isPresent()) {
            throw new IllegalArgumentException("Postazione già prenotata in questa data");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> trovaPrenotazioniPerPostazione(Long idPostazione) {
        return prenotazioneRepository.findByPostazioneId(idPostazione);
    }

    public List<Prenotazione> trovaPrenotazioniPerUtente(Long idUtente) {
        return prenotazioneRepository.findByUtenteId(idUtente);
    }

    public List<Prenotazione> trovaPrenotazioniPerData(LocalDate data) {
        return prenotazioneRepository.findByData(data);
    }

    public List<Prenotazione> trovaPrenotazioniPerCitta(String citta) {
        return prenotazioneRepository.findByPostazioneEdificioCitta(citta);
    }

    public List<Prenotazione> trovaPrenotazioniPerTipoPostazione(TipoPostazione tipo) {
        return prenotazioneRepository.findByPostazioneTipo(tipo);
    }

    public void cancellaPrenotazione(Long idPrenotazione) {
        prenotazioneRepository.deleteById(idPrenotazione);
    }

    public void cancellaPrenotazioniPerUtente(Long idUtente) {
        prenotazioneRepository.deleteByUtenteId(idUtente);
    }

    public void cancellaPrenotazioniPerPostazione(Long idPostazione) {
        prenotazioneRepository.deleteByPostazioneId(idPostazione);
    }

    public void cancellaPrenotazioniPerData(LocalDate data) {
        prenotazioneRepository.deleteByData(data);
    }

    public void cancellaPrenotazioniPerCitta(String citta) {
        prenotazioneRepository.deleteByPostazioneEdificioCitta(citta);
    }


    public void cancellaPrenotazioniPerTipoPostazione(TipoPostazione tipo) {
        prenotazioneRepository.deleteByPostazioneTipo(tipo);
    }

    public void cancellaTutteLePrenotazioni() {
        prenotazioneRepository.deleteAll();
    }

//    public List<Postazione> trovaPostazioniLibereInData(LocalDate data) {
//        return postazioneRepository.findPostazioniLibereInData(data);
//    }

    public List<Postazione> trovaPostazioniPerNumeroMassimoOccupanti(int numero) {
        return postazioneRepository.findByNumeroMassimoOccupantiLessThanEqual(numero);
    }

    public List<Postazione> trovaPostazioniPerTipo(TipoPostazione tipo) {
        return postazioneRepository.findByTipo(tipo);
    }

    public List<Postazione> trovaPostazioniPerEdificio(String nomeEdificio) {
        return postazioneRepository.findByEdificio_Nome(nomeEdificio);
    }



    public List<Postazione> trovaPostazioniPerCitta(String citta) {
        return postazioneRepository.findByEdificio_Citta(citta);
    }

    public Postazione trovaPostazionePerId(Long id) {
        return postazioneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Postazione non trovata"));
    }

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }
}
