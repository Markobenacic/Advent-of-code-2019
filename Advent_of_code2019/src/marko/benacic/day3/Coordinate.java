package marko.benacic.day3;

public class Coordinate {
	public int x;
	public int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "x=" + x + ",y=" + y;
	}
}
