package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
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
        model.addAttribute("book", bookService.findOne(id));

        return "book/add";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute Book book, @PathVariable Long id) {
        bookService.update(book);

        return "redirect:/book/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book) {
        bookService.save(book);

        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.findAll();

        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);

        return "redirect:/book/list";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findOne(id));

        return "book/confirmDelete";
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


//    @GetMapping("/update/{id}")
//    @ResponseBody
//    public String update(@PathVariable Long id) {
//        Book book = bookService.findOne(id);
//
//        book.setTitle("Thinking in Javaaaaaa!!!");
//
//        bookService.update(book);
//
//        return "Book updated, id = " + book.getId();
//    }
//
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public String delete(@PathVariable Long id) {
//        bookService.delete(id);
//
//        return "Book deleted, id = " + id;
//    }
//
//    @GetMapping("/find/{id}")
//    @ResponseBody
//    public String find(@PathVariable Long id) {
//        Book book = bookService.findOne(id);
//
//        if (book != null) {
//            return book.toString();
//        }
//
//        return "Book not found";
//    }

