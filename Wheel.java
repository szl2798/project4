// Class Wheel for CSCI 145 Project 2 Spring 16
// Modified by:

//************************************************************************
//   Class Wheel represents a roulette wheel and its operations.  Its
//   data and methods are static because there is only one wheel.
//************************************************************************
import java.util.Random;

class Wheel
{
    // public name constants -- accessible to others
    public final static int BLACK     =  0;			// even numbers
    public final static int RED       =  1;			// odd numbers
    public final static int GREEN     =  2;			// 00 OR 0
    public final static int NUMBER    =  3;			// number bet
    public final static int MIN_NUM   =  1;			// smallest number to bet
    public final static int MAX_NUM   = 36;			// largest number to bet
    
    // private name constants -- internal use only
    private final static int MAX_POSITIONS = 38;	// number of positions on wheel
    private final static int NUMBER_PAYOFF = 35;	// payoff for number bet
    private final static int COLOR_PAYOFF  = 2;		// payoff for color bet

    // private variables -- internal use only
    private static int ballPosition;				// 00, 0, 1 .. 36
    private static int color;						// GREEN, RED, OR BLACK
    private static int houseBalance = 0;

    //=====================================================================
    //  Presents welcome message
    //=====================================================================
    public static void welcomeMessage()
    {
      	System.out.println("Welcome to a simple version of roulette game.");
      	System.out.println("You can place a bet on black, red, or a number.");
      	System.out.println("A color bet is paid " + COLOR_PAYOFF + " the bet amount.");
      	System.out.println("A number bet is paid " + NUMBER_PAYOFF + " the bet amount.");
      	System.out.println("Have fun and good luck!\n");
    }

    //=====================================================================
    //  Presents betting options
    //=====================================================================
    public static void betOptions()
    {
      	System.out.println("Betting Options:");
      	System.out.println("    1. Bet on black");
      	System.out.println("    2. Bet on red");
      	System.out.println("    3. Bet on a number between " + MIN_NUM + " and " + MAX_NUM);
      	System.out.print("What is your choice? ");
    }
    
    //=====================================================================
    //  Spins the wheel
    //=====================================================================
    public static void spin()
    {
    	Random rand = new Random();
    	ballPosition = rand.nextInt(MAX_POSITIONS) + 1;
    	// Test number pay
    	// ballPosition = 10;
    	System.out.print("=============================\nThe ball landed on ");
    	if (ballPosition == 37)
    	{
    		color = GREEN;
    		System.out.println("0 (Green)");
    	}
    	else if (ballPosition == 38)
    	{
    		color = GREEN;
    		System.out.println("00 (Green)");
    	}
    	else if (ballPosition % 2 == 0)
    	{	
    		color = BLACK;
    		System.out.println(ballPosition + " (Black)");
    	}
    	else
    	{
    		color = RED;
    		System.out.println(ballPosition + " (Red)");
    	}
    	System.out.println("=============================");
    }
    
    //=====================================================================
    //  Calculates payoff
    //=====================================================================
    public static int payOff(int amount, int type, int num)
    {
    	if (type == 3 && num == ballPosition)
    		return NUMBER_PAYOFF * amount;
    	else if (type == 1 && color == BLACK)
    		return COLOR_PAYOFF * amount;
    	else if (type == 2 && color == RED)
    		return COLOR_PAYOFF * amount;
    	else
    		return 0;
    }
    
    //=====================================================================
    //  Set house balance
    //=====================================================================
    public static void updateHouseBalance(int a)
    {
    	houseBalance += a;
    }
    
    //=====================================================================
    //  Get house balance
    //=====================================================================
    public static int getHouseBalance()
    {
    	return houseBalance;
    }
    
    public String toString(){
    	String result = "=============================\nThe ball landed on ";
    	if (ballPosition == 37)
    	{
    		result += "0 (Green)";
    	}
    	else if (ballPosition == 38)
    	{
    		result +="00 (Green)";
    	}
    	else if (ballPosition % 2 == 0)
    	{	
    		result += ballPosition + " (Black)";
    	}
    	else
    	{
    		result += ballPosition + " (Red)";
    	}
    	result +="=============================";
    	return result;
    	
    }
}


