

public class calculations {
	
	/**
	 * Test code for the logic methods
	 * @param args
	 */
	/*public static void main(String[] args) {
		//All of our test cases with answers
		int [][] bearingRadial = new int [][]{
				{160, 270, 10, -1},
				{270, 160, -10, -1},
				{280, 50, 10, -1},
				{50, 280, -10, -1},
				{50, 120, 10, 1},
				{120, 50, -10, 1},
				{280, 340, 10, 1},
				{340, 280, -10, 1},
				{30, 150, 10, -1},
				{150, 30, -10, -1},
				{280, 350, 10, 1},
				{350, 280, -10, 1},
				{150, 30, -10, -1},
				{30, 150, 10, -1},
				{355, 5, 10, 1},
				{5, 355, -10, 1},
				{280, 284, 4, 1},
				{50, 47, -3, 1},
				{359, 2, 3, 1},
				{2, 359, -3, 1}
		};
		
		/*
		 * Calls the deflection and toFrom methods for each test case and compares the returned
		 * values to the answer values in the array.
		 */
		
		/*for (int i = 0; i<bearingRadial.length; i++){
			int deflect = deflection(bearingRadial[i][0], bearingRadial[i][1]);
			int tf = toFrom(bearingRadial[i][0], bearingRadial[i][1], true);
			if (bearingRadial[i][2]==deflect && bearingRadial[i][3]==tf){
				System.out.println("Bearing: "+bearingRadial[i][0] +" Radial: "+bearingRadial[i][1]+" Deflection: "+deflect+" TO/FROM: "+tf+ " PASS");
			} else {
				System.out.println("Bearing: "+bearingRadial[i][0] +" Radial: "+bearingRadial[i][1]+" Deflection: "+deflect+" TO/FROM: "+tf+ " FAIL");
			}
		}
	}*/
	
	/**
	 *This method calculates the deflection of the needle on the VOR by calculating the difference
	 *between the OBS bearing and the intercepted radial from the VOR station.  
	 * @param bearing this is the bearing entered by the pilot
	 * @param vor this is the radial intercepted from the VOR station
	 * @return a number between -10 and 10 which is the deflection of the needle
	 */
	public static int deflection(int bearing, int vor){
        //First step is to subtract the radial from the bearing
		int total = bearing - vor;
		
		/*
		 * This block of code catches cases where the radial and bearing are within 10
		 * of each other, but across the 0 on the compass (ex. 355 and 3). Since this
		 * is the only time the difference between the numbers will be >350 or <-350
		 * we check for that and then take the compliment, which is the deflection.
		 * This is returned.
		 */
        if (total > 350 || total < -350){
        	if (total<0){
        		return (360 + total) * -1;
        	} else {
        		return 360-total;
        	}
        }
        
        /*
         * This catches all the cases where the radial and the bearing are less 
         * then 20 degrees apart. Before the value is returned its sign is 
         * reversed to account for the direction of the deflection.
         */
        if (total  > -10 && total < 10){
        	return total *-1;
        }
        
        /*
         * This block of code takes the compliment of the total when the bearing is less then
         * the radial.
         */
        if (bearing < vor){
        	if (total<0){
        		total = 360 + total;
        	} else {
        		total = 360-total;
        	}
        }
        
        /*
         * Cuts the numbers down to either 10 or -10 if the total difference between 
         * the bearing and the signal is greater than that.
         */
        if (total < 180 && total > 0){
        	return -10;
        } else {
        	return 10;
        }
	}
	
	/**
	 * This method calculates whether the plane is heading towards the VOR station or away 
	 * from it.
	 * @param bearing The bearing entered by the pilot
	 * @param vor The radial intercepted from the VOR station
	 * @param signal A boolean specifying whether the signal is good or bad
	 * @return
	 */
	public static int toFrom(int bearing, int vor, boolean signal){
        int b = 360 - bearing;
        int v = 360 - vor;
        int total = 0;
        if(b > v){
            total = b - v;
        }else{
            total = v - b;
        }
        if(total > 180){
            total = 360 - total;
        }
        if(signal == false){
            return 0;
        }
        else if((total >= 89 && total <=91) || (total >= 269 && total <= 271)){
            return 0;
        } else if (total > 90){
            return -1;
        } else {
        	return 1;
        }
    }
}
