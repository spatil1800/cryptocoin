package com.cryptocoin.dao;

import java.util.Set;

import com.cryptocoin.beans.Users;
import com.cryptocoin.beans.UsersRoles;

public interface UserRolesDao {

	public void persist(Set<UsersRoles> roles);
}
