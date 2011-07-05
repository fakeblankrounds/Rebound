package com.fbrs.rebound.UI;

import java.util.ArrayList;
import java.util.Iterator;

import com.fbrs.rebound.abstraction.TextureLoader;
import com.fbrs.rebound.unit.UnitStatus;

public class Movement {
	
	private static ArrayList<String> MovementSpaces = new ArrayList<String>();
	private static boolean init = false;
	
	private static UnitStatus currentUnit = new UnitStatus();
	
	public static void Init()
	{
		if(init == false)
		{
			for(int i = 0; i < 100; i++)
				MovementSpaces.add(TextureLoader.newSprite(-128, -128, 0, 1, "moveoverlay", new IClickable(){

					@Override
					public void onClick(int x, int y) {
						currentUnit.onClick(x, y);
					}
					
				}));
			init=true;
		}
	}
	
	
	
	public static void setCurrentUnit(UnitStatus c)
	{
		currentUnit = c;
	}
	
	public static void setLocation(int center_x, int center_y)
	{
		Iterator<String> space = MovementSpaces.iterator();
		for(int i = -5; i < 5; i++)
		{
			for(int j = -5; j < 5; j++)
			{
				double d = Math.sqrt((i*i) + (j*j) -1);
				if((i != 0 || j != 0) && d < 4)
					TextureLoader.moveSprite(space.next(), (center_x+i) * 128, (center_y+j) * 128);
			}
		}
	}
	
	public static void reMove()
	{
		for(String s : MovementSpaces)
		{
			TextureLoader.moveSprite(s, -128, -128);
		}
	}
}
