package com.cryptocoin.dao.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cryptocoin.beans.Users;
import com.cryptocoin.dao.UsersDao;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

	private static final Log log = LogFactory.getLog(UsersDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public void persist(Users transientInstance) {
		log.debug("persisting Users instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Users persistentInstance) {
		log.debug("removing Users instance");
		try {
			sessionFactory.getCurrentSession().remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public void update(Users detachedInstance) {
		log.debug("updating Users instance");
		try {
			sessionFactory.getCurrentSession().update(detachedInstance);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public Users findById(Integer id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = sessionFactory.getCurrentSession().get(Users.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Users findByUserByEmail(String username) {
		log.debug("getting Users instance with email: " + username);
		try {
			Users instance = (Users) sessionFactory.getCurrentSession()
					.createQuery("From com.cryptocoin.beans.Users where email=:email")
					.setParameter("email",username).uniqueResult();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
