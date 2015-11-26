package penchit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import penchit.model.ClientsGallery;
import penchit.model.Course;

public interface ClientsGalleryRepository extends CrudRepository<ClientsGallery, Integer>  { 
	
	 List<ClientsGallery> findByType(String type);

}
