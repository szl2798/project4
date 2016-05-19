
public class Player {
	protected int money = 0;
	private int winAmount = 0, loseAmount = 0;
	private int betType, betNumber;
	protected Chips chip = new Chips();
	private boolean vip;
	
	public Player(int cash, boolean vipStatus)
	{
		money = cash;
		vip = vipStatus;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public Chips getChips()
	{
		return chip;
	}
	
	public boolean isVIP()
	{
		return vip;
	}
	
	public void buyIn(Chips tableChips)
	{
		if (money >= 100)
		{
			chip.buy(tableChips);
			money -= 100;
		}
	}
	
	public int getChipsValue(){
		return chip.value();
	}
	
	public String toString()
	{
		return "Not VIP\tCash: $" + money + "\tChip value: $" + chip.value() + "\n";
	}
	
}
