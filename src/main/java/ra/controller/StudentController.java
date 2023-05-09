package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/create")
    public String create(@RequestParam String name,@RequestParam int age, @RequestParam boolean sex,@RequestParam String address, Model model) {
       Student newStudent = new Student(0,name,age,sex,address);

       studentServiceImp.save(newStudent);
        return getAll(model);
    }
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        Student editStudent = studentServiceImp.findById(id);
        System.out.println(editStudent.isSex());
        model.addAttribute("student",editStudent);
        return "editStudent";
    }
    @PostMapping("/update")
    public String update(@RequestParam int id,@RequestParam String name, @RequestParam int age,@RequestParam boolean sex,@RequestParam String address, Model model){
        Student updateStudent =new Student(id, name, age,sex,address);
        studentServiceImp.update(updateStudent);
        return getAll(model);
    }
}
