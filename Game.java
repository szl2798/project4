import java.util.ArrayList;

public class Game {
	private String gameId;
	private int minBet , maxBet;
	private final int maxPlayers = 4;
	private int currentRound;
	private int cash;
	private ArrayList transaction = new ArrayList<Transaction>();
	private ArrayList players = new ArrayList<Player>();
	private int houseWins;
	private int houseLoses;
	private Wheel wheel;
	private Chips chips;
	
	public Game(String id, int minimumBet, int maximumBet, Chips chips ){
		gameId = id;
		minBet = minimumBet;
		maxBet = maximumBet;
		this.chips = chips;
		cash = 0;

		
	}
	
	public String getGameId(){
		return gameId;
	}
	
	public int getMaxBet(){
		return maxBet;
	}
	
	public int getMinBet(){
		return minBet;
	}

	public int currentPlayers(){
		return players.size();
	}
	
	public String getWheelPosition(){
		return wheel.toString();
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void getSeatInfo(int seat){
		System.out.print(players.get(seat-1));
	}
	//loops through the players and see if they don't have chips
	//and make them buy if they don't have
	public void anyBuyins(){
		
		for(Object i: players.toArray()){
			if(((Player) i).getChipsValue() == 0){
				((Player) i).buyIn(chips);
			}
		}
	}
	
	public int chipsAmount(){
		return chips.value();
	}
	
	public String toString(){
		String result ="";
		result += "The game's id is: " + gameId;
		result += "\nNumber of Players: " + players.size();
		result += "\nCurrent balance of the table is: $" + (chips.value() + cash) + "\n";
		result += chips;
		return result;
		
	}
	public String initialBalance(){
		String result = "";
		result +="Initial Balance of the table: $" + (chips.value() + cash);
		result += chips;
		return result;
	}
	
	public String endingBalance(){
		String result = "";
		result +="Ending Balance of the table: $" + (chips.value() + cash);
		result += chips;
		return result;
	}
	
	public String BalanceReport(){
		String result = "Losing amount for this session is: $" + houseLoses;
		result += "\nWinning amount for this sessionis: $" + houseWins;
		return result;
	}
}
