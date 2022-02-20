/*
ID :- IT20604530
Name :- Thamindu Chankana Menuwara Gamage
Y2.S1 01.2
Malabe
*/

import java.util.*;//Import java utilization package
import java.util.Random;// Import Random util to generate random values

class Hunter { //create hunter class
	private String name;
	private String color;
	private int x=0;
	private int y=0;
	
	public Hunter() {//default constructor
		
	}
	public Hunter (String name, String color) {//parameterized overload constructor
		this.name = name;
		this.color = color;		
	}
	public String getName() {//passing values to the variable
		return name;
	}
	public void setName(String name) {//setting values to the variable
		this.name = name;
	}
	public String getColor() {//passing values to the variable
		return color;
	}
	public void setColor(String color) {//setting values to the variable
		this.color = color;
	}
	public void setXPos(int x){//setting values to the variable
		this.x = x;
	}
	public void setYPos(int y){//setting values to the variable
		this.y = y;
	}
	public int getXPos() {//passing values to the variable
		return x;
	}
	public int getYPos() {//passing values to the variable
		return y;
	}
	
	public void move(Hunter post) throws SoundException {//move method which throws the user defined exception SoundException
		this.x = post.x;
		this.y = post.y;
		
		post.getXPos();//get hunter x position
		post.getYPos();//get hunter y position
		
		if((x>=250) ||(y>=360)){//checking the condition hunter maximum coordinates
				throw new SoundException("Message");//exception message				
			}
		else {
				System.out.println("Hunter is Moving, X:"+post.getXPos()+" Y:"+post.getYPos());//display hunter's coordinates
			}		
	}
	
	public void hunt(Board obj) {//hunt method which accepting object from the class Board
		System.out.println(obj.dotType());//type of the dot
			while(((obj.getDot() != 0) && (obj.getSuperDot() != 0))) {//while dot count and superDot count becomes zero
			if(obj.getDotType().equals("Dot")) {//checking of the dot type
				obj.setDot(obj.getDot()-1);//decrement dot
			}
			else if(obj.getDotType().equals("superDot")) {//checking of the dot type
				obj.setSuperDot(obj.getSuperDot()-1);//decrement super dot
				Soldier assignSoliders[]=obj.getThreeSoldiers();// removing the last soldier if hunter hunts a super dot
				obj.setThreeSoldiers(Arrays.copyOf(assignSoliders, assignSoliders.length-1));
			}
		}
		if ((obj.getDot() == 0) && (obj.getSuperDot() == 0)) {// hunter wins the game if the dot count is 0
			System.out.println("Hunter Wins !");
		}
	}
		
}

class SoundException extends Exception{//create user definrd exception
	
	public SoundException(String message) {//user defined exception
		super("Oh oo !!");
	}

}

class Board {//create class board
		
	private String dotType;
	private Hunter myHunter;//accept object from hunter class
	private Soldier threeSoldiers[];
	private int dot = 97;//set dot value
	private int superDot = 3; // set super dot value
	
	private int initX;
	private int initY;
	
	public Board(String dotType, Hunter myHunter, Soldier[] threeSoldiers) {//parameterized constructor for board class created
		// TODO Auto-generated constructor stub
		this.dotType = dotType;
		this.myHunter = myHunter;
		this.threeSoldiers = threeSoldiers;
		init(myHunter, threeSoldiers);	//passing values to init class	
	}
	
	public String dotType() {//check the dotType
		if(dotType.equals("superDot")) {
			return "Hunting Super Dots";
		}
		else
		{
			return "Hunting Dots";
		}
	}
	public void init(Hunter myHunter, Soldier threeSoliders[]) {//method init
		this.superDot = 3;//initialization
		this.dot=97;//initialization
		
		for(Soldier soldier: threeSoldiers ) {//set soldiers in random positions
			Random r = new Random();//generate random numbers
            soldier.setX(r.nextInt(250));//random numbers for x
            soldier.setY(r.nextInt(360));//random numbers for y
		}
		myHunter.setXPos(0);//initialize hunter x position
		myHunter.setYPos(0);//initialize hunter y position
	}
	{
		System.out.println("Board is ready and three soldiers and the hunter is positioned in the board");//output
	}

