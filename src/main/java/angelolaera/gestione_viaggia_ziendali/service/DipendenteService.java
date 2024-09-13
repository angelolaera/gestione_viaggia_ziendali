package angelolaera.gestione_viaggia_ziendali.service;


import angelolaera.gestione_viaggia_ziendali.entities.Dipendente;
import angelolaera.gestione_viaggia_ziendali.exception.NotFoundException;
import angelolaera.gestione_viaggia_ziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    // RICERCA
    public List<Dipendente> trovaTutti() {
        return dipendenteRepository.findAll();
    }

    // SALVATGGIO
    public Dipendente salvaDipendente(Dipendente body) {
        return dipendenteRepository.save(body);
    }

    // RICERCA TRAMITE ID
    public Dipendente trovaPerId(UUID dipendenteId) {
        return dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new NotFoundException(dipendenteId));
    }

    // AGGIORNAMENTO TRAMITE ID
    public Dipendente trovaPerIdEAggiorna(UUID dipendenteId, Dipendente dipendenteAggiornato) {
        Dipendente dipendente = trovaPerId(dipendenteId);
        dipendente.setUsername(dipendenteAggiornato.getUsername());
        dipendente.setNome(dipendenteAggiornato.getNome());
        dipendente.setCognome(dipendenteAggiornato.getCognome());
        dipendente.setEmail(dipendenteAggiornato.getEmail());
        dipendente.setAvatar(dipendenteAggiornato.getAvatar());
        return dipendenteRepository.save(dipendente);
    }

    // CANCELLAZIONE TRAMITE ID
    public void trovaPerIdECancella(UUID dipendenteId) {
        Dipendente dipendente = trovaPerId(dipendenteId);
        dipendenteRepository.delete(dipendente);
    }
}

