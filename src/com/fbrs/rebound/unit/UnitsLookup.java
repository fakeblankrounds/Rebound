package com.fbrs.rebound.unit;

import java.util.HashMap;

public class UnitsLookup {

	private static  HashMap<String, Unit> Units;
	private static boolean init;
	
	private  static void Init()
	{
		Units = new HashMap<String, Unit>();
		//public Unit(byte health, byte health_max, byte atk, byte def, byte supply, Player p, String texture, LPoint location)
		Units.put("Drone", new Unit((byte)1, (byte)1, (byte)0, (byte)0, (byte)5, null, "1", null));
		Units.put("Tank", new Unit((byte)17, (byte)17, (byte)10, (byte)2,(byte)10, null, "1", null));
		Units.put("Range", new Unit((byte)20, (byte)20, (byte)15, (byte)2,(byte)20,  null, "1", null));
		Units.put("AntiA", new Unit((byte)30, (byte)30, (byte)20, (byte)2, (byte)20, null, "1", null));
		Units.put("Bomber", new Unit((byte)45, (byte)45, (byte)20, (byte)1,(byte)50,  null, "1", null));
		Units.put("Fighter", new Unit((byte)30, (byte)30, (byte)25, (byte)2,(byte)45,  null, "1", null));
		Units.put("Tower", new Unit((byte)100, (byte)100, (byte)30, (byte)5,(byte)90,  null, "7", null));
	
		Units.put("AutoC", new Unit((byte)30, (byte)30, (byte)20, (byte)4,(byte)0,  null, "7", null));
		Units.put("HeadQ", new Unit((byte)50, (byte)50, (byte)0, (byte)5,(byte)0,  null, "7", null));
		Units.put("atkup", new Unit((byte)20, (byte)20, (byte)0, (byte)5,(byte)0,  null, "7", null));
		Units.put("defup", new Unit((byte)20, (byte)20, (byte)0, (byte)5,(byte)0,  null, "7", null));
		Units.put("Supply", new Unit((byte)15, (byte)15, (byte)0, (byte)5,(byte)0,  null, "7", null));
		Units.put("Factory", new Unit((byte)30, (byte)30, (byte)0, (byte)5, (byte)0, null, "7", null));
	
	}
	public static Unit Find(String i)
	{
		if(!init)
			Init();
		return Units.get(i);
	}
	
	
}
