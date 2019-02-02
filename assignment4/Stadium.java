public class Stadium {
	int width;
	int length;
	String name;

	public Stadium() {
        this.width = 68;
        this.length = 105;
        this.name = "San Siro";
    }

    public Stadium(String name) {
        this.width = 68;
        this.length = 105;
        this.name = name;
        System.out.println("you have selected " + name + "stadium");
    }
}