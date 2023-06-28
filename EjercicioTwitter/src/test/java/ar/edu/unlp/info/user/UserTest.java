package ar.edu.unlp.info.user;

import ar.edu.unlp.info.exceptions.CannotQuoteQuotedTweetException;
import ar.edu.unlp.info.exceptions.QuotedTweetIsDeletedException;
import ar.edu.unlp.info.exceptions.TweetExceedsCharacterLimitException;
import ar.edu.unlp.info.tweet.Tweet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private final String PEPE = "Pepe";
    private final String JUAN = "Juan";
    private final String NORMAL_TWEET="Hola mundo";
    private final String LONG_TWEET="Lorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarmLorem ipsum dolorem itsum lalarm";
    @Test
    void tweetTest() throws TweetExceedsCharacterLimitException {
        User user = new User(PEPE);
        Tweet tweet = user.tweet(NORMAL_TWEET);
        assertEquals(tweet.getText(),NORMAL_TWEET);
        assertTrue(tweet.isActive());

    }

    @Test
    void longTweetTest() {
        User user = new User(PEPE);
        assertThrows(TweetExceedsCharacterLimitException.class,()->user.tweet(LONG_TWEET));
        assertTrue(user.getTweets().stream().map(Tweet::getText).noneMatch(s -> s.equals(LONG_TWEET)));

    }
    @Test
    void noTweetTest() {
        User user = new User(PEPE);
        assertThrows(TweetExceedsCharacterLimitException.class,()->user.tweet(""));
        assertTrue(user.getTweets().stream().map(Tweet::getText).noneMatch(s -> s.equals(LONG_TWEET)));

    }

    @Test
    void reTweetTest() throws TweetExceedsCharacterLimitException, CannotQuoteQuotedTweetException, QuotedTweetIsDeletedException {
        User user = new User(PEPE);
        User user2 = new User(JUAN);
        Tweet tweet1 = user.tweet(NORMAL_TWEET);
        Tweet reTweet1 = user2.reTweet(tweet1);
        assertNull(reTweet1.getQuotedRetweetList());
        assertNotNull(tweet1.getQuotedRetweetList());
        assertEquals(reTweet1.getText(),NORMAL_TWEET);
    }

    @Test
    void reTweetQuotedExceptionTest() throws TweetExceedsCharacterLimitException, CannotQuoteQuotedTweetException, QuotedTweetIsDeletedException {
        User user = new User(PEPE);
        User user2 = new User(JUAN);
        Tweet tweet1 = user.tweet(NORMAL_TWEET);
        Tweet reTweet1 = user2.reTweet(tweet1);
        assertThrows(CannotQuoteQuotedTweetException.class,()->user.reTweet(reTweet1));
    }

    @Test
    void deleteUserTest() throws TweetExceedsCharacterLimitException, CannotQuoteQuotedTweetException, QuotedTweetIsDeletedException {
        User user = new User(PEPE);
        User user2 = new User(JUAN);
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(user.tweet(NORMAL_TWEET));
        tweets.add(user.tweet(NORMAL_TWEET));
        tweets.add(user.tweet(NORMAL_TWEET));
        Tweet juanReTweet = user2.reTweet(tweets.get(0));
        user.deleteUser();
        assertTrue(!tweets.stream().map(Tweet::isActive).reduce(Boolean.FALSE,Boolean::logicalOr));
        assertTrue(!juanReTweet.isActive());
    }
}