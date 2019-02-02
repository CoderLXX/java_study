import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.*;
import java.util.ArrayList;


public class Game {
	private Stadium stadium;
	private Team homeTeam;
	private Team visitingTeam;
	private SoccerBall ball;
	private Referee majorReferee;
	private Referee[] linesmen;

	
    

	public static void main(String[] args) {
		Game game = new Game();
		// data
	    String[] teams = {"Real Madrid", "Barcelona", "Manchester United", "Chelsea", "Juventus", "AC Milan"};
	    String[] stadiums = {"San Siro", "Nou Camp", "Bernabeu", "Old Trafford"};
        Scanner scanner = new Scanner(System.in);

		System.out.println("We're loading Referee data...");
    	Referee majorReferee = new Referee("Samantha Koberlein", 33);
		Referee linesman1 = new Referee("Petea", 23);
		Referee linesman2 = new Referee("Joha", 26);
		settingGameReferee(majorReferee,new Referee[]{linesman1, linesman2});

		SoccerBall ball = new SoccerBall(3);

		System.out.println("Welcome to my soccer game. Please input \"start\"");
        
        while (scanner.hasNextLine()) {
        	if (scanner.nextLine().equalsIgnoreCase("Start")) {
        		System.out.println("Here we go! Please select home team first:\n");
        		printArrayToString(teams);
        	}
        	// load homeTeam
        	String inputHomeN = scanner.nextLine();
        	int homeIndex = game.getIndexSelectItemFormArrayData(teams, inputHomeN);
        	if (homeIndex <= teams.length) {
	            Team homeTeam = new Team(teams[homeIndex], true);
	            teams = getNewArrayAfterDeleteItem(teams, homeIndex);
        	}
        	
        	// load visitingTeam
        	System.out.println("Please select visit team:");
        	printArrayToString(teams);
        	String inputVisitN = scanner.nextLine();
        	int visitIndex = game.getIndexSelectItemFormArrayData(teams, inputVisitN);
        	if (visitIndex <= teams.length) {
	            Team visitTeam = new Team(teams[visitIndex], false);
        	}
        	

        	// load stadium
			System.out.println("Please select the stadium for the match:");
			printArrayToString(stadiums);
			String inputStadium = scanner.nextLine();
			int stadiumIndex = game.getIndexSelectItemFormArrayData(stadiums, inputStadium);
			if (stadiumIndex <= stadiums.length) {
	        	Stadium stadium = new Stadium(stadiums[stadiumIndex]);
		    	System.out.printf("soccer court width:%d length:%d\n",stadium.width, stadium.length);
			}

			System.out.println("Good job! All settle down. Game started.");
        }
	}

    private static void printArrayToString(String[] arr){
    	String printStr = "";
        for (String item: arr) {
        	printStr += item + ",";
        }
        System.out.println(printStr);
    }

    private static String[] getNewArrayAfterDeleteItem(String[] arr, int index) {
    	String[] tempArr = new String[arr.length - 1];
    	boolean isSame = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (i >= index) {
				isSame = true;
                tempArr[i] = arr[i+1];
			}
			else {
				tempArr[i] = arr[i];
			}
		}
		return tempArr;
    }

    private static int getIndexSelectItemFormArrayData(String[] arr, String item) {

    	Pattern pattern = Pattern.compile("[0-9]*");
	    boolean isInt = pattern.matcher(item).matches();
        if (isInt) {
		    int index = Integer.parseInt(item);

        	if (index<1 || index > arr.length + 1) {
        		throw new IllegalArgumentException("Illegal index~~~");
        	}
        	return index - 1;
        }

    	String itemFirstLetter = item.substring(0,1).toUpperCase();
        for (int i = 0; i < arr.length; i++) {
        	String firstLetter = arr[i].substring(0,1).toUpperCase();
        	if (firstLetter.equals(itemFirstLetter)) {
        		return i;
        	}
        }
        return arr.length + 1;
    }

	private static void settingGameReferee(Referee referee, Referee[] linesmen) {
    	if (linesmen.length != 2) {
    		throw new IllegalArgumentException("linesmen must be two");
    	}
    	System.out.println("setting MajorReferee name:" + referee.name + "age:" + referee.age);
    	for (Referee lineman: linesmen) {
    		System.out.println("setting lineman name:" + lineman.name + "age:" + lineman.age);
    	}
    }

}