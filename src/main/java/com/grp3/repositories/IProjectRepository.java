package com.grp3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp3.models.Project;

/**
 ********************************************************************
 * Repository / DAO for the Project domain model
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
}
