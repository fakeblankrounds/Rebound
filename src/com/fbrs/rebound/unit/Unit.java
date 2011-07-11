package com.fbrs.rebound.unit;

import com.fbrs.utils.math.LPoint;
import com.fbrs.rebound.UI.IClickable;
import com.fbrs.rebound.abstraction.TextureLoader;
import com.fbrs.rebound.player.FactionType;
import com.fbrs.rebound.player.Player;

public class Unit extends OccupiedSpace implements IClickable{ 
	
	private byte hp;
	public byte hp_max;
	public byte atk;
	public byte def;
	private Player owner;
	private String sprite = "";
	public LPoint location;
	public String type;
	private UnitStatus unit;
	
	public Unit(byte h, byte hm, byte a, byte d, Player o, String t, LPoint l)
	{
		hp = h;
		hp_max = hm;
		atk = a;
		def = d;
		owner = o;
		type = t;
		location = l;
	
	}
	
	@Override
	public byte HP() {
		return hp;
	}

	@Override
	public byte atk() {
		return (byte) (atk + owner.atkMod + owner.Faction.getAtk(hp/hp_max));
	}

	@Override
	public byte def() {
		
		return (byte) (owner.defMod + def);
	}

	@Override
	public FactionType getFaction() {
		return owner.Faction;
	}

	@Override
	public boolean isUnit() {
		return true;
	}


	@Override
	public Player getPlayer() {
		return owner;
	}

	@Override
	public void Render() {
		if(sprite == "")
			sprite = TextureLoader.newSprite((int)(location.X) * 128, (int)(location.Y) * 128, 0f, 1,  type, this);
		else
			TextureLoader.moveSprite(sprite, (int)(location.X) * 128, (int)(location.Y) * 128);
		if(unit == null)
			unit = new UnitStatus(type, this);
		
	}

	@Override
	public void onClick(int x, int y) {
		if(!owner.isLocked())
		unit.Clicked((int)location.X, (int)location.Y);
		
	}
	
	public void Move(int x, int y)
	{
		location.X = x;
		location.Y = y;
		Render();
	}

	@Override
	public void resetUnit() {
		unit.resetUnit();
		
	}
	

}
