package penchit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import penchit.model.Course;
import penchit.model.Group;

 public interface CourseRepository extends CrudRepository<Course, Integer> {
	 @Query(value = "SELECT c FROM Course c INNER JOIN c.groups groups WHERE groups.id = :groupId")
	 List<Course> findCoursesByGroupId(@Param("groupId") Integer groupId);
	 

}
