package angelolaera.gestione_viaggia_ziendali.exception;


import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(UUID id){
        super("L'elemento con id " + id + " non è stato trovato!");
    }
}
