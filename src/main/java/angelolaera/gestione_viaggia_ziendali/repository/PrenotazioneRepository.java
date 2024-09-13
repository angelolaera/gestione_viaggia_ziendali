package angelolaera.gestione_viaggia_ziendali.repository;

import angelolaera.gestione_viaggia_ziendali.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository <Prenotazione, UUID> {
}
