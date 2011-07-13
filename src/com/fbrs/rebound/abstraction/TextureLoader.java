package com.fbrs.rebound.abstraction;

import com.fbrs.rebound.UI.IClickable;

public class TextureLoader {
	
	private static TextureLoader l;
	
	public static void setTextureLoader(TextureLoader loader)
	{
		l = loader;
	}
	
	public static String newSprite(int x, int y, float rot, int z, String img, IClickable onclick)
	{
		return l.MakeSprite(x, y, rot, z, img, onclick);
	}
	
	public static String newSprite(int x, int y, float rot, float scale,  int z, String img, IClickable onclick)
	{
		return l.MakeSprite(x, y, rot, scale, z, img, onclick);
	}
	
	public static String newSprite(int resx, int resy, int x, int y, float rot, int z, String img, IClickable onclick)
	{
		return l.MakeSprite(resx, resy, x, y, rot, z, img, onclick);
	}
	
	public static String newSprite(int resx, int resy, int x, int y, float rot, float scale, int z, String img, IClickable onclick)
	{
		return l.MakeSprite(resx, resy, x, y, rot, scale, z, img, onclick);
	}
	
	
	public String MakeSprite(int x, int y, float rot, int z, String img, IClickable onclick)
	{
		return null;
	}
	
	public String MakeSprite(int x, int y, float rot, float scale, int z, String img, IClickable onclick)
	{
		return null;
	}
	
	public String MakeSprite(int resx, int resy, int x, int y, float rot, int z, String img, IClickable onclick)
	{
		return null;
	}
	
	public String MakeSprite(int resx, int resy, int x, int y, float rot, float scale, int pZIndex, String sprite, final IClickable onclick)
	{
		return null;
	}
	
	public static void moveSprite(String sprite, int x, int y)
	{
		l.MoveSprite(sprite, x, y);
	}
	
	public  void MoveSprite(String sprite, int x, int y) {}
	
	public void resetTextures() {};
	
	public static void ReloadTextures()
	{
		if(l != null)
			l.resetTextures();
	}

}
