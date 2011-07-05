package com.fbrs.rebound.player;

public class Oni extends FactionType{

	@Override
	public float getAtk(float hp_percent) {
		if(hp_percent > 0.5)
			return 1;
		else
			return (float) 0.5;
	}

}
