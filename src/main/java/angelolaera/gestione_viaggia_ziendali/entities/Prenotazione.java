package angelolaera.gestione_viaggia_ziendali.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="reservation")

public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private LocalDate data;
    private String preferenze;

    @ManyToOne
    @JoinColumn(name="id_viaggio")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "id_dipendente")
    private Dipendente dipendente;

}
