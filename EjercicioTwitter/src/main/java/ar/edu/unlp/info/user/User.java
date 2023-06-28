package ar.edu.unlp.info.user;

import ar.edu.unlp.info.exceptions.CannotQuoteQuotedTweetException;
import ar.edu.unlp.info.exceptions.QuotedTweetIsDeletedException;
import ar.edu.unlp.info.exceptions.TweetExceedsCharacterLimitException;
import ar.edu.unlp.info.tweet.QuotedRetweet;
import ar.edu.unlp.info.tweet.Tweet;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Tweet> tweets = new ArrayList<>();
    private String screenName;

    public User(String screenName) {
        this.screenName = screenName;
    }

    public Tweet tweet(String tweetText) throws TweetExceedsCharacterLimitException {
        Tweet tweet = new Tweet(tweetText,this);
        tweets.add(tweet);
        return tweet;
    }

    public Tweet reTweet(Tweet tweet) throws QuotedTweetIsDeletedException, TweetExceedsCharacterLimitException, CannotQuoteQuotedTweetException {
        if(tweet.getQuotedRetweetList()==null){
            throw new CannotQuoteQuotedTweetException("Cannot quote quoted tweet!!");
        }
        return new QuotedRetweet(tweet,this);
    }

    public List<Tweet> deleteUser(){
        this.deleteUserTweets();
        return tweets;
    }

    public String getScreenName() {
        return screenName;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    private void deleteUserTweets(){
        tweets.forEach(tweet -> tweet.delete());
    }

}
