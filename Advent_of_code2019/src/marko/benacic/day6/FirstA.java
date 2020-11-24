package marko.benacic.day6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FirstA{
	
	public static void main(String[] args) throws IOException{
		Path path = Paths.get("day6_captcha.txt");
		Scanner sc = new Scanner(path);	
		
		ArrayList<Helper> list = new ArrayList<Helper>();
			
		
		
		Map<String, Ufo> mapa = new HashMap<String, Ufo>();
		
		
		
		while(sc.hasNext()) {
			String[] line = sc.next().split("\\)");
			list.add(new Helper(line[0], line[1]));	
		}
		
		for(Helper h : list) {
			mapa.put(h.desno, new Ufo(h.desno));
		}
		
		for(Helper h : list) {
			//orbitsAround punjenje
			mapa.get(h.desno).orbitsAround = mapa.get(h.lijevo);
		}
		
		for(Helper h : list) {
			//isOrbitedBy punjenje
			
			if(mapa.get(h.lijevo) != null) {
				mapa.get(h.lijevo).isOrbitedBy = mapa.get(h.desno);
			}
		}
		
//		for(Entry<String, Ufo> e : mapa.entrySet()) {
//			System.out.println(e.getValue());
//		}
		
		
		int counter = 0;
		for(Ufo u : mapa.values()) {
			Ufo current = u;
			while(current != null) {
				current = current.orbitsAround;
				counter++;
			}
		}
		System.out.println(counter);
		
		Ufo start = mapa.get("YOU");
		Ufo end = mapa.get("SAN");
		
	//	System.out.println(minimumToSanta(start, end));
	}
	
	public static int minimumToSanta(Ufo start, Ufo end) {
		
		
		
		if(start.equals(end)) {
			return 0;
		}
		
		if(start.isOrbitedBy == null) {
			return minimumToSanta(start.orbitsAround, end) + 1;
		}else if(start.orbitsAround == null){
			return minimumToSanta(start.isOrbitedBy, end) + 1;
		}else {
			int left = minimumToSanta(start.isOrbitedBy, end) + 1;
			int right = minimumToSanta(start.orbitsAround, end) + 1;
			
			return left < right ? left : right;
		}
		
		
		
		
	}
}
