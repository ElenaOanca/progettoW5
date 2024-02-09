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

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
    @Autowired
    private PostazioneService postazioneService;

    // Endpoint esistente per ottenere tutte le postazioni
    @GetMapping
    public List<Postazione> getAllPostazioni() {
        return postazioneService.findAll();
    }

    // Trova postazione per ID
    @GetMapping("/{id}")
    public ResponseEntity<Postazione> getPostazioneById(@PathVariable Long id) {
        return postazioneService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Trova postazioni per tipo
    @GetMapping("/tipo/{tipo}")
    public List<Postazione> getPostazioniByTipo(@PathVariable TipoPostazione tipo) {
        return postazioneService.findByTipo(tipo);
    }

    // Trova postazioni in una certa città
    @GetMapping("/città/{città}")
    public List<Postazione> getPostazioniByCitta(@PathVariable String citta) {
        return postazioneService.findByCitta(citta);
    }

    // Trova postazioni libere in una data specifica
//    @GetMapping("/disponibili/{data}")
//    public List<Postazione> getPostazioniLibere(@PathVariable LocalDate data) {
//        return postazioneService.findPostazioniLibereInData(data);
//    }

    // Aggiungi una nuova postazione
    @PostMapping
    public Postazione addPostazione(@RequestBody Postazione postazione) {
        return postazioneService.savePostazione(postazione);
    }





}

