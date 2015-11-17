package penchit.repository;

import org.springframework.data.repository.CrudRepository;

import penchit.model.Course;

 public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	

}
