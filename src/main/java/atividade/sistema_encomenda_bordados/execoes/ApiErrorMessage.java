package atividade.sistema_encomenda_bordados.execoes;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class ApiErrorMessage {
    private HttpStatus status;
    private List<String> errors;

    public ApiErrorMessage(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatus status, String error) {
        this.status = status;
        this.errors = Collections.singletonList(error);
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }
}
