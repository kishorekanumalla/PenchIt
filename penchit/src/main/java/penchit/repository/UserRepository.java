package penchit.repository;

import org.springframework.data.repository.CrudRepository;
import penchit.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
