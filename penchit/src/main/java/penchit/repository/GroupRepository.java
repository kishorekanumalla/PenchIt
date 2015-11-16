package penchit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import penchit.model.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {
	
	List<Group> findByName(String groupName);
	
	
}
