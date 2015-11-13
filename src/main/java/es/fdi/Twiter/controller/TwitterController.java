package es.fdi.Twiter.controller;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import es.fdi.Twiter.entity.*;
import es.fdi.Twiter.service.*;

@Controller
public class TwitterController {
	
	@Autowired
	private TweetService tweets;
	
	@Autowired
	private UserService usuarios;
	
	public TwitterController() {
		super();
	}

	@ModelAttribute("usuarioLogin")
	public Usuario dameUsuario(){
		return this.usuarios.dameUsuarioLogueado();
	}
	
	@ModelAttribute("dameTweets")
	public List<Tweet> dameTweets(){
		return this.tweets.getLista();
	}
	
	@RequestMapping(value={"/","/welcome"})
    public String showTweets(Tweet t) {
        return "welcome";
    }
	
	@RequestMapping(value="/welcome", method = RequestMethod.POST)
	public ModelAndView publicaTweet(Tweet t){
		
		ModelAndView model = new ModelAndView("welcome");
		Usuario user = usuarios.dameUsuarioLogueado();
		t.setFecha(Calendar.getInstance().getTime());
		t.setUsuario(user);
		this.tweets.anyadeTweet(t);
		
		model.addObject("userlogin",user);
		model.addObject("dameTweets", tweets.getLista());
		
		return model;
	}

	
}
