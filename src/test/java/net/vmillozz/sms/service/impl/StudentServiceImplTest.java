package net.vmillozz.sms.service.impl;

import net.vmillozz.sms.entity.Student;
import net.vmillozz.sms.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        // Given
        Student student1 = new Student("John", "Doe", "john.doe@example.com");
        Student student2 = new Student("Jane", "Smith", "jane.smith@example.com");
        List<Student> expectedStudents = Arrays.asList(student1, student2);

        // When
        when(studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(expectedStudents);

        // Then
        List<Student> actualStudents = studentService.getAllStudents();
        assertEquals(expectedStudents, actualStudents);
    }
}
