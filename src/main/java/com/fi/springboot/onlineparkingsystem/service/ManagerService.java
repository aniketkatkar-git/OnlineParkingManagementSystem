package com.fi.springboot.onlineparkingsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fi.springboot.onlineparkingsystem.entity.Manager;

@Service
public interface ManagerService
{
	List<Manager> getAllManagers();
	Manager getManagerById(long id);
	int login(String userName,String password);
	public Manager registerManager(Manager manager);
	public ResponseEntity<Manager> updateManager(long id,Manager managerDetails);
	public String deleteManager(long id);
}