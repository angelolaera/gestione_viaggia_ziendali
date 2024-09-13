package angelolaera.gestione_viaggia_ziendali.service;


import angelolaera.gestione_viaggia_ziendali.entities.Prenotazione;
import angelolaera.gestione_viaggia_ziendali.exception.NotFoundException;
import angelolaera.gestione_viaggia_ziendali.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    // RICERCA
    public List<Prenotazione> trovaTutte() {
        return prenotazioneRepository.findAll();
    }

    // SALVATGGIO
    public Prenotazione salvaPrenotazione(Prenotazione body) {
        return prenotazioneRepository.save(body);
    }

    // RICERCA TRAMITE ID
    public Prenotazione trovaPerId(UUID prenotazioneId) {
        return prenotazioneRepository.findById(prenotazioneId)
                .orElseThrow(() -> new NotFoundException(prenotazioneId));
    }

    // AGGIORNAMENTO TRAMITE ID
    public Prenotazione trovaPerIdEAggiorna(UUID prenotazioneId, Prenotazione prenotazioneAggiornata) {
        Prenotazione prenotazione = trovaPerId(prenotazioneId);
        prenotazione.setData(prenotazioneAggiornata.getData());
        prenotazione.setPreferenze(prenotazioneAggiornata.getPreferenze());
        prenotazione.setViaggio(prenotazioneAggiornata.getViaggio());
        prenotazione.setDipendente(prenotazioneAggiornata.getDipendente());
        return prenotazioneRepository.save(prenotazione);
    }

    // CANCELLAZIONE TRAMITE ID
    public void trovaPerIdECancella(UUID prenotazioneId) {
        Prenotazione prenotazione = trovaPerId(prenotazioneId);
        prenotazioneRepository.delete(prenotazione);
    }
}

