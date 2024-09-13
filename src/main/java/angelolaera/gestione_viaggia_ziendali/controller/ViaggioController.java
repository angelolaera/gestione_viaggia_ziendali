package angelolaera.gestione_viaggia_ziendali.controller;

import angelolaera.gestione_viaggia_ziendali.entities.Viaggio;
import angelolaera.gestione_viaggia_ziendali.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    // 1. GET http://localhost:3001/viaggi
    @GetMapping
    private List<Viaggio> getAllViaggi() {
        return viaggioService.trovaTutti();
    }

    // 2. GET http://localhost:3001/viaggi/{id}
    @GetMapping("/{id}")
    private Viaggio getViaggioById(@PathVariable UUID id) {
        return viaggioService.trovaPerId(id);
    }

    // 3. POST http://localhost:3001/viaggi (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Viaggio createViaggio(@RequestBody Viaggio body) {
        return viaggioService.salvaViaggio(body);
    }

    // 4. PUT http://localhost:3001/viaggi/{id} (+body)
    @PutMapping("/{id}")
    private Viaggio findViaggioByIdAndUpdate(@PathVariable UUID id, @RequestBody Viaggio body) {
        return viaggioService.trovaPerIdEAggiorna(id, body);
    }

    // 5. DELETE http://localhost:3001/viaggi/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteViaggio(@PathVariable UUID id) {
        viaggioService.trovaPerIdECancella(id);
    }
}

