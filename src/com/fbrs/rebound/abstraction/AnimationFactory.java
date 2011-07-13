package com.fbrs.rebound.abstraction;

import com.fbrs.utils.math.LPoint;

public abstract class AnimationFactory {
	
	public static AnimationFactory animbuilder;
	
	public static void SetImplementer(AnimationFactory builder)
	{
		animbuilder = builder;
	}
	
	public abstract void newAnimation(String texture, LPoint a, LPoint b, int frames, AnimationType type, boolean persistent, int delay);
	
	public abstract void newAnimation(String texture,LPoint res, LPoint a, LPoint b, int frames, AnimationType type, boolean persistent, int delay);
	
	public abstract void existingAnimation(String texture, LPoint a, LPoint b, int frames, AnimationType type, int delay);
	
	public static void StartNewAnimation(String texture, LPoint a, LPoint b, int frames, AnimationType type, boolean persistent, int delay)
	{
		animbuilder.newAnimation(texture, a, b, frames, type, persistent, delay);
	}
	
	public static void StartNewAnimation(String texture, LPoint res, LPoint a, LPoint b, int frames, AnimationType type, boolean persistent, int delay)
	{
		animbuilder.newAnimation(texture, res, a, b, frames, type, persistent, delay);
	}
	
	public static void Animate(String texture, LPoint a, LPoint b, int frames, AnimationType type, int delay)
	{
		animbuilder.existingAnimation(texture, a, b, frames, type, delay);
		
	}
	public enum AnimationType
{
	linear,
	explonential
}
}


