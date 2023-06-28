# Ejercicio de Twitter

## Consigna

[UML](/png/VL3HIiGm47pFLuHxkdhq1uB8-Iw2Udv0R8OZa4inkws2-EzkbbXh7ouFosOcEpkP8x4lF5sIaJCaJsHF7m3RBsDxnYUx5ound-KMwNxWECEzZME2pmAzJoCZF8Fho4CaThNSgiATyBDFCNY60llEs4D00aFRC_XfEo_4zw-FLqAfBcWeG7xq5onU3go2MXlOELqYNC5fnMg_a6r_bTvt6xD_b4AqzlBFg9LOa4DBIYnU-qlLipTzts9rTgSFQ6VCKKGa-Hy0)
```javadoc
@startuml

class Tweet {
-text:String
-isActive:boolean
-quotedRetweetList:List<Tweet>
-validateTweet()
+delete()
+getQuotedRetweetList()
}

class User{
-screenName:String
+tweet(tweet:String):Tweet
+reTweet(tweet:Tweet):Tweet
+deleteUser():List<Tweet>
-deleteUserTweets()
}

class QuotedRetweet extends Tweet{
+getQuotedRetweetList()
}

User *-- Tweet : "tweets"

@enduml
```
