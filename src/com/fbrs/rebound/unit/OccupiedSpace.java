package com.fbrs.rebound.unit;

import com.fbrs.rebound.player.FactionType;
import com.fbrs.rebound.player.Player;

public abstract class OccupiedSpace {
	
	public abstract byte HP();
	public abstract byte atk();
	public abstract byte def();
	
	public abstract void Render();
	
	public abstract FactionType getFaction();
	
	public abstract boolean isUnit();
	
	public abstract Player getPlayer();
	
	public abstract void resetUnit();

}
