package com.cryptocoin.dao.impl;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cryptocoin.beans.UsersRoles;
import com.cryptocoin.dao.UserRolesDao;

@Repository
@Transactional
public class UserRolesDaoImpl implements UserRolesDao {

	private static final Log log = LogFactory.getLog(UserRolesDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void persist(Set<UsersRoles> roles) {
		log.debug("persisting Roles");
		try {
			for(UsersRoles role:roles)
			sessionFactory.getCurrentSession().save(role);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

}
