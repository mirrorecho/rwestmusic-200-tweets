# rwestmusic-200-tweets

200 Character Pieces
====================
For Twitter and SuperCollider
--------------------

Computer music scores as twitter posts?!

As a composer and programmer, I love to work in SuperCollider, a programming language and platform for audio synthesis and algorithmic composition. 

Once upon a time, an active compositional project lived at sc140tweets. Composers tweeted mini pieces such that the entire work was contained in the tweet. The tweets housed fascinating nuggets of algorithmic computer music code, written in the SuperCollider language, all no more than 140 characters long (including the @sc140tweets mention).

Since those bygone days, the tweet limit ballooned to 280 characters and the project lost its cachet. But I learned from it and miss it. I still return to the twitter page for ideas and inspiration. 

So I decided to write a series of pieces in the same spirit. The series contains works of computer code, each 200 characters or less (so I can tweet them with 80 characters left for the #SuperCollider hashtag, a link to SoundCloud, and another hashtag or two).


*What can one express musically in 200 characters?*

Enforcing such an arbitrary and rigorous constraint can be both maddening and enlightening. It’s certainly a technical challenge. But I think it’s also a creative one: every dot and comma is a tradeoff and critical artistic decision. A decision to add a new sound could determine whether the piece has an ending or not!

And one new hurdle to mention since the days of earlier tweets: it appears that twitter has changed its URL shortener algorithm such that a perfectly happy line of SuperCollider code like:

**play{ PinkNoise.ar(0.6!2) }**

… is believed by the twitter machines to include a link to an Argentinian website. It must be re-written as:

**play{ ar(PinkNoise, 0.6!2) }**

Although the difference is slight, the second example is unidiomatic for most of us who write SuperCollider code. Many of the grand old SuperCollider tweets from pre-2017 would be impossible to tweet today! 

(BTW, have the SuperCollider maintainers considered buying up domains in Argentina and Korea to host documentation such as SinOsc.ar? or EnvGen.kr?)

In any case, I forged ahead, and am happy to begin sharing these works with you.

As I post works in the series I will include the terse twitter-length code along with a longer explanatory version, with notes on how the piece is constructed.

The code, the resulting sound pieces, and this text are open source / licensed under Creative Commons. Use and share! (with attribution).

Enjoy!


This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License.
