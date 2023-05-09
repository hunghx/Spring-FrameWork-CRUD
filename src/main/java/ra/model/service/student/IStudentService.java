package ra.model.service.student;

import ra.model.entity.Student;
import ra.model.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student,Integer> {
    List<Student> findByName(String name);
}
