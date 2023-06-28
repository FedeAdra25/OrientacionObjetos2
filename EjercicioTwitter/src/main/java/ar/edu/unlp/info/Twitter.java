package ar.edu.unlp.info;

import ar.edu.unlp.info.exceptions.*;
import ar.edu.unlp.info.tweet.Tweet;
import ar.edu.unlp.info.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Twitter {
    private HashMap<String,User> users=new HashMap<>();
    private ArrayList<Tweet> tweets=new ArrayList<>();

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
    }


    public Twitter() {
        try{
            this.createUserFromScreenName("Pablo");
            User juan = new User("Juan");
            this.createUserFromScreenName("Eduardo");
            User pepe = new User("pepe");
            Tweet pepeTweet = pepe.tweet("Hoy es un dia soleado");
            Tweet juanTweet = pepe.tweet("Juan me cae re bienn");
            juan.reTweet(pepeTweet);
            juan.reTweet(juanTweet);
            this.createUser(juan);
            this.createUser(pepe);
        }
        catch (UserScreenNameAlreadyExistsException | UserNullOnCreationException e) {
            throw new RuntimeException(e);
        } catch (TweetExceedsCharacterLimitException e) {
            throw new RuntimeException(e);
        } catch (QuotedTweetIsDeletedException e) {
            throw new RuntimeException(e);
        } catch (CannotQuoteQuotedTweetException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUserFromScreenName(String screenName) throws UserScreenNameAlreadyExistsException, UserNullOnCreationException {
        this.createUser(new User(screenName));
    }
    public void createUser(User user) throws UserNullOnCreationException, UserScreenNameAlreadyExistsException {
        this.validateUserName(user);
        if(users.containsKey(user.getScreenName())){
            throw new UserScreenNameAlreadyExistsException();
        }
        users.put(user.getScreenName(),user);
    }

    public void deleteUser(String screenName) throws NoSuchUserException {
        if(screenName==null){
            return;
        }
        User user = users.get(screenName);
        if(user==null){
            throw new NoSuchUserException();
        }
        tweets.removeAll(user.getTweets());
        users.remove(user);
    }
    public void deleteUser(User user){
        if(user==null){
            return;
        }
        tweets.removeAll(user.getTweets());
        users.remove(user);
    }
    private void validateUserName(User user) throws UserNullOnCreationException {
        if(user==null || user.getScreenName()==null){
            throw new UserNullOnCreationException();
        }
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
