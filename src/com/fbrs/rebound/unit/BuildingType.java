package com.fbrs.rebound.unit;

import com.fbrs.rebound.map.MapLoad;

public class BuildingType {
	
	boolean isFactory;
	Building callback;
	
	public BuildingType(String type, Building owned)
	{
		if(type.equals("Factory"))
		{
			isFactory = true;
		}
		
		callback = owned;
	}
	
	public void MakeUnit(String unit)
	{
		if(isFactory)
		{
			callback.getPlayer().SpawnNewUnit(unit, callback.location);
		}
	}
	
	public void onClick() {
		
	}
	
	public void reset()
	{
		
	}

}
