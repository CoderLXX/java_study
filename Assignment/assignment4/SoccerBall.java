public class SoccerBall {
	
	int ballNum;
	String color;
	float size;
	float location;
	

	public SoccerBall() {
        this.ballNum = 1;
	}

	public SoccerBall(int ballNum) {
		if (ballNum < 1) {
			throw new IllegalArgumentException("SoccerBall number must be equal 1 or more than 1");
		}
		this.ballNum = ballNum;
		System.out.println("We have prepare " + ballNum + " Size 5 soccer ball for you");
	}
}