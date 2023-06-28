package ar.edu.unlp.info.tweet;

import ar.edu.unlp.info.exceptions.QuotedTweetIsDeletedException;
import ar.edu.unlp.info.exceptions.TweetExceedsCharacterLimitException;
import ar.edu.unlp.info.user.User;

import java.util.List;

public class QuotedRetweet extends Tweet{
    public QuotedRetweet(Tweet tweet, User user) throws QuotedTweetIsDeletedException, TweetExceedsCharacterLimitException {
        super(tweet,user);
    }
    public List<Tweet> getQuotedRetweetList() {
        return null; //un qRT no puede ser retwiteado
    }
}
