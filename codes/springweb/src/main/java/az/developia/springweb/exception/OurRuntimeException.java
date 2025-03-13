package az.developia.springweb.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException {
    private final BindingResult br;

    public OurRuntimeException(BindingResult br) {
        this.br = br;
    }

    public BindingResult getBr() {
        return br;
    }
}
