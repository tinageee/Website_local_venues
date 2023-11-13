package com.saiyingge.localVenue.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);

    @Query(value = "select * from role where role.id=(select role_id from user_roles where user_id = :id)", nativeQuery = true)
    public List<Role> findRoleByUserId (int id);
}

