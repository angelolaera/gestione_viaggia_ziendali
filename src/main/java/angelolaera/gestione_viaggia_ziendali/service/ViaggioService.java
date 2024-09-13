package angelolaera.gestione_viaggia_ziendali.service;

import angelolaera.gestione_viaggia_ziendali.entities.Viaggio;
import angelolaera.gestione_viaggia_ziendali.exception.NotFoundException;
import angelolaera.gestione_viaggia_ziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {

    private final ViaggioRepository viaggioRepository;

    @Autowired
    public ViaggioService(ViaggioRepository viaggioRepository) {
        this.viaggioRepository = viaggioRepository;
    }

    // RICERCA
    public List<Viaggio> trovaTutti() {
        return viaggioRepository.findAll();
    }

    // SALVATGGIO
    public Viaggio salvaViaggio(Viaggio body) {
        return viaggioRepository.save(body);
    }

    // RICERCA TRAMITE ID
    public Viaggio trovaPerId(UUID viaggioId) {
        return viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new NotFoundException(viaggioId));
    }

    // AGGIORNAMENTO TRAMITE ID
    public Viaggio trovaPerIdEAggiorna(UUID viaggioId, Viaggio viaggioAggiornato) {
        Viaggio viaggio = trovaPerId(viaggioId);
        viaggio.setDestinazione(viaggioAggiornato.getDestinazione());
        viaggio.setData(viaggioAggiornato.getData());
        viaggio.setStatoViaggio(viaggioAggiornato.getStatoViaggio());
        return viaggioRepository.save(viaggio);
    }

    // CANCELLAZIONE TRAMITE ID
    public void trovaPerIdECancella(UUID viaggioId) {
        Viaggio viaggio = trovaPerId(viaggioId);
        viaggioRepository.delete(viaggio);
    }
}
