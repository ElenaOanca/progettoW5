package it.epicode.progettoW5.service;



import it.epicode.progettoW5.bean.Prenotazione;
import it.epicode.progettoW5.bean.TipoPostazione;
import it.epicode.progettoW5.repository.PostazioneRepository;
import it.epicode.progettoW5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import it.epicode.progettoW5.bean.Postazione;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    // Metodo esistente per trovare tutte le postazioni
    public List<Postazione> findAll() {
        return postazioneRepository.findAll();
    }

    // Trova postazione per ID
    public Optional<Postazione> findById(Long id) {
        return postazioneRepository.findById(id);
    }

    // Trova postazioni per tipo
    public List<Postazione> findByTipo(TipoPostazione tipo) {
        return postazioneRepository.findByTipo(tipo);
    }

    // Trova postazioni in un certo edificio
    public List<Postazione> findByEdificio(String nomeEdificio) {
        return postazioneRepository.findByEdificio_Nome(nomeEdificio);
    }

    // Trova postazioni in una certa città
    public List<Postazione> findByCitta(String citta) {
        return postazioneRepository.findByEdificio_Citta(citta);
    }

    // Trova postazioni libere in una data specifica
//    public List<Postazione> findPostazioniLibereInData(LocalDate data) {
//        return postazioneRepository.findPostazioniLibereInData(data);
//    }

    // Trova postazioni per numero massimo di occupanti
    public List<Postazione> findByNumeroMassimoOccupanti(int numero) {
        return postazioneRepository.findByNumeroMassimoOccupantiLessThanEqual(numero);
    }

    // Aggiungi una nuova postazione
    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public boolean prenotaPostazione(Long postazioneId, LocalDate data, Long utenteId) {
        // Controlla se esiste già una prenotazione per la postazione nella data specificata
        PrenotazioneRepository prenotazioneRepository = null;
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findByPostazioneIdAndData(postazioneId, data);

        if (prenotazioneEsistente.isPresent()) {
            // La postazione è già prenotata per quella data
            return false;
        } else {
            // La postazione è libera, quindi procedi con la creazione di una nuova prenotazione
            Prenotazione nuovaPrenotazione = new Prenotazione();
            nuovaPrenotazione.getPostazioneId(postazioneId);
            nuovaPrenotazione.setData(data);
            nuovaPrenotazione.getUtenteId(utenteId);
            prenotazioneRepository.save(nuovaPrenotazione);

            return true;
        }
    }





}


