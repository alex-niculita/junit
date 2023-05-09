package sky.pro.junittests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
public class ParameterMissingException extends RuntimeException{
    public ParameterMissingException(String message) {
        super(message);
    }
}
