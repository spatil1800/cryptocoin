package com.cryptocoin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cryptocoin.beans.Users;

@Controller
public class DashBoardController {

	 @RequestMapping(method = RequestMethod.GET,value="dashboard")
	    public ModelAndView loadDashBoard(HttpSession session) {
	        ModelAndView mav = new ModelAndView("dashboard");
	        mav.addObject("title","DashBoard");
	        mav.addObject("clicksHomepage", true);
	        //System.out.println(((Users)session.getAttribute("principal")).getFavoritesCoinses().get(0).getId().getCoinId());
	        return mav;
	    }
	 
	
	 
	 @RequestMapping(method = RequestMethod.GET,value="/search")
	    public ModelAndView loadSearchCoin() {
	        ModelAndView mav = new ModelAndView("dashboard");
	        mav.addObject("title","Search Coin");
	        mav.addObject("clicksSearchCoin", true);
	        return mav;
	    }
}
