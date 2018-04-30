package com.cryptocoin.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cryptocoin.beans.Users;
import com.cryptocoin.beans.UsersRoles;
import com.cryptocoin.dao.UserRolesDao;
import com.cryptocoin.dao.UsersDao;

@Controller
public class GlobalController {

	@Autowired
	UsersDao usersDao;
	
	@Autowired
	UserRolesDao userRolesDao;

	@RequestMapping("/")
	public String loadIndexPage(Model model,HttpSession session) {

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			if(session.getAttribute("principal") == null){
			session.setAttribute("principal", usersDao.
					findByUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
			}
			model.addAttribute("principal", session.getAttribute("principal"));
			model.addAttribute("title", "DashBoard");
			model.addAttribute("clicksHomepage", true);
			return "dashboard";
		} else {

			model.addAttribute("title", "Home");
			model.addAttribute("isIndex", true);
			return "index";
		}
	}

	@RequestMapping("/signup")
	public ModelAndView loadSignupPage() {

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			ModelAndView model=new ModelAndView("redirect:/");
			return model;
		} else {
			ModelAndView model=new ModelAndView("index");
			model.addObject(new Users());
			model.addObject("title", "SignUp");
			model.addObject("isSignup", true);
			return model;
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "success", required = false) String success,
			@RequestParam(value = "logout", required = false) String logout) {

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			ModelAndView mav = new ModelAndView();
			ModelAndView model=new ModelAndView("redirect:/");
			return model;
		} else {
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}
			if (success != null) {
				model.addObject("msg", "Sign Up Succesful.Please LogIn to Continue.");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("index");
			model.addObject("title", "LogIn");
			model.addObject("isLogin", true);
			model.addObject(new Users());
			return model;
		}
	}


	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView doSignupPage(@Valid Users user, Errors errors) {

		ModelAndView model=new ModelAndView();
		if (errors.hasErrors()) {
			model.addObject("title", "SignUp");
			model.addObject("isSignup", true);
			model.setViewName("index");
			return model;
		}
		Set<UsersRoles> roles = new HashSet<>();
		roles.add(new UsersRoles(user, "USER"));
		user.setUsersRoleses(roles);
		user.setPassHash(user.getPassword());
		usersDao.persist(user);
		userRolesDao.persist(roles);
		model.setViewName("redirect: login?success");
		
		return model;
	}

	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}