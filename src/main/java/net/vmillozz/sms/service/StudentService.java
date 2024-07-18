package net.vmillozz.sms.service;

import net.vmillozz.sms.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Student addCourseToStudent(Long studentId, Long courseId);
}
