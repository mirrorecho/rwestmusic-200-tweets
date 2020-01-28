(

// THE TWEET:

play{ar(FreeVerb2,*(ar(Splay,{|i|ar(Formlet,ar(Impulse,r=i+1/6),f=ar(LFSaw,r/(i+4*4),1)+2*2**5,kr(XLine,1e-7,1,99),1/r)*kr(AmpComp,f)}!12,0.4)*kr(linen(Env,2,88,9)))++[kr(Env([1,1,0.1],[9,99])),0.1])}



// #SuperCollider https://soundcloud.com/randall-west/poly-bounce-supercollider-twitter-002
)


(
// HUMAN-READABLE VERSION WITH COMMENTS:
play{

	// reverb to make it sound pretty
	FreeVerb2.ar(

		// spread the inputs across the stereo field
		*(Splay.ar(

			// the inputs...
			{|i|

				// resonant filter
				Formlet.ar(

					// impulses:
					r = i+1/6; // the impulse rate (varying rates create the polyrhythm)
					Impulse.ar(r),

					// the freq for the resonant filter (Formlet)...
					// LFSaw creates freqs that start low and get higher
					// creates variety based on impulse rate and iteration
					// (and scales exponentially to a meaningful freq value)
					f=LFSaw.ar(r/(i+4*4),1)+2*2**5,

					// the attack time
					// Env([1e-5,0.01],[180]).kr,
					XLine.kr(1e-7,1,99),

					// the decay time (inversely proportional to impulse rate)
					1/r
				)

				// amplitude compensation (higher frequencies softer)
				* AmpComp.kr(f)

			}!12, // 18 overlapping iterations (inputs)!

			// Splay's stereo field spread
			0.4

		)

		// envelope to fade in/out at start/end
		* Env.linen(2,88,9).kr

		// reverb mic, room, and damp
		// (snare-like effect at first)
		) ++ [Env([1,1,0.1],[9,99]).kr, 0.1],
	)
}

)

