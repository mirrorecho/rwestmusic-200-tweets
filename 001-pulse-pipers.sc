(

// THE TWEET:
{|i|g=2*f=(i**1.5*12);l=LFPulse;play{y=kr(XLine,1e-4,8,f/2);ar(FreeVerb,ar(CombC,ar(Formant,ar(l,1)*f+f+(ar(l,y/i)*f+g)+(ar(l,y)*f)+(ar(l,1/y)*g)+(ar(l,y*2)*g),y*400,y*f,(8-y)/29)),i/9,i/9)!2}}!9 // #SuperCollider

)






// HUMAN-READABLE VERSION WITH COMMENTS:


(
s.record("recordings/001-pulse-me.wav".resolveRelative, numChannels:2);

// 8 overalapping repetitions:
(1..8).do { |i|

	// f and g increase with each repetiition, used to control frequency
	f = i**1.5*12;
	g = f*2;

	play{

		// y increases over time, and timeframe is longer with each repetition;
		// used to control frequency, timbre, and fade out
		y = XLine.kr(1e-4, 8, f/2);

		// reverb to make it sound pretty
		FreeVerb.ar(

			// delay to make it fancy
			CombC.ar(

				// Formant UGen for interesting timbre
				Formant.ar(

					// overlapping LFPulse UGens control the Formant Ugen's frequency based on various
					// combinations of f,g, and y ... creates interesting melodic line that gets higher
					// and faster over time
					fundfreq:
					( LFPulse.ar(1) * f + f) +
					( LFPulse.ar(y/9) * f + g ) +
					( LFPulse.ar(y) * f ) +
					( LFPulse.ar(1/y) * g) +
					( LFPulse.ar(y*2) * g ),

					// Formant UGen's formfreq and bwfreq arguments set based on y, so that timbre changes over time
					formfreq: y*400,
					bwfreq: y*f,

					// fade out over time
					mul:(8-y)/29

				)

		), mix:i/9, room:i/9 // more reverb with each repetition

		)!2 // 2 channels

	}
}

)

s.stopRecording;
