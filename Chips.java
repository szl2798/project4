public class Chips {
	private int chip1, chip5, chip25, chip100;

	
	public Chips(int hundreds, int twentyFives, int fives, int ones) //Constructor for table
	{
		chip100 = hundreds;
		chip25 = twentyFives;
		chip5 = fives;
		chip1 = ones;

	}
	
	public Chips() //Constructor for player
	{
		chip100 = 0;
		chip25 = 0;
		chip5 = 0;
		chip1 = 0;
	}
	
	public int value()
	{
		return chip100 * 100 + chip25 * 25 + chip5 * 5 + chip1 * 1;
	}
	
	public void pay(Chips tableChips, int amount) //Pays player <amount>, takes <amount> from table
	{
		int amountLeft = amount, count;
		if (tableChips.value() >= amount)
		{
			for (count = amountLeft / 100; count > 0; count--)
				if (tableChips.chip100 > 0)
				{
					tableChips.chip100--;
					chip100++;
					amountLeft-= 100;
				}
			for (count = amountLeft / 25; count > 0; count--)
				if (tableChips.chip25 > 0)
				{
					tableChips.chip25--;
					chip25++;
					amountLeft-= 25;
				}
			for (count = amountLeft / 5; count > 0; count--)
				if (tableChips.chip5 > 0)
				{
					tableChips.chip5--;
					chip5++;
					amountLeft-= 5;
				}
			chip1+= amountLeft;
			tableChips.chip1-= amountLeft;
		}
	}
	
	public void take(Chips tableChips, int amount) //Takes from player <amount>, give <amount> to table
	{
		int amountLeft = amount, count;
		if (value() >= amount)
		{
			for (count = amountLeft / 100; count > 0; count--)
				if (chip100 > 0)
				{
					tableChips.chip100++;
					chip100--;
					amountLeft-= 100;
				}
			for (count = amountLeft / 25; count > 0; count--)
				if (chip25 > 0)
				{
					tableChips.chip25++;
					chip25--;
					amountLeft-= 25;
				}
			for (count = amountLeft / 5; count > 0; count--)
				if (chip5 > 0)
				{
					tableChips.chip5++;
					chip5--;
					amountLeft-= 5;
				}
			chip1-= amountLeft;
			tableChips.chip1+= amountLeft;
		}
	}
	
	public void buy(Chips tableChips)
	{
		if (tableChips.chip25 >= 2 && tableChips.chip5 >= 5 && tableChips.chip1 >= 25) //No conversion of chip, just straight up chip to chip transfer)
		{
			chip25 += 2;
			chip5 += 5;
			chip1 += 25;
			tableChips.chip25 -= 2;
			tableChips.chip5 -= 5;
			tableChips.chip1 -= 25;
		}
	}
	
	public String toString()
	{
		return Integer.toString(chip100) + " " + Integer.toString(chip25) + " " + Integer.toString(chip5) + " " + Integer.toString(chip1);
	}
}
