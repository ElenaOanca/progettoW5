package it.epicode.progettoW5;


import it.epicode.progettoW5.bean.Postazione;
import it.epicode.progettoW5.bean.Prenotazione;
import it.epicode.progettoW5.bean.TipoPostazione;
import it.epicode.progettoW5.bean.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    @Bean
    public Utente utente() {
        Utente u = new Utente();
        u.setUsername("Mario");
        u.setNomeCompleto("Rossi Mario");
        u.setEmail("mariorossi<@>gmail.com");

        return new Utente();

    }

    @Bean
    public Utente utente1() {
        Utente u = new Utente();
        u.setUsername("Giovanni");
        u.setNomeCompleto("Bianchi Giovanni");
        u.setEmail("bianchigiovanni<@>gmail.com");

        return new Utente();
    }

    @Bean
    public Utente utente3() {
        Utente u = new Utente();
        u.setUsername("Paolo");
        u.setNomeCompleto("Verdi Paolo");
        u.setEmail("verdipaolo<@>gmail.com");

        return new Utente();
    }

    @Bean
    public Utente utente2() {
        Utente u = new Utente();
        u.setUsername("Luigi");
        u.setNomeCompleto("Verdi Luigi");
        u.setEmail("luigiverdi<@>gmail.com");

        return new Utente();
    }


    @Bean
    public Postazione postazione() {
        Postazione p = new Postazione();

        p.setDescrizione("Postazione 1");
        p.setCodice("P1");
        p.setNumeroMassimoOccupanti(150);
        p.setTipo(TipoPostazione.OPENSPACE);
       return new Postazione();
    }

    @Bean
    public Postazione postazione2() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione 2");
        p.setCodice("P2");
        p.setNumeroMassimoOccupanti(150);
        p.setTipo(TipoPostazione.PRIVATO);
        return new Postazione();
    }

    @Bean
    public Postazione postazione3() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione 3");
        p.setCodice("P3");
        p.setNumeroMassimoOccupanti(150);
        p.setTipo(TipoPostazione.SALA_RIUNIONI);
        return new Postazione();
    }

    @Bean
    public Postazione postazione4() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione 4");
        p.setCodice("P4");
        p.setNumeroMassimoOccupanti(150);
        p.setTipo(TipoPostazione.OPENSPACE);
        return new Postazione();
    }

    @Bean
    public Postazione postazione5() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione 5");
        p.setCodice("P5");
        p.setNumeroMassimoOccupanti(150);
        p.setTipo(TipoPostazione.PRIVATO);
        return new Postazione();
    }

    @Bean
    public Postazione postazione6() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione 6");
        p.setCodice("P6");
        p.setNumeroMassimoOccupanti(150);
        p.setTipo(TipoPostazione.SALA_RIUNIONI);
        return new Postazione();
    }

    @Bean
    public Prenotazione prenotazione() {
        Prenotazione p = new Prenotazione();
        p.setData(LocalDate.parse("2021-10-10"));
        p.setUtente(utente());
        p.setPostazione(postazione());
        return new Prenotazione();
    }

    @Bean
    public Prenotazione prenotazione2() {
        Prenotazione p = new Prenotazione();
        p.setData(LocalDate.parse("2021-10-10"));
        p.setUtente(utente1());
        p.setPostazione(postazione2());
        return new Prenotazione();
    }

    @Bean
    public Prenotazione prenotazione3() {
        Prenotazione p = new Prenotazione();
        p.setData(LocalDate.parse("2021-10-10"));
        p.setUtente(utente2());
        p.setPostazione(postazione3());
        return new Prenotazione();
    }

}
