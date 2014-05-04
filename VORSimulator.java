/*
 * ICS 314 VOR Program
 * YEAR: Spring '14
 * AUTHORS: Myles Enriquez, Anthony Betzina, Joshua Sutherland
 */

import javax.swing.JOptionPane;

public class VORSimulator {

	/**
	 * Main method which runs the gui
	 */
	public static void main(String[] args) {
		//Decided to use dialogs to test with manually generated input, we can change to scanner if we want
		String strDeflection = JOptionPane.showInputDialog("Enter OBS (On Board Setting)");
		String fromOrTo = JOptionPane.showInputDialog("Enter direction: 'TO' or 'FROM'");
		String radial = JOptionPane.showInputDialog("Enter radial");
		
		//parsing deflection and radial into an int
		int deflection = Integer.parseInt(strDeflection);
		int rad = Integer.parseInt(radial);
		
		/*
		 * VOR() requires 3 params
		 * rad = radial which will be generated
		 * fromOrTo = direction of plane ex. TO or FROM
		 * deflection = how much the needle will deflect ex. -10 which is all to the left, 0 which is center, 10 which is all to the right
		 * 
		 * IMPORTANT: Our methods will feed this contructor, everthing above this construtor
		 * is just for testing.
		 */
		new VOR(rad, fromOrTo, deflection);

	}

}
