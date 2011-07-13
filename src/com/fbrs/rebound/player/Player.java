package com.fbrs.rebound.player;

import java.util.HashMap;
import java.util.Iterator;

import com.fbrs.rebound.ai.Coordinator;
import com.fbrs.rebound.map.Map;
import com.fbrs.rebound.map.MapLoad;
import com.fbrs.rebound.unit.OccupiedSpace;
import com.fbrs.rebound.unit.Unit;
import com.fbrs.rebound.unit.UnitsLookup;
import com.fbrs.utils.math.LPoint;

public class Player {
	
	public int supply;
	
	public byte defMod = 0;
	public byte atkMod = 0;
	
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
		if(c!=null)
			c.go();
	}
	
	public boolean isLocked()
	{
		return locked;
	}
	
	public void SpawnNewUnit(String Type, LPoint loc)
	{
		Unit temp = UnitsLookup.Find(Type);
		Unit u = new Unit(temp.hp_max, temp.hp_max, temp.atk, temp.def, temp.supply, this , temp.type, loc);
		this.Owned.put("Type" + (Owned.size()+1), u);
		MapLoad.map.units.add(u);
	}
	
	
	public Player()
	{
		supply = 0;
		Owned = new HashMap<String, OccupiedSpace>();
		Faction = new Banes();
		 c = new Coordinator(this);
	}
	
	public Player(Coordinator coord)
	{
		supply = 0;
		Owned = new HashMap<String, OccupiedSpace>();
		Faction = new Banes();
		 c = coord;
	}

}
