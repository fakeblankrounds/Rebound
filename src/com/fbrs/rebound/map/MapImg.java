package com.fbrs.rebound.map;

import com.fbrs.utils.math.LPoint;

public class MapImg {
	public LPoint point;
	public String img;
	public float rot;
	
	public MapImg(LPoint p, float rot, String i)
	{
		point = p;
		img = i;
		this.rot = rot;
	}

}
