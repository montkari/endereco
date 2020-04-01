package br.com.bancopan.endereco.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public ClienteNaoEncontradoException(String exception) {
        super(exception);
    }

}
