/*
 * ICS 314 VOR Program
 * YEAR: Spring '14
 * AUTHORS: Myles Enriquez, Anthony Betzina, Joshua Sutherland
 */

import java.util.*;

public class VORSimulator {

	/**
	 * Main method which runs the gui
	 */
	public static void main(String[] args) {
		try{
		boolean x = true;
		String loop = "";
		String b = "";
	    String v = "";
	    int bearing = 0;
	    int vor = 0;
		Scanner scan = new Scanner(System.in);

		while(!(loop.equals("n"))){	
			while(x){
				//Scanner
				scan = new Scanner(System.in);
		        System.out.println("Enter in your OBS (On Board Setting) Must be a # 0-359");
		        b = scan.nextLine();
		        System.out.println("Enter in your VOR Radial : Must be a # 0-359");
		        v = scan.nextLine();
		        //System.out.println("Enter if the signal is good or bad");
		        //s = scan.nextLine();
		        
				//parsing deflection and radial into an int
				bearing = Integer.parseInt(b);
				vor = Integer.parseInt(v);
			
				if(bearing < 0 || bearing > 359 || vor < 0 || vor > 359){
				System.out.println("Please try again");
				}
				else{
					x = false;
				}		
			}
			/*
			 * VOR() requires 2 params
			 * rad = radial which will be generated
			 * fromOrTo = direction of plane ex. TO or FROM
			 * deflection = how much the needle will deflect ex. 
			 * -10 which is all to the left, 0 which is center, 10 which is all to the right
			 */
	
			VOR gui = new VOR(bearing, vor);
			System.out.println("Enter 'n' to close or any key to continue");
			loop = scan.nextLine();
			loop.trim();
			gui.kill();
			x = true;
		}
		}catch(NumberFormatException e){
			System.out.println("You didn't enter any number");
		}
	}

}
