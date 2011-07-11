package com.fbrs.rebound.map;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.fbrs.utils.math.LPoint;
import com.fbrs.rebound.player.FactionType;
import com.fbrs.rebound.player.Player;
import com.fbrs.rebound.unit.Unit;
import com.fbrs.rebound.unit.UnitsLookup;

/**This is the main class for every single game. This loads the game file and generates all the elements.
 * @author Nick
 *
 */
public class MapLoad {
	
	public static Map map;
	public static void SetPlayers(FactionType one, FactionType two)
	{
		map.one = new Player();
		map.two = new Player();
	}
	
	public static void ParseFile(InputStream Path)
	{
		map = new Map();
		SetPlayers(null,null);
		map.StartTurn(1);
		 try {
			 //FileInputStream fstream = new FileInputStream(Path);
			  // Get the object of DataInputStream
			 DataInputStream in = new DataInputStream(Path);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			 String sline;
			 int linenumber = 0;
			 while((sline = br.readLine()) != null)
			 {
				if(!sline.equals(""))
				ParseLine(sline);
				 linenumber++;
			 }
			 br.close();
			 in.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	//sample line
	//X,Y,int,unit-unithealth-unitowner
	private static void ParseLine(String line)
	{
		String[] subline = line.split(",");
		int x = Integer.parseInt(subline[0]);
		int y = Integer.parseInt(subline[1]);
		float rot = Float.parseFloat(subline[2]);
		map.map_img.add(new MapImg(new LPoint(x,y), rot, subline[3]));
		if(map.MapDimX < x)
			map.MapDimX = x;
		if(map.MapDimY < y)
			map.MapDimY = y;
		if(subline.length >= 5)
			ParseUnit(subline[4], x, y);
	}

	
	private static void ParseUnit(String line, int x, int y)
	{
		if(line == "")
			return;
		String[] subline = line.split("-");
		Unit temp = UnitsLookup.Find(Integer.parseInt(subline[0]));
		Player p = Map.getPlayer(Integer.parseInt(subline[2]));
		Unit u = new Unit(Byte.parseByte(subline[1]), temp.hp_max, temp.atk, temp.def,p , temp.type, new LPoint(x,y));
		map.units.add(u);
		p.Owned.put(line, u);
		
	}
}
