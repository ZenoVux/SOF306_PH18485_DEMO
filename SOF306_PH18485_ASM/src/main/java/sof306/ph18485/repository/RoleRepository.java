package sof306.ph18485.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
