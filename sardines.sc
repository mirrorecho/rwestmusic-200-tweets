(
SynthDef(\smoothGhosts, {
	arg moveHz=4, loFreq=440, hiFreq=440, gate=1, amp=1.0;
	var freq, sig, sig2, env, ghostCount=1;
	freq = LFNoise2.kr(moveHz!ghostCount).exprange(loFreq, hiFreq);
	amp = LFNoise2.kr(moveHz!ghostCount).exprange(0.01, amp*0.6);
	//amp = amp / (ghostCount/2);
	// sig = SinOsc.ar(freq) * amp;
	sig = Resonz.ar(Crackle.ar(1.98!2), freq, 0.001, 88) +
	Resonz.ar(WhiteNoise.ar(0.6!2), freq * 2, 0.001, 60) +
	Resonz.ar(WhiteNoise.ar(0.2!2), 300, 0.001, 12) +
	Resonz.ar(WhiteNoise.ar(0.1!2), 870, 0.001, 9) +
	Resonz.ar(WhiteNoise.ar(0.04!2), 2250, 0.001, 4)
	* amp;
	sig2 = Splay.ar(sig, spread:0.9);
	sig2 = FreeVerb2.ar(sig2[0], sig2[1], mix:0.4);
	env = EnvGen.kr(Env.asr(attackTime:6.0, releaseTime:12.0), gate:gate, doneAction:2);
	sig2 = sig2 * env;
	Out.ar(0, sig2);
}).add;


SynthDef(\oranges, {
	arg freq=440, gate=1, amp=1.0;
	var sig, env;
	sig = CombN.ar(
		Splay.ar(
			DynKlank.ar(`[3/2**(4..0)*freq,
				{ |b|
					SinOsc.ar(b/2+1/444)/(4-b)/6
				}!4.abs, 1
			],
			PinkNoise.ar/29 + Dust2.ar(2!2)),
			0.4
		)
	) * amp;
	sig = FreeVerb2.ar(sig[0], sig[1]);
	env = EnvGen.kr(Env.asr(attackTime:6.0, releaseTime:14.0), gate:gate, doneAction:2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
)


a.set(\gate, 0);

s.record("".resolveRelative ++ "sardines.aiff", numChannels:2)
s.stopRecording;

(
fork {
	var o1a, o1b, o2, o3a, o3b, o4a, o4b, g1a, g1b, g1c, g2, g3, g4;
	2.wait;

/*	g1a = Synth.new(\smoothGhosts, [
	\moveHz, 0.5,
	\amp, 0.2,
	\loFreq, 440,
	\hiFreq, 440*3.0]);*/

	g1a = Synth.new(\smoothGhosts, [
	\moveHz, 2.0,
	\amp, 0.6,
	\loFreq, 440,
	\hiFreq, 440*1.05]);
	6.wait;
	g1b = Synth.new(\smoothGhosts, [
	\moveHz, 4.0,
	\amp, 0.6,
	\loFreq, 440*10/9,
	\hiFreq, 440*1.05 *10/9]);


	3.wait;
	o1a = Synth.new(\oranges, [
		\freq, 440,
		\amp, 0.3,
	]);
	20.wait;
	g1c = Synth.new(\smoothGhosts, [
	\moveHz, 8,
	\amp, 0.8,
	\loFreq, 220,
	\hiFreq, 220*1.1]);



	// ---------------------------------------------------------
	//0:38

	9.wait;
	o2 = Synth.new(\oranges, [
		\freq, 220,
		\amp, 0.6,
	]);


	g2 = Synth.new(\smoothGhosts, [
	\moveHz, 1.0,
	\amp, 0.4,
	\loFreq, 440,
	\hiFreq, 440*1.5]);

/*	o1b = Synth.new(\oranges, [
		\freq, 110 * 10/9,
		\amp, 0.4,
	]);*/

	//0:44
	6.wait;
	g1a.set(\moveHz, 8);
	// o1a.set(\gate, 0);

	// ---------------------------------------------------------
	//1:06
	24.wait;
	o2.set(\gate, 0);
	g3 = Synth.new(\smoothGhosts, [
	\moveHz, 1.0,
	\amp, 0.4,
	\loFreq, 880,
	\hiFreq, 880*1.5]);

	//1:10
	4.wait;
	o3a = Synth.new(\oranges, [
		\freq, 440*10/9,
	]);
	//1:16
	6.wait;
	g3.set(\gate, 0);
	o3b = Synth.new(\oranges, [
		\amp, 0.4,
		\freq, 1760,
	]);

	// ---------------------------------------------------------
	//1:28
	12.wait;
	g2.set(\gate, 0);
	o4a = Synth.new(\oranges, [
		\freq, 110,
	]);
	o1a.set(\gate, 0);

	//1:33
	4.wait;
	o4b = Synth.new(\oranges, [
		\freq, 880,
	]);

	g1a.set(\gate, 0);
	g1b.set(\gate, 0);
	g1b.set(\gate, 0);
	4.wait;
	o3b.set(\gate, 0);
	4.wait;
	o3a.set(\gate, 0);
	4.wait;
	o4b.set(\gate, 0);
	4.wait;
	o4b.set(\gate, 0);

}
)


