package rover;

//rover Move forward
public class Move {

	private Position position;
	private int maxX;
	private int maxY;

	Move (int x, int y, Position position){
		this.position = position;
		this.maxX = x;
		this.maxY = y;
	}

	public boolean  moveForward() {
		char cPoint = position.getcPoint();
		int x = position.getX();
		int y = position.getY();
		switch (cPoint) {
		case 'N'->y+=1;
		case'E'->x+=1;
		case'S'->y-=1;
		case 'W'-> x-=1;
		default -> throw new IllegalStateException("Unexpected value: " + cPoint);
		}

		if(x>=0 && x<=maxX && y>=0 && y<=maxY) {
			position.setX(x);
			position.setY(y);
			return true;
		}
		System.out.println("\nError !!\n ");
		System.out.println("\nIndex Out of grid !!\n ");
		return false;
	}
}
