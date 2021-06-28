package rover;

public class Position {

	private int x;
	private int y;
	private char cPoint;

	Position(int x, int y, char cPoint){
		this.x =x;
		this.y =y;
		this.cPoint = cPoint;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getcPoint() {
		return cPoint;
	}

	public void setcPoint(char cPoint) {
		this.cPoint = cPoint;
	}


	//Print current position
	public void printPosition() {
		System.out.println("\n---------------------Out Put-------------------------\n");
		System.out.printf("Final destination :%d %d %c \n",getX(),getY(),getcPoint());

	}

}
