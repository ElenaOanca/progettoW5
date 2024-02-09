package it.epicode.progettoW5.bean;



import jakarta.persistence.*;




import java.util.List;
import java.util.Set;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nomeCompleto;
    private String email;
    @ManyToMany
    @JoinTable(name = "prenotazione",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "postazione_id"))



    private List<Postazione> postazioni;
//    private Set<Prenotazione> prenotazioni;


    public Utente() {
    }

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Prenotazione> getPrenotazioni() {
//        return prenotazioni;
//    }

//    public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
//        this.prenotazioni = prenotazioni;
//    }

    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
