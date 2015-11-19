package penchit.repository;

import org.springframework.data.repository.CrudRepository;

import penchit.model.ContactInfo;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, Integer>  {

}
