package com.grp3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp3.models.Pledge;

/**
 ********************************************************************
 * Repository / DAO for the Pledge domain model
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Repository
public interface IPledgeRepository extends JpaRepository<Pledge, Long> {

}
