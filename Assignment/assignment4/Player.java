public class Player {
	// Each player should have his name, 
	// number, age, height(in cm), 
	// position(Forward, Midfielder, Defender, Goalie) in the field
	String name;
	int number;
	int age;
	float height;
	String position;

	public Player() {

	}
	
	public Player(String name, int number, int age, float height, String position) {
		this.name = name;
		this.number = number;
		this.age = age;
		this.height = height;
		this.position = position;
	}
}