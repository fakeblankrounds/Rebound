package com.fbrs.rebound.unit;

import java.util.ArrayList;
import java.util.Iterator;

import com.fbrs.rebound.UI.IClickable;
import com.fbrs.rebound.UI.Movement;
import com.fbrs.rebound.abstraction.TextureLoader;

public class UnitStatus implements IClickable{
	
	private enum State {Moved, Done, Free};
	
	public String type;
	public State state; 
	public boolean showing; 
	private Unit callback;
	
	public UnitStatus()
	{
		//dummy
	}
	
	public void resetUnit() {
		state = State.Free;
	}
	
	public UnitStatus(String type, Unit callback)
	{
		this.type  =type;
		state = State.Free;
		Movement.Init();
		this.callback = callback;
	}
	
	@Override
	public void onClick(int x, int y)
	{
		callback.Move(x/128, y/128);
		reMove();
	}
	
	public void Clicked(int x, int y)
	{
 		if(state == State.Free)
		{
			Movement.setCurrentUnit(this);
			setMove(x,y);
		}
		else if(state == State.Moved)
		{
			reMove();
		}
	}
	
	public void reMove()
	{
		Movement.reMove();
	}
	
	public void setMove(int center_x, int center_y)
	{
		state = State.Moved;
		Movement.setLocation(center_x, center_y);
		
	}
}
