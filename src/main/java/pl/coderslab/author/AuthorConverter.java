package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorService authorService;

    @Override
    public Author convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        return authorService.findOne(Long.parseLong(s));
    }
}
