package movie.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyFieldException extends RuntimeException {
   private final ErrorResponse errorResponse = new ErrorResponse(
           HttpStatus.BAD_REQUEST, "Empty filed");
    public EmptyFieldException() {
    }
}
