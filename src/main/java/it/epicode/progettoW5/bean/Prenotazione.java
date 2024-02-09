package it.epicode.progettoW5.bean;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate data;
    // getter e setter

public Prenotazione() {
    }

    public Prenotazione(Utente utente, Postazione postazione, LocalDate data) {
        this.utente = utente;
        this.postazione = postazione;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", utente=" + utente +
                ", postazione=" + postazione +
                ", data=" + data +
                '}';
    }


 //metodo getPostazioneId per ottenere id della postazione

    public void getPostazioneId(Long postazioneId) {

        this.postazione.getId();


    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return id.equals(that.id);
    }

    //metodo per ottenere id dell'utente

    public void getUtenteId(Long utenteId) {

        this.utente.getId();


    }
}


