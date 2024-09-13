package angelolaera.gestione_viaggia_ziendali.controller;

import angelolaera.gestione_viaggia_ziendali.entities.Dipendente;
import angelolaera.gestione_viaggia_ziendali.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    // 1. GET http://localhost:3001/dipendenti
    @GetMapping
    private List<Dipendente> getAllDipendenti() {
        return dipendenteService.trovaTutti();
    }

    // 2. GET http://localhost:3001/dipendenti/{id}
    @GetMapping("/{id}")
    private Dipendente getDipendenteById(@PathVariable UUID id) {
        return dipendenteService.trovaPerId(id);
    }

    // 3. POST http://localhost:3001/dipendenti (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Dipendente createDipendente(@RequestBody Dipendente body) {
        return dipendenteService.salvaDipendente(body);
    }

    // 4. PUT http://localhost:3001/dipendenti/{id} (+body)
    @PutMapping("/{id}")
    private Dipendente findDipendenteByIdAndUpdate(@PathVariable UUID id, @RequestBody Dipendente body) {
        return dipendenteService.trovaPerIdEAggiorna(id, body);
    }

    // 5. DELETE http://localhost:3001/dipendenti/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDipendente(@PathVariable UUID id) {
        dipendenteService.trovaPerIdECancella(id);
    }
}