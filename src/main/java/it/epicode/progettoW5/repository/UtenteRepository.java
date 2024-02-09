package it.epicode.progettoW5.repository;



import it.epicode.progettoW5.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    // Trova utente per username
    Optional<Utente> findByUsername(String username);

    // Trova utenti per nome completo
    List<Utente> findByNomeCompletoContaining(String nomeCompleto);

    // Trova utente per email
    Optional<Utente> findByEmail(String email);

    // Trova tutti gli utenti con una prenotazione in una specifica data
    @Query("SELECT u FROM Utente u WHERE u.id IN " +
            "(SELECT p.utente.id FROM Prenotazione p WHERE p.data = ?1)")
    List<Utente> findUtentiConPrenotazioneInData(LocalDate data);
}



