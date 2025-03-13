package az.developia.springweb.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import az.developia.springweb.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(OurRuntimeException.class)
    public String handle(OurRuntimeException exc) {
        return exc.getBr().getFieldErrors().get(0).getField();
    }
}
