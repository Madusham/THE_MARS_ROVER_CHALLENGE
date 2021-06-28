package rover;

import java.util.Scanner;

public class Main {
	private static int maxX, maxY, cX, cY;
	private static char cPoint;

	public static void main(String[] args) {

		String teminate = " ";
		boolean check=true;

		System.out.println("------------------------------------------------");
		System.out.println("______Welcome Project Mars Rover_______");
		System.out.println("------------------------------------------------\n");

		System.out.println("--Enter upper-right coordinates of the plateau :\n (Ex:5 5)");
		Scanner scan = new Scanner(System.in);

		InputValidator validator = new InputValidator();

		do {
			try {
				String uCoordinates = scan.nextLine().trim();

				if(validator.validateInput(uCoordinates, "^[0-9]+\s+[0-9]+\s*.*")) {
					String[] uVals = uCoordinates.split(" ");
					// maxX and maxY represent upper right coordinates
					maxX = Integer.parseInt(uVals[0]);
					maxY = Integer.parseInt(uVals[1]);
					check = false;
				}
				else {
					System.out.println("Please enter correct order and Try again\n(Ex:5 5)");
				}

			}
			catch(Exception e) {
				System.out.println("Errow" + e);
				System.out.println("Please enter correct order and Try again\n(Ex:5 5)");
			}
		}while(check);

		do {
			check =true;
			System.out.println("\n --Enter rover’s current position :\n (Ex:5 5 N)");
			System.out.println(" N => North\n E => East\n S => Souht\n W => West");
			do {
				try {
					String cPosition = scan.nextLine().trim();
					
	
					//String reg = "^[0-" + Integer.toString(maxX) + "]+\s[0-" + Integer.toString(maxY) + "]+\s[NESW]";
					if(validator.validateInput(cPosition,"^[0-9]+\s[0-9]+\s[NESW]" )) {
						String[] cVals = cPosition.split(" ");
						//current coordinates and compass point of rover
						cX = Integer.parseInt(cVals[0]);
						cY = Integer.parseInt(cVals[1]);
						cPoint = Character.toUpperCase(cVals[2].charAt(0));
						
						if(validator.checkRange(maxX, maxY, cX, cY)) {
							check=false;
						}
						else {
							System.out.printf("Grid out of limit. please try again(Ex:Maximum X - %s Maximum Y - %s N)\n",maxX,maxY);
						}
					}
					else {
						System.out.println("Please enter correct order and Try again\n(Ex:5 5 N)");
					}

				}
				catch (Exception e) {
					System.out.println("Errow" + e);
					System.out.println("Please enter correct order and Try again\n(Ex:5 5 N)\n");
				}

			}while(check);


			check = true;
			Position current = new Position(cX,cY,cPoint);
			//current.printPosition();
			System.out.println("\n--Enter instructions to explore the plateau:\n (Ex:RMLMM N)\n");
			System.out.println("\n R => Turn Right\n L => Turn Left\n M => Move Forward");
			do {
				try {
					String instruction = scan.nextLine().trim().toUpperCase();

					if(validator.validateInput(instruction, "^[RML]+")) {
						for (char ch: instruction.toCharArray()) {
							if (ch=='M') {
								Move move = new Move(maxX, maxY, current);
								boolean con =move.moveForward();
								//check whether grid is out of bound or not
								if(!con) {
									break;
								}
							}
							else {
								char rSide = (ch =='R')?'R':'L';
								Rotate rotate = new Rotate(rSide);
								char cc = rotate.rotateRover(current.getcPoint());
								current.setcPoint(cc);

							}

						}
						check = false;
					}
					else {
						System.out.println("Please enter correct order and Try again\n(Ex:RLMM)\n");
					}
				}
				catch (Exception e) {
					System.out.println("Errow" + e);
					System.out.println("Please enter correct order and Try again\n(Ex:RLMM)\n");
				}


			}while(check);


			//print the output here
			current.printPosition();

			System.out.println("--Do you want to continue (Y/N) :\n");
			teminate = scan.nextLine();

		}while (teminate.equalsIgnoreCase("Y"));
		
		scan.close();
		System.out.println("\n---------------------Thank You !-------------------------\n");


	}

}
