package ua.lviv.yuriizhurakovskyi.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = DataNotFoundException.class)
    public final ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException exception) {
        return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public final ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException exception) {
        return new ResponseEntity<>("Bad Credentials", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = DisabledException.class)
    public final ResponseEntity<Object> handleDisabledException(DisabledException exception) {
        return new ResponseEntity<>("User Disabled Exception", HttpStatus.FORBIDDEN);
    }
}
