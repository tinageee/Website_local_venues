package com.saiyingge.localVenue.repository;

import com.saiyingge.localVenue.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Custom methods can be added here, for example:
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
