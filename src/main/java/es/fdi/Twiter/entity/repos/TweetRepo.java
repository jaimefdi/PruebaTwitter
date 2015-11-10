package es.fdi.Twiter.entity.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fdi.Twiter.entity.Tweet;

@Repository
public class TweetRepo {
	
	private List<Tweet> listaTweet = new ArrayList<Tweet>();
	
	public TweetRepo(){
		super();
	}
	
	public List<Tweet> getLista(){
		return new ArrayList<Tweet>(listaTweet);
	}
	
	public void anyadeTweet(Tweet t){
		listaTweet.add(t);
	}

}
