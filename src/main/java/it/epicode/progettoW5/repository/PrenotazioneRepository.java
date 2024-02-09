package it.epicode.progettoW5.repository;

import it.epicode.progettoW5.bean.Prenotazione;
import it.epicode.progettoW5.bean.TipoPostazione;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrenotazioneRepository {
    Optional<Prenotazione> findByPostazioneIdAndData(Long postazioneId, LocalDate data);



    Prenotazione save(Prenotazione prenotazione);


    List<Prenotazione> findByPostazioneId(Long idPostazione);

    List<Prenotazione> findByUtenteId(Long idUtente);

    List<Prenotazione> findByData(LocalDate data);

    List<Prenotazione> findByPostazioneEdificioCitta(String citta);

    List<Prenotazione> findByPostazioneTipo(TipoPostazione tipo);

    void deleteById(Long idPrenotazione);

    void deleteByUtenteId(Long idUtente);

    void deleteByPostazioneId(Long idPostazione);

    void deleteByData(LocalDate data);

    void deleteByPostazioneEdificioCitta(String citta);

    void deleteByPostazioneTipo(TipoPostazione tipo);

    void deleteAll();

    List<Prenotazione> findAll();
}
