package net.vmillozz.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vmillozz.sms.entity.Course;
import net.vmillozz.sms.repository.CourseRepository;

@Service
public class CourseService {
    
    public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	private CourseRepository courseRepository;
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

