package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public PropositionController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());

        return "book/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findBookWithAuthors(id));

        return "book/add";
    }

    @PostMapping("/edit/{id}")
    public String update(@Validated(PropositionValidatorGroup.class) Book book, BindingResult result,
                         @PathVariable Long id) {
        if (result.hasErrors()) {
            return "book/add";
        }

        book.setProposition(true);
        bookService.update(book);

        return "redirect:/proposition/list";
    }

    @PostMapping("/add")
    public String add(@Validated(PropositionValidatorGroup.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }

        book.setProposition(true);
        bookService.save(book);

        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.findAllPropositions();

        model.addAttribute("books", books);

        return "book/propositionList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);

        return "redirect:/proposition/list";
    }

    @ModelAttribute(name = "publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute(name = "authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }
}


