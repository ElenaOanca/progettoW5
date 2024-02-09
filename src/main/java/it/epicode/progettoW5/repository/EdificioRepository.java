package it.epicode.progettoW5.repository;



import it.epicode.progettoW5.bean.Edificio;
import it.epicode.progettoW5.bean.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    // Trova edifici per nome
    List<Edificio> findByNomeContaining(String nome);

    // Trova edifici per città
    List<Edificio> findByCitta(String citta);

    // Trova tutti gli edifici che hanno postazioni di un certo tipo
    List<Edificio> findByPostazioni_Tipo(TipoPostazione tipo);

    // Trova edifici con un certo indirizzo
    List<Edificio> findByIndirizzoContaining(String indirizzo);

    // Trova edifici con un numero minimo di postazioni
    @Query("SELECT e FROM Edificio e WHERE size(e.postazioni) >= ?1")
    List<Edificio> findWithMinimumNumberOfPostazioni(int minPostazioni);

    @Query("SELECT e FROM Edificio e WHERE e.nome = ?1")
    List<Edificio> findByName(String nome);

}


