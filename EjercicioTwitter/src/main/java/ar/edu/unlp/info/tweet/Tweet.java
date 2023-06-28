package ar.edu.unlp.info.tweet;

import ar.edu.unlp.info.exceptions.QuotedTweetIsDeletedException;
import ar.edu.unlp.info.exceptions.TweetExceedsCharacterLimitException;
import ar.edu.unlp.info.user.User;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    private List<Tweet> quotedRetweetList = new ArrayList<>();
    private User userCreator;
    private String text;
    private boolean isActive=true;

    public Tweet(Tweet tweet,User userCreator) throws QuotedTweetIsDeletedException, TweetExceedsCharacterLimitException {
        this(tweet.text,userCreator);
        if(!tweet.isActive)
            throw new QuotedTweetIsDeletedException("Quoting deleted tweet.");
        tweet.getQuotedRetweetList().add(this);
    }
    public Tweet(String text, User user) throws TweetExceedsCharacterLimitException {
        validateTweet(text);
        this.text = text;
        this.userCreator=user;
    }
    public void delete() {
        isActive=false; //Deshabilito tweet
        quotedRetweetList.forEach(Tweet::delete); //Deshabilito retweets de mi tweet
    }
    private void validateTweet(String tweetText) throws TweetExceedsCharacterLimitException {
        if(tweetText.length()<1 || tweetText.length()>280){
            throw new TweetExceedsCharacterLimitException("Character limit cannot be less than one or greater than 280");
        }
    }

    public User getUserCreator() {
        return userCreator;
    }

    public List<Tweet> getQuotedRetweetList() {
        return quotedRetweetList;
    }

    public String getText() {
        return text;
    }

    public boolean isActive() {
        return isActive;
    }
}