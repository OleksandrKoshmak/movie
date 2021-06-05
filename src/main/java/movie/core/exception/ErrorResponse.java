package movie.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus
public class ErrorResponse {

    private final HttpStatus status;
    private final String message;


    public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
