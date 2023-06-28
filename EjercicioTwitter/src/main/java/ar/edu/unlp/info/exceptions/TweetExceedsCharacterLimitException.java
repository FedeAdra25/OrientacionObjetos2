package ar.edu.unlp.info.exceptions;

public class TweetExceedsCharacterLimitException extends Throwable {

    public TweetExceedsCharacterLimitException(String msg) {
        super(msg);
    }
}
