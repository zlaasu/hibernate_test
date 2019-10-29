package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;

public class BookAuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorService authorService;

    @Override
    public Author convert(String s) {
        return authorService.findOne(Long.parseLong(s));
    }
}
