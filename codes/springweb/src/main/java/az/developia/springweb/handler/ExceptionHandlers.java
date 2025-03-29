package az.developia.springweb.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import az.developia.springweb.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handle(OurRuntimeException exc) {

        ExceptionResponse response = new ExceptionResponse();

        BindingResult br = exc.getBr();
        if (br == null) {

        } else {
            List<FieldError> fieldErrors = br.getFieldErrors();
            List<ValidationResponse> validations = new ArrayList<ValidationResponse>();
            for (FieldError error : fieldErrors) {
                ValidationResponse validation = new ValidationResponse();
                validation.setField(error.getField());
                validation.setErrorMessage(error.getDefaultMessage());
                validations.add(validation);
            }
            response.setValidations(validations);
        }
        response.setMessage(exc.getMessage());
        return response;
    }
}
