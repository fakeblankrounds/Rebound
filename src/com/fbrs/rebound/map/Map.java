package com.fbrs.rebound.map;

import java.util.ArrayList;
import java.util.HashMap;

import com.fbrs.utils.math.LPoint;
import com.fbrs.rebound.UI.IClickable;
import com.fbrs.rebound.abstraction.AnimationFactory;
import com.fbrs.rebound.abstraction.TextureLoader;
import com.fbrs.rebound.abstraction.AnimationFactory.AnimationType;
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
	
	private int drawOffsetX = 0;
	private int drawOffsetY = 0;
	private float scale = 1;
	
	private int totalturns = 0;
	private int localPlayer;
	private Player currentPlayer = new Player();
	private int icurrentPlayer;
	private boolean isLocalPlayersTurn;
	
	private IClickable mapclick = null;
	
	public void StartTurn(int player)
	{
		currentPlayer.Lock();
		currentPlayer = getPlayer(player);
		icurrentPlayer = player;
		currentPlayer.Unlock();	
	}
	
	public void addDrawOffset(int x, int y)
	{
		drawOffsetX = x;
		drawOffsetY = y;
	}
	
	public int getRotation()
	{
		if(icurrentPlayer == 2)
			return 1;
		else
		{	
			icurrentPlayer++;
			return icurrentPlayer;
		}
	}
	
	public void nextPlayer()
	{
		StartTurn(getRotation());
		AnimationFactory.StartNewAnimation("p"+icurrentPlayer+"start", new LPoint(256, 128) ,new LPoint(272, 0), new LPoint(272, 176), 10, AnimationType.linear, false, 10);
	}
	
	public Map()
	{
		map_img = new ArrayList<MapImg>();
		units = new ArrayList<OccupiedSpace>();
		//one = new Player();
		//one = new Player();
	}
	
	public void setMapScale(float scale)
	{
		this.scale = scale;
	}
	
	public void addMapClick(IClickable clicker)
	{
		mapclick = clicker;
	}
	
	public void RenderMap()
	{
		for(MapImg img : map_img)
		{
			TextureLoader.newSprite((int)((img.point.X*128) * scale) + drawOffsetX, (int)((img.point.Y*128) * scale )+ drawOffsetY, img.rot, scale, 1, img.img, mapclick);
		}
		for(OccupiedSpace u : units)
		{
			u.Render();
		}
	
		/*TextureLoader.newSprite(512, 64, 0, 416, 0, 2, "commandcenter", new IClickable(){

			@Override
			public void onClick(int x, int y) {
				nextPlayer();
				
			}
			
		}); */
	}
	
	public static Player getPlayer(int p)
	{
		if( p == 1)
			return one;
		else if(p == 2)
			return two;
		else if(p == 3)
			return three;
		else if(p == 4)
			return four;
		else
			return null;
		
	}
	
}
