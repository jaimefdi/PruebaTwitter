package es.fdi.Twiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fdi.Twiter.entity.repos.TweetRepo;
import es.fdi.Twiter.entity.Tweet;

@Service
public class TweetService {

	@Autowired
	private TweetRepo tweetRepo;
	
	public TweetService(){
		super();
	}

	public List<Tweet> getLista() {
		return tweetRepo.getLista();
	}

	
	public void anyadeTweet(Tweet t){
		tweetRepo.anyadeTweet(t);
	}
}
