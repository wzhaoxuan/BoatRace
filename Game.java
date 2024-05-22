//How the game works, 
//Eg: put in how many steps.... 

import java.util.*;

public class Game {

	private Player[]players;    //Array to store player
	private Boat[]boats;    //Array to store boat
	private River river;    
	private Random random;   //generate random number 
	
	public Game() {
		players = new Player[2];  //2 elements in this array --> 2
		boats = new Boat[2];   //2 boats 
		random = new Random();
		
		initializeRiver();   //Call method to initialize the river below 
	}
	
	private void initializeRiver() {
		river = new River(100);  
		
		Set<Integer> duplicatedIndexes = new HashSet<>();
	
		//Add trap
		for(int i=0; i <10; i++) {    //Add 10 trap
			int index = random.nextInt(100);
			duplicatedIndexes.add(index);
			int strength = random.nextInt(10) + 1; 
			river.addTrap(index, strength);
		}
		
		//Add current
		for (int i=0; i<10; i++) {   //Add 10 current 
			int index;
			do{
				index = random.nextInt(100);
			}while (duplicatedIndexes.contains(index));   //Give a new index if already used
			 int strength = random.nextInt(10) + 1; 
			river.addCurrent(index, strength);
		}
		
	}
	
	
	private int Dice() {
		return random.nextInt(6) + 1;
	}
	
	
	//Enter player name and store them 
	public void play() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter player 1 name");
		String name1 = input.next();
		players[0] = new Player(name1);
		
		System.out.println("Enter player 2 name");
		String name2 = input.next();
		players[1] = new Player(name2);
		
		boats[0]= new Boat(99);
		boats[1] = new Boat(99);
		
		input.nextLine();   //press enter
		
		int currentPlayerIndex = 0;
		
		
		
		//Display the river 
		System.out.println("\nThe river is displayed as below");
		river.displayRiver();
		System.out.println("THE GAME STARTS NOW!!!🤩");
		
		
		
		//Game 
		while(true) {
			Player currentPlayer = players[currentPlayerIndex];
			Boat currentBoat = boats[currentPlayerIndex];
			
			
			System.out.println("It's " + currentPlayer.getName() + "'s turn.\nPress enter to roll the dice");
			input.nextLine();
			
			int steps = Dice();
			System.out.println(currentPlayer.getName() + " rolled a " + steps);
			
			currentBoat.move(steps);

			int currentPosition = currentBoat.getPosition();
			River.Tile tile = river.getTile(currentPosition);
			Current current = tile.getCurrent();
		    Traps trap = tile.getTrap();
			
			
		    
		    
		    //Hitting traps or Current 
			if (trap != null) { // Check if trap object is present
		        System.out.println("Opps " + currentPlayer.getName() + " hit a trap.\nMove backwards " + trap.getStrength() + "steps");
		        currentBoat.move(-trap.getStrength());
		    } else if (current != null) { // Check if current object is present
		        System.out.println("Yay! " + currentPlayer.getName() + " met a current.\nMove forward " + current.getStrength() + "steps");
		        currentBoat.move(current.getStrength());
		    }
			
			
			
			//Display score , player and position in the game 
			currentPlayer.incrementScore();
			
			System.out.println("Player: " + currentPlayer.getName());
			System.out.println("Score: " + currentPlayer.getScore());
			System.out.println("Position: " + currentBoat.getPosition() + "\n");
			
			if (currentPosition >=99) {
				System.out.println(currentPlayer.getName()+ " arrive at the Goal!" );
				System.out.println(currentPlayer.getName()+ " is the Winner!\n GAME OVER 😁" );
				break;
			}
			
			currentPlayerIndex = (currentPlayerIndex + 1)%2;
			
		}
		
		input.close();
		
		
	}

}
