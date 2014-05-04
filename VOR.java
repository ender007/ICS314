/*
 * ICS 314 VOR Program
 * YEAR: Spring '14
 * AUTHORS: Myles Enriquez, Anthony Betzina, Joshua Sutherland
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class VOR {
	JFrame frame;
	
	public VOR(int bearing, int vor){
		frame = new JFrame("VOR");//frame that contains 'panel'
		JPanel GLpanel = new JPanel();//panel with a grid layout(GL)
		JPanel BLpanel = new JPanel();//panel with a border layout(BL)
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		TitledBorder radialTitle;
		TitledBorder signalTitle;
		
		//calling calculations.java to access deflection()
		//calculations calc = new calculations();
        int deflect = calculations.deflection(bearing, vor);
        
        int x = calculations.toFrom(bearing, vor, true);
        
        String tf = "";
        if(x == 0){
            tf = "BAD";
        }
        else if(x == -1){
            tf = "FROM";
        }
        else{
            tf = "TO";
        }
		
		/*Two main displays that the GUI has:
		 *the radial label which displays the radial
		 *the signal label which displays the signal
		 *the image label which displays an image of the deflected needle
		 */
		String strRad = String.valueOf(vor);
		JLabel radial = new JLabel(strRad);
		JLabel signal = new JLabel(tf);
		JLabel image = new JLabel();
		
		//All the images that will be used, from range -10 to 10
		//I'm importing them directly from the "images" folder which is in the same directory
		ImageIcon negTen = new ImageIcon(this.getClass().getResource("/images/neg10.png"));
		ImageIcon negEight = new ImageIcon(this.getClass().getResource("/images/neg8.png"));
		ImageIcon negSix = new ImageIcon(this.getClass().getResource("/images/neg6.png"));
		ImageIcon negFour = new ImageIcon(this.getClass().getResource("/images/neg4.png"));
		ImageIcon negTwo = new ImageIcon(this.getClass().getResource("/images/neg2.png"));
		ImageIcon zero = new ImageIcon(this.getClass().getResource("/images/zero.png"));
		ImageIcon ten = new ImageIcon(this.getClass().getResource("/images/pos10.png"));
		ImageIcon eight = new ImageIcon(this.getClass().getResource("/images/pos8.png"));
		ImageIcon six = new ImageIcon(this.getClass().getResource("/images/pos6.png"));
		ImageIcon four = new ImageIcon(this.getClass().getResource("/images/pos4.png"));
		ImageIcon two = new ImageIcon(this.getClass().getResource("/images/pos2.png"));
		
		
		
		
		//checking to see what was entered for deflection and setting image on label
		if(x == 0){
			image.setIcon(zero);
		} else if(deflect == 0){
			image.setIcon(zero);
		} else if(deflect < -8){
			image.setIcon(ten);
		} else if(deflect >= -8 && deflect < -6){
			image.setIcon(eight);
		} else if(deflect >= -6 && deflect < -4){
			image.setIcon(six);
		} else if(deflect >= -4 && deflect < -2){
			image.setIcon(four);
		} else if(deflect >= -2 && deflect < 0){
			image.setIcon(two);
		} else if(deflect > 0 && deflect <= 2){
			image.setIcon(negTwo);
		} else if(deflect > 2 && deflect <= 4){
			image.setIcon(negFour);
		} else if(deflect > 4 && deflect <= 6){
			image.setIcon(negSix);
		} else if(deflect > 6 && deflect <= 8){
			image.setIcon(negEight);
		} else if(deflect > 8){
			image.setIcon(negTen);
		} else{
			System.err.print("restart program, error handling not yet implemented");
		}
		
		//setting a border for the radial label
		radialTitle = BorderFactory.createTitledBorder(loweredbevel, "RADIAL");
		radialTitle.setTitlePosition(TitledBorder.ABOVE_TOP);
		radial.setBorder(radialTitle);
		
		//setting a border for the signal label
		signalTitle = BorderFactory.createTitledBorder(loweredbevel, "SIGNAL");
		signalTitle.setTitlePosition(TitledBorder.ABOVE_TOP);
		signal.setBorder(signalTitle);
	
		BLpanel.setLayout(new BorderLayout());
		
		GLpanel.setLayout(new GridLayout(1, 2, 2, 2));//GridLayout(rows, columns, hgap, vgap)	
		GLpanel.add(radial);
		GLpanel.add(signal);
		
		frame.add(BLpanel);
		BLpanel.add(GLpanel, BorderLayout.NORTH);
		BLpanel.add(image, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.pack();
		frame.setSize(405,200);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.validate();
		frame.setLocationRelativeTo(null);
	}
	
	public void kill(){
		frame.dispose();
	}
	
	
	
}
