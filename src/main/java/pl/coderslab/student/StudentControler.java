package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentControler {

    List<Student> students = new ArrayList<>();

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());

        return "student/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute Student student) {
        students.add(student);

        students.forEach(System.out::println);

        return "Student add, name " + student.getFirstName();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "JavaScript", "Python", "Bash", "C++");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Bike", "Basketball", "Ladys", "Fotball", "Skating");
    }
}
