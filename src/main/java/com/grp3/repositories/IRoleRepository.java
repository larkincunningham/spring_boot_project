package com.grp3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp3.models.Role;

/**
 ********************************************************************
 * Repository / DAO for the Role model
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
