package com.fbrs.rebound.player;

import java.util.HashMap;
import java.util.Iterator;

import com.fbrs.rebound.ai.Coordinator;
import com.fbrs.rebound.unit.OccupiedSpace;

public class Player {
	
	public int supply;
	
	public byte defMod;
	public byte atkMod;
	
	public HashMap<String, OccupiedSpace> Owned;
	
	
	public FactionType Faction;
	
	private boolean locked;
	
	public Coordinator c;
	
	//Player Lock Methods
	public void Lock()
	{
		locked = true;
	}
	
	public void Unlock()
	{
		locked = false;
		Iterator<OccupiedSpace> iter = Owned.values().iterator();
		while(iter.hasNext())
		{
			iter.next().resetUnit();
		}
		c.go();
	}
	
	public boolean isLocked()
	{
		return locked;
	}
	
	
	public Player()
	{
		supply = 0;
		Owned = new HashMap<String, OccupiedSpace>();
		Faction = new Banes();
		 c = new Coordinator(this);
	}

}
