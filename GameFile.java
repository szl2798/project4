import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class GameFile {
	private static String gameVersion;
	
	public static void load(ArrayList<Game> availGames, ArrayList<Player> availPlayers) throws IOException
	{
		Scanner fileScan = new Scanner(new File("games.txt"));
		Chips tableChips;
		int money;
		char vip;
		gameVersion = fileScan.next();
		int count = fileScan.nextInt();
		for (int i = 1; i <= count; i++)
			availGames.add(new Game(gameVersion + Integer.toString(i), fileScan.nextInt(), fileScan.nextInt(), tableChips = new Chips(fileScan.nextInt(),fileScan.nextInt(),fileScan.nextInt(),fileScan.nextInt())));
		fileScan = new Scanner(new File("players.txt"));
		while (fileScan.hasNextLine())
		{
			vip = fileScan.next().charAt(0);
			money = fileScan.nextInt();
			if (vip == 'N')
				availPlayers.add(new Player(money, false));
			else if (vip == 'Y')
				availPlayers.add(new VipPlayer(money, true, fileScan.nextInt(), fileScan.next() + " " + fileScan.next()));
		}
		fileScan.close();
	}
	
	/*public static void write(Game gameToBeLogged) throws IOException
	{
		FileWriter fileWrite = new FileWriter(new File("log.txt"));
		fileWrite.write(gameToBeLogged.gameInfo() + "\n");
		for (transaction i : gameToBeLogged.getTransactions())
			fileWrite.write(i + "\n");
		fileWrite.write(gameToBeLogged.balanceReport() + "\n");
		fileWrite.close();
	}
	
	public static String getVersion()
	{
		return gameVersion;
	}*/
}
