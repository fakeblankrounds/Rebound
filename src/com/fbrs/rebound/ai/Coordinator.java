package com.fbrs.rebound.ai;

import com.fbrs.rebound.player.Player;
import com.fbrs.rebound.unit.Unit;
import com.fbrs.utils.math.LPoint;

public class Coordinator {

	private Player player;

	private LPoint move = new LPoint(1,1);

	public Coordinator(Player p)
	{
		player = p;
	}
	
	public Coordinator()
	{
	
	}
	
	public void setPlayer(Player p)
	{
		player = p;
	}

	public void go()
	{
		moveUnit(SelectUnit());
	}

	public Unit SelectUnit()
	{
		if(player.Owned.size() > 0)
			return (Unit) player.Owned.values().iterator().next();
		else
			return null;
	}

	public void moveUnit(Unit u)
	{
		if(u != null)
		{
			u.Move((int)(u.location.X + move.X), (int)(u.location.Y+ move.Y));
			move.X *= -1;
			move.Y *= -1;
		}
	}
}
