package com.cryptocoin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cryptocoin.beans.Users;
import com.cryptocoin.beans.UsersRoles;
import com.cryptocoin.dao.UsersDao;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	// get user from the database, via Hibernate
	@Autowired
	private UsersDao userDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {

		System.out.println("UserName is- "+username);
		Users user = userDao.findByUserByEmail(username);
		if(user==null)
			System.out.println("User IS Null");
		System.out.println(user.getEmail());
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUsersRoleses());

		return  buildUserForAuthentication(user, authorities);

	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(Users user,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UsersRoles> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UsersRoles userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}