public class Chips {
	private int chip1, chip5, chip25, chip100, money;
	
	public Chips(int hundreds, int twentyFives, int fives, int ones) //Constructor for table
	{
		chip100 = hundreds;
		chip25 = twentyFives;
		chip5 = fives;
		chip1 = ones;
		money = chip100 * 100 + chip25 * 25 + chip5 * 5 + chip1 * 1;
	}
	
	public Chips(Chips tableChips) //Constructor for player (buy-in)
	{
		chip100 = 0;
		if (tableChips.chip25 >= 2 && tableChips.chip5 >= 5 && tableChips.chip1 >= 25) //No conversion of chip, just straight up chip to chip transfer)
		{
			chip25 = 2;
			chip5 = 5;
			chip1 = 25;
			tableChips.chip25 -= 2;
			tableChips.chip5 -= 5;
			tableChips.chip1 -= 25;
			money = chip100 * 100 + chip25 * 25 + chip5 * 5 + chip1 * 1;
		}
		else
		{
			chip25 = 0;
			chip5 = 0;
			chip1 = 0;
			money = 0;
		}
	}
	
	public void update()
	{
		money = chip100 * 100 + chip25 * 25 + chip5 * 5 + chip1 * 1;
	}
	
	public int value()
	{
		return money;
	}
	
	public void pay(Chips tableChips, int amount) //Pays player <amount>, takes <amount> from table
	{
		int dollars = amount, temp;
		if (tableChips.money >= dollars)
		{
			temp = dollars / 100;
			if (tableChips.chip100 >= temp)
			{
				chip100 += temp;
				tableChips.chip100 -= temp;
				dollars -= temp * 100;
			}
			temp = dollars / 25;
			if (tableChips.chip25 >= temp)
			{
				chip25 += temp;
				tableChips.chip25 -= temp;
				dollars -= temp * 25;
			}
			temp = dollars / 5;
			if (tableChips.chip5 >= temp)
			{
				chip5 += temp;
				tableChips.chip5 -= temp;
				dollars -= temp * 5;
			}
			chip1 += dollars;
			tableChips.chip1 -= dollars;
			update();
			tableChips.update();
		}
	}
	
	public void take(Chips tableChips, int amount) //Takes from player <amount>, give <amount> to table
	{
		int dollars = amount, temp;
		if (money >= dollars)
		{
			temp = dollars / 100;
			if (chip100 >= temp)
			{
				chip100 -= temp;
				tableChips.chip100 += temp;
				dollars -= temp * 100;
			}
			temp = dollars / 25;
			if (chip25 >= temp)
			{
				chip25 -= temp;
				tableChips.chip25 += temp;
				dollars -= temp * 25;
			}
			temp = dollars / 5;
			if (chip5 >= temp)
			{
				chip5 -= temp;
				tableChips.chip5 += temp;
				dollars -= temp * 5;
			}
			chip1 -= dollars;
			tableChips.chip1 += dollars;
			update();
			tableChips.update();
		}
	}
	
}
