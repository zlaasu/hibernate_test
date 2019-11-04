package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/booktest")
public class BookTestController {

    private final BookService bookService;

    @Autowired
    public BookTestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/title/{title}")
    @ResponseBody
    public String getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBookByTitle(title);

//        return books.stream().map(s -> s.toString()).collect(Collectors.joining(" | "));
        return books.toString();
    }

    @GetMapping("/category/{categoryId}")
    @ResponseBody
    public String getBooksByCategory(@PathVariable Long categoryId) {
        List<Book> books = bookService.getBooksByCategoryId(categoryId);

//        return books.stream().map(s -> s.toString()).collect(Collectors.joining(" | "));
        return books.toString();
    }

    @GetMapping("/findByAuthorsId/{authorId}")
    @ResponseBody
    public String findByAuthorsId(@PathVariable Long authorId) {
        return bookService.findByAuthorsId(authorId).toString();
    }

    @GetMapping("/findByPublisherId/{id}")
    @ResponseBody
    public String findByPublisherId(@PathVariable Long id) {
        return bookService.findByPublisherId(id).toString();
    }

    @GetMapping("/findByRating/{id}")
    @ResponseBody
    public String findByRating(@PathVariable int id) {
        return bookService.findByRating(id).toString();
    }

    @GetMapping("/findByRatingBetween/{start}/{stop}")
    @ResponseBody
    public String findByRatingBetween(@PathVariable int start, @PathVariable int stop) {
        return bookService.findByRatingBetween(start, stop).toString();
    }

    @GetMapping("/findFirstByCategoryIdOrderByTitle/{id}")
    @ResponseBody
    public String findFirstByCategoryIdOrderByTitle(@PathVariable Long id) {
        return bookService.findFirstByCategoryIdOrderByTitle(id).toString();
    }
}