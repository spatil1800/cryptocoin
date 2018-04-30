package com.cryptocoin.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocoin.beans.FavoritesCoins;
import com.cryptocoin.beans.FavoritesCoinsId;
import com.cryptocoin.beans.Users;
import com.cryptocoin.dao.FavoritesCoinsDao;
import com.cryptocoin.dao.UsersDao;
import com.cryptocoin.dao.impl.UsersDaoImpl;

@RestController
public class CoinsRestController {

	@Autowired
	UsersDao usersDao;
	@Autowired
	FavoritesCoinsDao favoritesCoinDao;
	
	@RequestMapping("/coins/set-fav/{id}")
	public String setFavorites(@PathVariable String id){
		Users user=usersDao.findByUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		favoritesCoinDao.persist(new FavoritesCoins(new FavoritesCoinsId(id, user.getUserId()), user));
		System.out.println(id);
		return "Successful";
	}
	
	
	@RequestMapping("/coins/remove-fav/{id}")
	public String removeFavorites(@PathVariable String id){
		Users user=usersDao.findByUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		favoritesCoinDao.remove(favoritesCoinDao.findById(new FavoritesCoinsId(id, user.getUserId())));
		System.out.println(id);
		return "Successful";
	}

	@RequestMapping("/coins/get-fav")
	public List<String> getFavCoins(HttpSession session){
		
		if(session.getAttribute("principal") == null)
			return null;
		Users user=usersDao.findById(((Users)session.getAttribute("principal")).getUserId());
		 List<FavoritesCoins> coins=(user.getFavoritesCoinses());
		 System.out.println(coins);
		 List<String> coinId=new ArrayList<>();
		 for(FavoritesCoins fc:coins)
			 coinId.add(fc.getId().getCoinId());
		 if(coins != null)
		 return coinId;
		 else
			return null; 
	}
}
