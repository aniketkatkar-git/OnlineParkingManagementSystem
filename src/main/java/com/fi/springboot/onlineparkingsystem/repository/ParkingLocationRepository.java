package com.fi.springboot.onlineparkingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.fi.springboot.onlineparkingsystem.entity.ParkingLocation;

@Repository
@EnableJpaRepositories
public interface ParkingLocationRepository extends JpaRepository<ParkingLocation, Long>
{
	List<ParkingLocation> findByAreaId(long area_id);
}