package pl.coderslab.validate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldError {

    private String path;
    private String message;

    public FieldError(String path, String message) {
        this.path = path;
        this.message = message;
    }
}
