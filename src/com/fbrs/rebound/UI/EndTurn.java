package com.fbrs.rebound.UI;

import com.fbrs.rebound.abstraction.TextureLoader;
import com.fbrs.rebound.map.MapLoad;

public class EndTurn implements IClickable {

	@Override
	public void onClick(int x, int y) {
		MapLoad.map.nextPlayer();
		
	}
	
	public void Render()
	{
		TextureLoader.newSprite(400, 800, 0, 1, "1", this);
	}

}
