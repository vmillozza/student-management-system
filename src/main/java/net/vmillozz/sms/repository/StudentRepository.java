package net.vmillozz.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.vmillozz.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
