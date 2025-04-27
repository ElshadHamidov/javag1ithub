package az.book.manga.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.book.manga.exception.InvalidCredentialsException;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.response.ExceptionResponse;
import az.book.manga.response.ValidationResponse;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED) // 401
    public ExceptionResponse handleInvalidCredentialsException(InvalidCredentialsException exc) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exc.getMessage());
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // 400
    public ExceptionResponse handleOurRuntimeException(OurRuntimeException exc) {
        ExceptionResponse response = new ExceptionResponse();
        BindingResult br = exc.getBr();
        if (br != null) {
            List<FieldError> fieldErrors = br.getFieldErrors();
            List<ValidationResponse> validations = new ArrayList<>();
            for (FieldError fieldError : fieldErrors) {
                ValidationResponse validation = new ValidationResponse();
                validation.setField(fieldError.getField());
                validation.setErrorMessage(fieldError.getDefaultMessage());
                validations.add(validation);
            }
            response.setValidations(validations);
        }
        response.setMessage(exc.getMessage());
        return response;
    }
}
