package com.fbrs.rebound.unit;

import java.util.HashMap;

public class UnitsLookup {

	private static  HashMap<Integer, Unit> Units;
	private static boolean init;
	
	private  static void Init()
	{
		Units = new HashMap<Integer, Unit>();
		//public Unit(byte h, byte hm, byte a, byte d, Player o, String t, LPoint l)
		Units.put(1, new Unit((byte)10, (byte)10, (byte)0, (byte)0, null, "1", null));
		Units.put(7, new Unit((byte)10, (byte)10, (byte)0, (byte)0, null, "7", null));
	}
	public static Unit Find(int i)
	{
		if(!init)
			Init();
		return Units.get(i);
	}
	
	
}
