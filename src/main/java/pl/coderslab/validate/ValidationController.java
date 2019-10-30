package pl.coderslab.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    private final Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/book")
    public String validateBook(Model model) {
        Book book = new Book();
        List<FieldError> fieldErrors = new ArrayList<>();
        Set<ConstraintViolation<Book>> errors = validator.validate(book);

        if (!errors.isEmpty()) {
            for (ConstraintViolation<Book> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();

                fieldErrors.add(new FieldError(path, message));
            }
        }

        model.addAttribute("fieldErrors", fieldErrors);

        return "validate/book";
    }
}
