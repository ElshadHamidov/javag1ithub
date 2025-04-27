package az.book.manga.exception;

import org.springframework.validation.BindingResult;

public class OurRunTimeException extends RuntimeException {
    private final BindingResult br;

    public OurRunTimeException(BindingResult br) {
        this.br = br;
    }

    public BindingResult getBr() {
        return br;
    }
}
