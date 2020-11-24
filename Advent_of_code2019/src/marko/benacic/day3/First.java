package marko.benacic.day3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class First {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("day3_captcha.txt");
		Scanner sc = new Scanner(path);
		
		String[] linija1 = sc.next().split(",");
		String[] linija2 = sc.next().split(",");
		
		
		
		Coordinate[] relativnaPoz1 = new Coordinate[linija1.length + 1];
		Coordinate[] relativnaPoz2 = new Coordinate[linija2.length + 1];
		
		relativnaPoz1[0] = new Coordinate(0,0);
		relativnaPoz2[0] = new Coordinate(0,0);
		
		
		//punjenje arraya pozicija
		
		for(int i = 0; i < linija1.length; i++) {
			String s = linija1[i];
			String[] pomak = s.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
			
			if("U".equals(pomak[0])) {
				relativnaPoz1[i+1] = new Coordinate(relativnaPoz1[i].x, relativnaPoz1[i].y + Integer.parseInt(pomak[1]));
			}else if("D".equals(pomak[0])) {
				relativnaPoz1[i+1] = new Coordinate(relativnaPoz1[i].x, relativnaPoz1[i].y - Integer.parseInt(pomak[1]));
			}else if("L".equals(pomak[0])) {
				relativnaPoz1[i+1] = new Coordinate(relativnaPoz1[i].x - Integer.parseInt(pomak[1]), relativnaPoz1[i].y);
			}else if("R".equals(pomak[0])) {
				relativnaPoz1[i+1] = new Coordinate(relativnaPoz1[i].x + Integer.parseInt(pomak[1]), relativnaPoz1[i].y);
			}else {
				System.out.println("dogodio se else");
			}
		}
		
		for(int i = 0; i < linija2.length; i++) {
			String s = linija2[i];
			String[] pomak = s.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
			
			if("U".equals(pomak[0])) {
				relativnaPoz2[i+1] = new Coordinate(relativnaPoz2[i].x, relativnaPoz2[i].y + Integer.parseInt(pomak[1]));
			}else if("D".equals(pomak[0])) {
				relativnaPoz2[i+1] = new Coordinate(relativnaPoz2[i].x, relativnaPoz2[i].y - Integer.parseInt(pomak[1]));
			}else if("L".equals(pomak[0])) {
				relativnaPoz2[i+1] = new Coordinate(relativnaPoz2[i].x - Integer.parseInt(pomak[1]), relativnaPoz2[i].y);
			}else if("R".equals(pomak[0])) {
				relativnaPoz2[i+1] = new Coordinate(relativnaPoz2[i].x + Integer.parseInt(pomak[1]), relativnaPoz2[i].y);
			}else {
				System.out.println("dogodio se else");
			}
		}
		
		
		ArrayList<Line> lines1 = new ArrayList<Line>();
		ArrayList<Line> lines2 = new ArrayList<Line>();
		
		for(int i = 0; i < relativnaPoz1.length - 1; i++) {
			lines1.add(new Line(relativnaPoz1[i], relativnaPoz1[i+1]));
		}
		
		for(int i = 0; i < relativnaPoz2.length - 1; i++) {
			lines2.add(new Line(relativnaPoz2[i], relativnaPoz2[i+1]));
		}
		
		
		ArrayList<Coordinate> intersections = new ArrayList<Coordinate>();
		
		getIntersections(lines1, lines2, intersections);
		System.out.println(intersections.size());
		
		
		
		
		int najmanjaUdaljenost = 100000;
		
		for(Coordinate c : intersections) {
			int udaljenost = Math.abs(c.x) + Math.abs(c.y);
			if(udaljenost < najmanjaUdaljenost) {
				najmanjaUdaljenost = udaljenost;
			}
		}
		
		System.out.println(najmanjaUdaljenost);
		
		
		
		//drugi dio
		
		long leastSteps = Long.MAX_VALUE;
		
		for(Coordinate intersection : intersections) {
			long steps1 = 0;
			long steps2 = 0;
			
			for(Line line1 : lines1) {
				if(line1.beg.x == line1.end.x && intersection.x == line1.beg.x) {
					if((Math.abs(intersection.y - line1.beg.y) + Math.abs(line1.end.y - intersection.y)) == Math.abs(line1.end.y - line1.beg.y)) {
						steps1 += Math.abs(line1.beg.y - intersection.y);
						break;
					}
				}else if(intersection.y == line1.beg.y) {
					if((Math.abs(intersection.x - line1.beg.x) + Math.abs(line1.end.x - intersection.x)) == Math.abs(line1.end.x - line1.beg.x)) {
						steps1 += Math.abs(line1.beg.x - intersection.x);
						break;
					}
				}
				
				if(line1.beg.x == line1.end.x) {
					steps1 += Math.abs(line1.beg.y - line1.end.y);
				}else {
					steps1 += Math.abs(line1.beg.x - line1.end.x);
				}
			}
			
			for(Line line2 : lines2) {
				if(line2.beg.x == line2.end.x && intersection.x == line2.beg.x) {
					if((Math.abs(intersection.y - line2.beg.y) + Math.abs(line2.end.y - intersection.y)) == Math.abs(line2.end.y - line2.beg.y)) {
						steps2 += Math.abs(line2.beg.y - intersection.y);
						break;
					}
				}else if(intersection.y == line2.beg.y) {
					if((Math.abs(intersection.x - line2.beg.x) + Math.abs(line2.end.x - intersection.x)) == Math.abs(line2.end.x - line2.beg.x)) {
						steps2 += Math.abs(line2.beg.x - intersection.x);
						break;
					}
				}
				
				if(line2.beg.x == line2.end.x) {
					steps2 += Math.abs(line2.beg.y - line2.end.y);
				}else {
					steps2 += Math.abs(line2.beg.x - line2.end.x);
				}
			}
			
			
			if (leastSteps > steps1 + steps2) {
				leastSteps = steps1 + steps2;
			}
		}
		
		System.out.println("least steps: " + leastSteps);
	}
	
	
	
	
	
	public static void getIntersections(ArrayList<Line> lines1, ArrayList<Line> lines2, ArrayList<Coordinate> intersections) {
		for(Line line1 : lines1) {
			for(Line line2 : lines2) {
				
				if(getIntersection(line1,line2) != null) {
					intersections.add(getIntersection(line1,line2));
				}
			}
		}
	}
	
	public static Coordinate getIntersection(Line line1, Line line2) {
		
		Coordinate firstBeg = line1.beg;
		Coordinate firstEnd = line1.end;
		
		Coordinate secondBeg = line2.beg;
		Coordinate secondEnd = line2.end;
		
		if( firstBeg.x == firstEnd.x && secondBeg.x == secondEnd.x) {
			return null;
		}else if (firstBeg.y == firstEnd.y && secondBeg.y == secondEnd.y) {
			return null;
		}
		
		
		if(firstBeg.x == firstEnd.x ) {
			
			if(Math.abs(firstBeg.x - secondBeg.x) + Math.abs(secondEnd.x - firstBeg.x) == Math.abs(secondEnd.x - secondBeg.x)) {
				
				if(Math.abs(secondBeg.y - firstBeg.y) + Math.abs(firstEnd.y - secondBeg.y) == Math.abs(firstEnd.y - firstBeg.y)) {
					return new Coordinate(firstBeg.x, secondBeg.y);
				}
			}

			
		}else if (firstBeg.y == firstEnd.y ){
			
			if(Math.abs(firstBeg.y - secondBeg.y) + Math.abs(secondEnd.y - firstBeg.y) == Math.abs(secondEnd.y - secondBeg.y)) {
				
				if(Math.abs(secondBeg.x - firstBeg.x) + Math.abs(firstEnd.x - secondBeg.x) == Math.abs(firstEnd.x - firstBeg.x)) {
					return new Coordinate(secondBeg.x, firstBeg.y);
				}
			}
			
		}
		
		return null;
		
	}
}

