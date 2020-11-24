package marko.benacic.day3;

public class Line {
	public Coordinate beg;
	public Coordinate end;
	
	public Line(Coordinate beg, Coordinate end) {
		this.beg = beg;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return  beg.toString() + " || " + end.toString();
	}
}	
