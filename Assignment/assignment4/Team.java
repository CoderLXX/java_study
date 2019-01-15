public class Team {
	// Find two soccer teams, each team shall have one head coach, 
	// one or more assistant coach, 
	// 11 players and at least 3 substitutes

	String teamName;
	boolean isHomeTeam;
    Coach headCoach;
    Coach[] assisCoachs;
    Player[] players;
    Player[] substitutes;

    // Data
    String[] teamNames;
    String[] headCoachNames;
    String assisCoachNames[][];
    int[] coachAges;
    int[] champions;
    String playersNameData[][];
    String[] positions;
    int[] numbers;
    int[] ages;
    float[] heights;

    public Team() {
        // this.loadTeamsData();
    } 

    public Team(String curTeamName, boolean isHomeTeam) {
    	this.isHomeTeam = isHomeTeam;
    	this.loadTeamsData();
    	this.teamName = curTeamName;
    	int index = printArray(teamNames, curTeamName);
        
    	System.out.println("you have selected " + curTeamName);

    	// Coach
    	this.headCoach = new Coach(headCoachNames[index], coachAges[index], champions[index], true);
    	System.out.println("headCoach------" + headCoach.name);
    	this.assisCoachs = new Coach[assisCoachNames[index].length];
    	for (int i = 0; i < assisCoachNames[index].length; i++) {
    		Coach assisCoach = new Coach(assisCoachNames[index][i], coachAges[i], champions[i], false);
    		assisCoachs[i] = assisCoach;
	    	System.out.println("assisCoach------" + assisCoach.name);
    	}

    	// Player
    	this.players = new Player[11];
    	this.substitutes = new Player[playersNameData[index].length - 11];
    	for (int i = 0; i < playersNameData[index].length; i++) {
    		Player player = new Player(playersNameData[index][i], numbers[i], ages[i], heights[i], positions[i]);
    		if (i < 11) {
    			players[i] = player;
    		}
    		else {
    			substitutes[i - 11] = player;
    		}
	    	System.out.println("player------" + player.name);
    	}
    } 

	private static int printArray(String[] array,String value){
		for(int i = 0;i<array.length;i++){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}


	private void loadTeamsData() {

	String loadingText;
	String jerseyColor;
	if (this.isHomeTeam) {
		loadingText = "We're loading HomeTeam Data...";
		jerseyColor = "HomeTeam's jersey color is red";
	} 
    else {
    	loadingText = "We're loading VisitingTeam Data...";
    	jerseyColor = "VisitingTeam's jersey color is blue";
    }

	System.out.println(loadingText);
	System.out.println(jerseyColor);
    // Data
    this.teamNames = new String[]{"Real Madrid", "Barcelona", 
					    "Manchester United", "Chelsea", 
					    "Juventus", "AC Milan"};
    this.headCoachNames = new String[]{"José Villalonga", "	Frank Rijkaard",
					    "Alex Ferguson", "Roberto Di Matteo",
					    "Marcello Lippi", "Arrigo Sacchi"};
    this.assisCoachNames = new String[][]{{"Join", "Peter"}, {"Matteo"},
						    {"Jeremy", "Tom"}, {"Joshua"},
							{"Jachin", "Tomash", "Curry"}, {"James"}};
    this.coachAges = new int[]{41, 43, 52, 30, 38, 29, 60, 53, 36, 58, 48};
    this.champions = new int[]{2, 3, 0, 1, 2, 2, 3};

    // players
    this.playersNameData = new String[][]{{"Casemiro", "Fede Valverde",
				"Lucas Vázquez", "Marcos Llorente","Álvaro Odriozola",
				"Marco Asensio", "Brahim Díaz", "Isco",
				"Sergio Reguilón", "Dani Ceballos", "Thibaut Courtois", 
				"Vinícius Júnior", "Luca Zidane"},
				{"Brahim Díaz", "Isco",
				"Sergio Reguilón", "Dani Ceballos", "Thibaut Courtois", 
				"Vinícius Júnior", "Casemiro", "Fede Valverde",
				"Lucas Vázquez", "Marcos Llorente","Álvaro Odriozola",
				"Marco Asensio", "Luca Zidane"},
				{"Brahim Díaz", "Isco",
				"Sergio Reguilón", "Fede Valverde",
				"Lucas Vázquez", "Dani Ceballos", "Thibaut Courtois", 
				"Vinícius Júnior", "Casemiro", "Marcos Llorente","Álvaro Odriozola",
				"Marco Asensio", "Luca Zidane"}, 
				{"Luca Zidane", "Brahim Díaz", "Isco", "Dani Ceballos", 
				"Sergio Reguilón", "Fede Valverde",
				"Lucas Vázquez", "Thibaut Courtois", 
				"Vinícius Júnior", "Casemiro", "Marcos Llorente","Álvaro Odriozola",
				"Marco Asensio"},
				{"Thibaut Courtois", "Luca Zidane", "Brahim Díaz", "Isco", "Dani Ceballos", 
				"Sergio Reguilón", "Fede Valverde",
				"Lucas Vázquez",  
				"Vinícius Júnior", "Casemiro", "Marcos Llorente","Álvaro Odriozola",
				"Marco Asensio"},
				{"Vinícius Júnior", "Casemiro", "Marcos Llorente","Álvaro Odriozola",
				"Marco Asensio","Thibaut Courtois", "Luca Zidane", "Brahim Díaz", "Isco", "Dani Ceballos", 
				"Sergio Reguilón", "Fede Valverde",
				"Lucas Vázquez"}
			};

	this.positions = new String[]{"MF", "FW", "DF", "GK", "FW", "DF", "GK","FW", "DF", "GK", "FW", "DF", "GK", "FW", "DF", "GK"};

    this.numbers = new int[]{1, 3, 2, 4, 11, 30, 21, 23, 24, 17, 19, 12, 10, 9};

    this.ages = new int[]{21, 23, 22, 20, 18, 19, 30, 33, 26, 28, 28, 29, 25, 24};

    this.heights = new float[]{177.21f, 189.00f, 188.11f, 189.41f, 192.01f, 188.09f, 198.41f, 178.89f, 185.87f, 183.00f, 196.56f, 188.11f, 183.00f, 196.56f};

	}
}