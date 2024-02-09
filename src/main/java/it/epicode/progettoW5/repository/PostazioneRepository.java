package it.epicode.progettoW5.repository;


import it.epicode.progettoW5.bean.Postazione;
import it.epicode.progettoW5.bean.TipoPostazione;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {



    // Definisci qui il nuovo metodo
    List<Postazione> findByNumeroMassimoOccupantiLessThanEqual(int numeroMassimoOccupanti);


    List<Postazione> findByTipo(TipoPostazione tipo);

    List<Postazione> findByEdificio_Nome(String nomeEdificio);

    List<Postazione> findByEdificio_Citta(String citta);

//    List<Postazione> findPostazioniLibereInData(LocalDate data);
}


