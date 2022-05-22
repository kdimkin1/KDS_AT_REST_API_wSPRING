package kds.at.restbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidShipsIdException extends ResponseStatusException {
    public InvalidShipsIdException(HttpStatus status) {
        super(status);
    }
}
