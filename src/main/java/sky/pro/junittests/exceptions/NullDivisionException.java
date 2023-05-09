package sky.pro.junittests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NullDivisionException extends IllegalArgumentException{
    public NullDivisionException(String message) {
        super(message);
    }
}
