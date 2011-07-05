package com.fbrs.rebound.player;

public class Banes extends FactionType{
	
	@Override
	public float getAtk(float hp_percent)
	{
		if(hp_percent != 1)
			return (float) 0.5;
		return 1;
	}

}
