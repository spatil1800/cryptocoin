package com.cryptocoin.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cryptocoin.beans.FavoritesCoins;
import com.cryptocoin.beans.FavoritesCoinsId;
import com.cryptocoin.dao.FavoritesCoinsDao;

@Repository
@Transactional
public class FavoritesCoinsDaoImpl implements FavoritesCoinsDao {

	private static final Log log = LogFactory.getLog(FavoritesCoinsDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public void persist(FavoritesCoins transientInstance) {
		log.debug("persisting FavoritesCoins instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(FavoritesCoins persistentInstance) {
		log.debug("removing FavoritesCoins instance");
		try {
			sessionFactory.getCurrentSession().remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public void update(FavoritesCoins detachedInstance) {
		log.debug("merging FavoritesCoins instance");
		try {
			sessionFactory.getCurrentSession().update(detachedInstance);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FavoritesCoins findById(FavoritesCoinsId id) {
		log.debug("getting FavoritesCoins instance with id: " + id);
		try {
			FavoritesCoins instance = sessionFactory.
					getCurrentSession().get(FavoritesCoins.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

}
