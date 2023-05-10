package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Student;
import ra.model.service.student.StudentServiceImp;

import javax.servlet.http.HttpServletRequest;
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
    public String delete(@RequestParam int id){
        studentServiceImp.delete(id);
        return "redirect:GetAll";
    }
    @GetMapping("/add")
    public ModelAndView add(){
//        ModelAndView model = new ModelAndView("createStudent");
//        model.addObject("NewStudent",new Student());
        return new ModelAndView("createStudent","NewStudent",new Student());
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("NewStudent") Student stu, Model model) {
       studentServiceImp.save(stu);
        return "redirect:GetAll";
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int id) {
        Student editStudent = studentServiceImp.findById(id);
//        model.addAttribute("student",editStudent);
        ModelAndView mv = new ModelAndView("editStudent");
        mv.addObject("student",editStudent);
        return mv;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student stu, Model model){
        studentServiceImp.update(stu);
        return "redirect:GetAll";
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        Student student = new Student(1,"hùng",23,true,"Nghệ AN");
        request.getSession().setAttribute("name",student);
        return "home";
    }
}
