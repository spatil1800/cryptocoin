package com.cryptocoin.dao;

import com.cryptocoin.beans.Users;

public interface UsersDao {

	public void persist(Users transientInstance);

	public void remove(Users persistentInstance);
	public void update(Users detachedInstance);
	public Users findById(Integer id);
	public Users findByUserByEmail(String username);
	
}
