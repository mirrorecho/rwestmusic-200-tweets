(

// THE TWEET:


c=Crackle;n=(1..64);play{Splay.ar(n.scramble.collect({|i|Ringz.ar(LFPulse.ar(n.choose,0,0.1*i)+c.ar(2,a=0.2)*(c.ar(2,a)+a)*LFSaw.ar(n.choose/(i+2*22)),99*i,a,a)*kr(linen(Env,i,66,n.choose))}),0.7)}



// #SuperCollider https://soundcloud.com/randall-west/poly-bounce-supercollider-twitter-002
)




(
// HUMAN-READABLE VERSION WITH COMMENTS:
c=Crackle;n=(1..64);play{Splay.ar(n.scramble.collect({|i|Ringz.ar(LFPulse.ar(n.choose,0,0.1*i)+c.ar(2,a=0.2)*(c.ar(2,a)+a)*LFSaw.ar(n.choose/(i+2*22)),99*i,a,a)*kr(linen(Env,i,66,n.choose))}),0.7)}

)

