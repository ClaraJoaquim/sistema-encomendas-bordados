package atividade.sistema_encomenda_bordados.execoes;

public class ResourceNotFoundException extends  RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(String.format("%s com o ID %d não foi encontrado.", resourceName, id));
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
