package com.fbrs.rebound.map;

import java.util.ArrayList;
import java.util.HashMap;

import com.fbrs.utils.math.LPoint;
import com.fbrs.rebound.abstraction.TextureLoader;
import com.fbrs.rebound.player.Player;
import com.fbrs.rebound.unit.OccupiedSpace;
import com.fbrs.rebound.unit.Unit;

public class Map {
	
	public ArrayList<OccupiedSpace> units;
	public ArrayList<MapImg> map_img;
	
	public static Player one;
	public static Player two;
	public static Player three; //not available in beta
	public static Player four; //not available in beta
	
	public int MapDimX;
	public int MapDimY;
	
	public int atkMod;
	public int defMod;
	
	private int totalturns;
	private int localPlayer;
	private Player currentPlayer;
	private int icurrentPlayer;
	private boolean isLocalPlayersTurn;
	
	public void StartTurn(int player)
	{
		currentPlayer.Lock();
		currentPlayer = getPlayer(player);
		icurrentPlayer = player;
		currentPlayer.Unlock();	
	}
	
	public int getRotation()
	{
		if(icurrentPlayer == 4)
			return 1;
		else
			return icurrentPlayer++;
	}
	
	public void nextPlayer()
	{
		StartTurn(getRotation());
	}
	
	public Map()
	{
		map_img = new ArrayList<MapImg>();
		units = new ArrayList<OccupiedSpace>();
	}
	
	public void RenderMap()
	{
		for(MapImg img : map_img)
		{
			TextureLoader.newSprite((int)img.point.X*128, (int)img.point.Y*128, img.rot, 1, img.img, null);
		}
		for(OccupiedSpace u : units)
		{
			u.Render();
		}
	
	}
	
	public static Player getPlayer(int p)
	{
		if( p == 1)
			return one;
		if(p == 2)
			return two;
		if(p == 3)
			return three;
		if(p == 4)
			return four;
		return null;
		
	}
	
}
