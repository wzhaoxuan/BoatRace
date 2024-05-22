//Put in all the index, # and C
public class River {
	private Tile[]track;  //Store the track in an Array 
	public River(int length) {   //Give river the length 
		track = new Tile[length];   
		
		for(int i=0; i <length; i++) {
			track[i] = new Tile();
		}
	}
	
	public void addTrap(int index, int strength) {   //Add trap
		track[index].setTrap(new Traps(strength));
	}
	
	public void addCurrent(int index, int strength) {  //Add current 
		track[index].setCurrent(new Current(strength));
		
	}
	
	
	public Tile getTile(int index) {  //Method to get the tiles at specific index
		return track[index];
	}
	
	class Tile{
		private Current current;
		private Traps trap;
		
		public Tile() {
			current = null;
			trap = null;
		}
		
		public Current getCurrent() {
			return current;
		}
		
		public void setCurrent(Current current) {
			this.current = current;
		}
		
		public Traps getTrap() {
			return trap;
		}
		
		public void setTrap (Traps trap) {
			this.trap = trap;
		}
		
	}
	
	public void displayRiver() {
		 for (Tile tile : track) {
		        Current current = tile.getCurrent();
		        Traps trap = tile.getTrap();
		        
		        if (current != null) {
		            System.out.print("C" + current.getStrength() + " ");
		        } else if (trap != null) {
		            System.out.print("#" + trap.getStrength() + " ");
		        } else {
		            System.out.print("_");
		        }
		    }
		    System.out.println();
		    
	}
}
