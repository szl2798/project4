
public class VipPlayer extends Player{
	
	private final int id;
	private String name;
	private final double vipReward = 1.05;
	
	public VipPlayer(int cash, boolean vipStatus, int playerID, String playerName)
	{
		super(cash, vipStatus);
		id = playerID;
		name = playerName;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getVipReward()
	{
		return vipReward;
	}
	public String toString()
	{
		return name + " VIP\tCash: $" + money + "\tChip value: $" + chip.value() + "\n";
	}
}
