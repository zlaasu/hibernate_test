package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("authors", authorService.findAll());

        return "author/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorService.findOne(id));

        return "author/add";
    }

    @GetMapping("/add")
    public String edit(Model model) {
        model.addAttribute("author", new Author());

        return "author/add";
    }

    @PostMapping("/add")
    public String update(@ModelAttribute Author author) {
        authorService.save(author);

        return "redirect:/author/list";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Author author, @PathVariable Long id) {
        authorService.update(author);

        return "redirect:/author/list";
    }

    @GetMapping("/delete/{id}")
    public String edit(@PathVariable Long id) {
        authorService.delete(id);

        return "redirect:/author/list";
    }
}