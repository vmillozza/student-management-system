package net.vmillozz.sms.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import net.vmillozz.sms.entity.Course;
import net.vmillozz.sms.entity.Student;
import net.vmillozz.sms.repository.CourseRepository;
import net.vmillozz.sms.repository.StudentRepository;
import net.vmillozz.sms.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (student != null && course != null) {
            student.getCourses().add(course);
            studentRepository.save(student);
        }
        return student;
    }
}
