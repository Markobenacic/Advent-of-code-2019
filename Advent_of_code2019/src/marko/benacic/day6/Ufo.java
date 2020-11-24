package marko.benacic.day6;

public class Ufo implements Comparable<Ufo>{
	public String name;
	public Ufo orbitsAround;
	
	public Ufo isOrbitedBy;
	
	
	public Ufo(String name){
		this.name = name;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ufo other = (Ufo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	@Override
	public int compareTo(Ufo o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}



	@Override
	public String toString() {
		
		return this.name +  " orbits around " + this.orbitsAround.name + ", and is orbited by " + this.isOrbitedBy.name;
	}
	
	
}
