package penchit.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import penchit.model.CourseGroup;

public interface CourseGroupRepository extends CrudRepository<CourseGroup, Integer> {
	
	List<CourseGroup> findByName(String groupName);
	
	
}
