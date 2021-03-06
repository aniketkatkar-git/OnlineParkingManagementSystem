package com.fi.springboot.onlineparkingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fi.springboot.onlineparkingsystem.entity.Manager;
import com.fi.springboot.onlineparkingsystem.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService
{

	@Autowired
	ManagerRepository managerRepository; 

	@Override
	public List<Manager> getAllManagers() 
	{
		return managerRepository.findAll();
	}

	@Override
	public Manager getManagerById(long id) 
	{
		return managerRepository.findById(id).get();
	}

	@Override
	public int login(String userName, String password) 
	{
		List<Manager> manager= managerRepository.validation(userName, password);

		if(manager.isEmpty())
			return 0;			
		else
			return 1;			
	}

	@Override
	public Manager registerManager(Manager manager) 
	{
		return managerRepository.save(manager);
	}

	@Override
	public ResponseEntity<Manager>updateManager(long id,Manager managerDetails)
	{
		Manager manager=managerRepository.findById(id).get();

		manager.setUsername(managerDetails.getUsername());
		manager.setPassword(managerDetails.getPassword());
		manager.setEmail(managerDetails.getEmail());
		manager.setContact_no(managerDetails.getContact_no());

		final Manager updateManager=managerRepository.save(manager);
		return ResponseEntity.ok(updateManager);
	}

	@Override
	public String deleteManager(long id) 
	{
		Optional<Manager> manager=managerRepository.findById(id);
		if(manager.isPresent())
		{
			managerRepository.delete(manager.get());
			return " Manager is deleted ";
		}
		else
		{
			throw new RuntimeException("Manager not found for the id : "+ id);
		}
	}
}