package es.fdi.Twiter.controller;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value="/welcome", params={"publicar"})
	public String publicaTweet(@ModelAttribute("usuarioLogin") Usuario u, Tweet t,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return "welcome";
        }
		
		t.setFecha(Calendar.getInstance().getTime());
		t.setIdUsuario(u.getIdentificador());
		this.tweets.anyadeTweet(t);
		
		return "redirect:/welcome";
	}
	
}
