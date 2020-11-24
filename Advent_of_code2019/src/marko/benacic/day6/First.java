package marko.benacic.day6;

import java.io.IOException; 
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class First {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("day6_captcha.txt");
		Scanner sc = new Scanner(path);
		
	//	Set<Ufo> orbits = new HashSet<Ufo>();
		
		Set<Ufo> orbits = new HashSet<Ufo>();
		
		
		while(sc.hasNext()) {
			String[] input = sc.next().split("\\)");
			
			
			Ufo orbited = new Ufo(input[0]);
			Ufo whoOrbits = new Ufo(input[1]);
			
			if(orbits.contains(whoOrbits) && orbits.contains(orbited)) {
				outerloop:
				for(Ufo u : orbits) {
					if(u.equals(whoOrbits)) {
						for(Ufo u2 : orbits) {
							if(u2.equals(orbited)) {
								u.orbits = u2;
								break outerloop;
							}
						}
					}
				} 
			}else if(orbits.contains(whoOrbits) && !orbits.contains(orbited)) {
				for(Ufo u : orbits) {
					if(u.equals(whoOrbits)) {
						u.orbits = orbited;
						orbits.add(orbited);
						break;
					}
				}
			}else if(!orbits.contains(whoOrbits) && orbits.contains(orbited)) {
				for(Ufo u : orbits) {
					if(u.equals(orbited)) {
						whoOrbits.orbits = orbited;
						orbits.add(whoOrbits);
						break;
					}
				}
			}else if(!orbits.contains(whoOrbits) && !orbits.contains(orbited)) {
				whoOrbits.orbits = orbited;
				orbits.add(whoOrbits);
				orbits.add(orbited);
			}
		}
		
		long counter = 0;
		Ufo current;
		
		for(Ufo u : orbits) {
			current = u;
			while(current.orbits != null) {
				counter++;
				current = current.orbits;
				System.out.print(current.name + " -> ");
			}
			System.out.println();
		}
		
		
		System.out.println(counter);
	}
}
