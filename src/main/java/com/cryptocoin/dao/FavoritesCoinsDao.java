package com.cryptocoin.dao;

import com.cryptocoin.beans.FavoritesCoins;
import com.cryptocoin.beans.FavoritesCoinsId;
import com.cryptocoin.beans.Users;

public interface FavoritesCoinsDao {

	public void persist(FavoritesCoins transientInstance);

	public void remove(FavoritesCoins transientInstance);
	public void update(FavoritesCoins transientInstance);
	public FavoritesCoins findById(FavoritesCoinsId id);

}
