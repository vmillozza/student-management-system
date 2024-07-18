package net.vmillozz.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.vmillozz.sms.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
