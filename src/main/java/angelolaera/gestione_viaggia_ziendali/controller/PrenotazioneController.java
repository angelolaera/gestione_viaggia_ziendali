package angelolaera.gestione_viaggia_ziendali.controller;

import angelolaera.gestione_viaggia_ziendali.entities.Prenotazione;
import angelolaera.gestione_viaggia_ziendali.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    // 1. GET http://localhost:3001/prenotazioni
    @GetMapping
    private List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.trovaTutte();
    }

    // 2. GET http://localhost:3001/prenotazioni/{id}
    @GetMapping("/{id}")
    private Prenotazione getPrenotazioneById(@PathVariable UUID id) {
        return prenotazioneService.trovaPerId(id);
    }

    // 3. POST http://localhost:3001/prenotazioni (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Prenotazione createPrenotazione(@RequestBody Prenotazione body) {
        return prenotazioneService.salvaPrenotazione(body);
    }

    // 4. PUT http://localhost:3001/prenotazioni/{id} (+body)
    @PutMapping("/{id}")
    private Prenotazione findPrenotazioneByIdAndUpdate(@PathVariable UUID id, @RequestBody Prenotazione body) {
        return prenotazioneService.trovaPerIdEAggiorna(id, body);
    }

    // 5. DELETE http://localhost:3001/prenotazioni/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletePrenotazione(@PathVariable UUID id) {
        prenotazioneService.trovaPerIdECancella(id);
    }
}
