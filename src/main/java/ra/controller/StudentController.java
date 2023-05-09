package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.entity.Student;
import ra.model.service.student.StudentServiceImp;

import java.util.List;

@Controller
@RequestMapping("studentController")
public class StudentController {
    StudentServiceImp studentServiceImp = new StudentServiceImp();
    @GetMapping("/GetAll")
    public String getAll(Model model){
        List<Student>  list = studentServiceImp.findAll();
        model.addAttribute("list",list);
        return "students";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id,Model model){
        studentServiceImp.delete(id);
        return getAll(model);
    }
}
