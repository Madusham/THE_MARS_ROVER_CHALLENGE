package rover;

public class Rotate {
	
	//private char cPoint;
	private char rSide;
	
	Rotate (/*char point,*/ char rSide){
		//this.cPoint = point;
		this.rSide = rSide;
	}
	
	//here generate a int value for compass point
	public int setCPointVal(char cPoint) {
		return switch(cPoint) {
			case('N')->0;
			case('E')->1;
			case('S')->2;
			case('W')->3;
			default -> throw new IllegalStateException("Unexpected value: " + cPoint);
		};
	}
	
	//here int value convert to compass point symbol
	public char setCPoint(int val) {
		val = val % 4;
		return switch(val) {
			case(0)->'N';
			case(1)->'E';
			case(2)->'S';
			default ->'W';
		};
	}
	
	//Return new pointer
	public char rotateRover(char cPoint) {
		int val = setCPointVal(cPoint);
		
		switch(rSide) {
		case ('R')->val += 1;
		case('L')->val-=1;
		default -> throw new IllegalStateException("Unexpected value: " + rSide);
		}
			
		return (setCPoint(val));
	}
}
