package com.fbrs.rebound.player;

import java.util.ArrayList;

import com.fbrs.rebound.unit.OccupiedSpace;

public class Player {
	
	public int supply;
	
	public byte defMod;
	public byte atkMod;
	
	public ArrayList<OccupiedSpace> Owned;
	
	public FactionType Faction;
	
	private boolean locked;
	
	public void Lock()
	{
		locked = true;
	}
	
	public void Unlock()
	{
		locked = false;
	}
	
	public boolean isLocked()
	{
		return locked;
	}
	
	public Player()
	{
		supply = 0;
		Owned = new ArrayList<OccupiedSpace>();
		Faction = new Banes();
	}

}
