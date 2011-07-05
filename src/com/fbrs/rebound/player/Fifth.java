package com.fbrs.rebound.player;

public class Fifth extends FactionType{
	
	public float getAtk(float hp_percent)
	{
		if(hp_percent > .75)
			return 1;
		else if(hp_percent > .50)
			return (float) 0.75;
		else if(hp_percent > .25)
			return (float) 0.50;
		else
			return (float) 0;
	}

}