	public String getDotType() {//passing values to the variable
		return dotType;
	}

	public void setDotType(String dotType) {//setting values to the variable
		this.dotType = dotType;
	}

	public Hunter getMyHunter() {//passing values to the variable
		return myHunter;
	}

	public void setMyHunter(Hunter myHunter) {//setting values to the variable
		this.myHunter = myHunter;
	}

	public Soldier[] getThreeSoldiers() {//passing values to the variable
		return threeSoldiers;
	}

	public void setThreeSoldiers(Soldier[] threeSoldiers) {//setting values to the variable
		this.threeSoldiers = threeSoldiers;
	}

	public int getDot() {//passing values to the variable
		return dot;
	}

	public void setDot(int dot) {//setting values to the variable
		this.dot = dot;
	}

	public int getSuperDot() {//passing values to the variable
		return superDot;
	}

	public void setSuperDot(int superDot) {//setting values to the variable
		this.superDot = superDot;
	}
			
}

interface Soldier {//create interface 
	public void hunt();//abstract method
	
	public void setX(int x);//set value
	public void setY(int y);//set value
	    
	public int getX(int x);//pass value
	public int getY(int y);//pass value

}

class BlueSoldier implements Soldier {//BlueSoldier class implementing soldier interface
    private int x;
    private int y;

    public BlueSoldier () {//default constructor BlueSoldier
    }

    @Override
    public void hunt() {//overrided hunter method
        System.out.println("Killed using a gun");
        System.out.println("Game Over");
    }

    @Override
    public void setX(int x) {//setting values to the variable
        this.x = x;
    }

    @Override
    public void setY(int y) {//setting values to the variable
        this.y = y;
    }

    @Override
    public int getX(int x) {//passing values to the variable
        return x;
    }

    @Override
    public int getY(int y) {//passing values to the variable
        return y;
    }
}
class GreenSoldier implements Soldier{//GreenSoldier class implementing soldier interface
    private int x;
    private int y;

    public GreenSoldier () {//default constructor GreenSoldier
    }

    @Override
    public void hunt() {//overrided hunter method
        System.out.println("Killed using a knife");
        System.out.println("Game Over");
    }

    @Override
    public void setX(int x) {//setting values to the variable
        this.x = x;
    }

    @Override
    public void setY(int y) {//setting values to the variable
        this.y = y;
    }

    @Override
    public int getX(int x) {//passing values to the variable
        return x;
    }

    @Override
    public int getY(int y) {//passing values to the variable
        return y;
    }
}


class RedSoldier implements Soldier{//RedSoldier class implementing soldier interface
    private int x;
    private int y;

    public RedSoldier () {//RedSoldier default constructor
    }

    @Override
    public void hunt() {//overrided hunter method
        System.out.println("Killed using a hand");
        System.out.println("Game Over");
    }

    @Override
    public void setX(int x) {//setting values to the variable
        this.x = x;
    }

    @Override
    public void setY(int y) {//setting values to the variable
        this.y = y;
    }

    @Override
    public int getX(int x) {//passing values to the variable
        return x;
    }

    @Override
    public int getY(int y) {//passing values to the variable
        return y;
    }

   
}
class Main {

	public static void main(String[] args) throws SoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);//create a scanner object to input user input
		Hunter myHunter = new Hunter("Maha Deva", "Brown");//creating hunter object passing values to hunter parameterized constructor
		Soldier threeSoldiers[] = {new RedSoldier(), new RedSoldier(), new GreenSoldier()};//passing referneces to soldier interface via passing objects to RedSoldier and GreenSoldier classes
		Board myBoard = new Board("superDot", myHunter, threeSoldiers);//creating board object and passing values to new board object
		
		System.out.println("Use the keyboard up,down,left,right arrow keys to move the hunter");
		myHunter.setXPos(sc.nextInt());//keyboard input to hunter x position
		myHunter.setYPos(sc.nextInt());//keyboard value for hunter y position
		
		myHunter.move(myHunter);//passing object to move method in hunter class
		myHunter.hunt(myBoard);//passing object to hunt method in hunter class
		threeSoldiers[2].hunt();//passing the greensoldier object to hunt method in GreenSoldier class

	}

}




	
	
	
