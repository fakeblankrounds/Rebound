package com.fbrs.rebound.abstraction;

import com.fbrs.utils.math.LPoint;

public abstract class AnimationFactory {
	
	public static AnimationFactory animbuilder;
	
	public static void SetImplementer(AnimationFactory builder)
	{
		animbuilder = builder;
	}
	
	public abstract void newAnimation(String texture, LPoint a, LPoint b, int frames);
	
	public abstract void existingAnimation(String texture, LPoint a, LPoint b, int frames);
	
	public static void StartNewAnimation(String texture, LPoint a, LPoint b, int frames)
	{
		animbuilder.newAnimation(texture, a, b, frames);
	}
	
	public static void Animate(String texture, LPoint a, LPoint b, int frames)
	{
		animbuilder.existingAnimation(texture, a, b, frames);
	}
}
