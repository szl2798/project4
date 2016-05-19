//Folder/Project Name: Project7
//Programmer Name: 
//Date: 
//Class Name: BankingApplication
/*Project Description: 
*/

import java.awt.event.*;   	//for ActionListener
import javax.swing.*;		//for swing components
import java.awt.*;			//for Font
import java.text.*;			//for DecimalFormat class
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Proj4Gui extends JFrame 
	implements ActionListener, ItemListener 
{
	//Available plyers and games
	ArrayList<Game> currentGames;
	ArrayList<Player> currentPlayers;
		
	//temporary starting panel
	JLabel titleLabel = new JLabel ("       Mt. Sac Roulette        ");
	JLabel startArea = new JLabel ("    Initialize games. Please wait ...\n");
	JLabel start1Area = new JLabel("    All games are ready."); 
	JLabel start2Area = new JLabel("    Available games: 100A1, 100A2");
	//added components for first panel	

	String choiceString [] = {"1. Select a Game","2. Add Player to the list","3. Quit"};	
	JLabel companyLabel = new JLabel ("  Main Menu  ");
	JLabel selectLabel = new JLabel ("Please Select an Action: ");
	JComboBox selectComboBox = new JComboBox(choiceString);
	JButton goButton = new JButton("Go");
	JLabel programmerNameLabel = new JLabel ("programmed by Mohammed Khan");
	
	//game type panel
	String[] gameTypeString = {"100A1", "100A2"};
	JComboBox gametypeBox = new JComboBox(gameTypeString);
	JButton typeGoButton = new JButton("Go");
	
	//added components for second panel	
	JLabel companyLabel2 = new JLabel ("     Game Menu      ");
	String gameString[] = {"1. Add a player to the game", "2. Play one round", "3. Return to the main meun"};
	JComboBox gameComboBox = new JComboBox(gameString);
	JButton gameGo = new JButton("Go");
	JButton gameBack = new JButton("Back");
	
	//added components for add panel	
	JLabel companyLabel3 = new JLabel ("       Add Player        ");
	JButton add = new JButton("Add");
	JButton addBack = new JButton("Back");
	JLabel moneyLabel = new JLabel("Enter Starting Amount: ");
	JTextField moneyField = new JTextField(10);
	JCheckBox vipBox = new JCheckBox("VIP");
	JLabel idLabel = new JLabel("Enter VIP ID (4 digits)");
	JTextField idField = new JTextField(4);
	JLabel nameLabel = new JLabel("Enter Full Name (First Last): ");
	JTextField nameField = new JTextField(15);
	
	//Array of JLabels
	JLabel player1 = new JLabel("		Player 1		");
	JLabel player2 = new JLabel("		Player 2		");
	JLabel player3 = new JLabel("		Player 3		");
	JLabel player4 = new JLabel("		Player 4		");
	JLabel[] arrayLabel = {player1, player2, player3, player4};


		
	JPanel tempPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel typePanel = new JPanel();
	JPanel gamePanel = new JPanel();
	JPanel addPanel = new JPanel();
	Font taFont = new Font("Courier", Font.PLAIN, 12);
	Font companyFont = new Font ("Sans Serif", Font.BOLD, 30);
	Font programmerNameFont = new Font ("Sans Serif", Font.ITALIC, 10);
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel[] playersPanel = {panel1, panel2, panel3, panel4};
	
	// instance objects and variables
	DecimalFormat currencyFormat = new DecimalFormat("$0.00");
	
	int lastAccountInteger = -1;
	final int MAX_ACCOUNTS_INTEGER = 9;
	
	String typeString;
	Timer time;
	

	// the main method will create an object of itself and 
	//set the default close operation
	public static void main(String[] args) throws IOException
	{	
		ArrayList<Game> currentGames = new ArrayList<Game>();
		ArrayList<Player> currentPlayers = new ArrayList<Player>();
		GameFile.load(currentGames, currentPlayers); //static call to LoadGame which constructs currentGames and currentPlayers objects
		System.out.println(currentGames);
		System.out.println(currentPlayers);
		
		Proj4Gui myApplication = new Proj4Gui(currentPlayers,currentGames);
		myApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}		
	
	//constructor 
	//call the methods to add components to the multiple panels
	//also sets size and visibility	
	public Proj4Gui(ArrayList<Player> players,ArrayList<Game> games )
	{	
		currentGames = games;
		currentPlayers = players;
		
		designTempPanel();
		designMainPanel();
		designTypePanel();
		designgamePanel();
		designaddPanel();
		add(tempPanel);
		addListeners();		
		setSize(250,250);
		setVisible(true);
		setTitle("Roulette Application");
		time = new Timer();
		time.schedule(new task(), 3 * 1000);
	}	
	class task extends TimerTask
	{
		
		public void run()
		{
			time.cancel();
			remove(tempPanel);
			add(mainPanel);
			setSize(250,250);
			setVisible(true);
		}
	}
	
	public void designTempPanel()
	{
		tempPanel.add(titleLabel);
		tempPanel.add(startArea);
		tempPanel.add(start1Area);
		tempPanel.add(start2Area);
	}
		
	//this method will create the main panel
	public void designMainPanel()
	{
		//add components to the mainPanel
		companyLabel.setFont(companyFont);
		mainPanel.add(companyLabel);
		mainPanel.add(selectLabel);
		mainPanel.add(selectComboBox);
		mainPanel.add(goButton);
		programmerNameLabel.setFont(programmerNameFont);
		mainPanel.add(programmerNameLabel);		
	}
	
	public void designTypePanel()
	{
		JLabel instr = new JLabel("Select Table");
		instr.setFont(companyFont);
		typePanel.add(instr);
		typePanel.add(gametypeBox);
		typePanel.add(typeGoButton);
		
	}
	
	//this method creates the account panel
	public void designgamePanel()
	{
		//add components to the adminPanel
		companyLabel2.setFont(companyFont);
		gamePanel.add(companyLabel2);
		gamePanel.add(gameComboBox);
		gamePanel.add(gameGo);
		gamePanel.add(gameBack);

	}
	
	public void designArrayPanel()
	{
		JPanel masterPanel = new JPanel();
		masterPanel.setSize(200, 200);
		GridLayout grid = new GridLayout(2,2);
		masterPanel.setLayout(grid);
		for(int i = 0; i < playersPanel.length; i++)
		{
			playersPanel[i].add(arrayLabel[i]);
			masterPanel.add(playersPanel[i]);
			playersPanel[i].setSize(100,100);
			
		}
		add(masterPanel);
		setVisible(true);
		setSize(400,400);
	}
	
	
	//this method creates the transaction panel
	public void designaddPanel()
	{
		//add the container group to the radio buttons
		addPanel.add(companyLabel3);
		addPanel.add(moneyLabel);
		addPanel.add(moneyField);
		addPanel.add(vipBox);
		addPanel.add(add);
		addPanel.add(addBack);
	/*	addPanel.add(idLabel);
		addPanel.add(idField);
		addPanel.add(nameLabel);
		addPanel.add(nameField); */
	}
	
	//this method puts action listeners on all the desired buttons
	public void addListeners()
	{
		//add the listeners to the respective components 
		selectComboBox.addActionListener(this);
		goButton.addActionListener(this);
		typeGoButton.addActionListener(this);
		gameGo.addActionListener(this);
		gameBack.addActionListener(this);
		add.addActionListener(this);
		addBack.addActionListener(this);
		vipBox.addItemListener(this);
		
	}	
		
	//this method assigns the actions and methods to the correct button
	
	public void actionPerformed(ActionEvent evt)
	{
		//buttons fire this event
		Object sourceObject = evt.getSource();
		
		if (sourceObject == goButton)
		{
			if(selectComboBox.getSelectedIndex() == 0)  //Play game
			{
				remove(mainPanel);
				remove(addPanel);
				add(typePanel);
				setSize(200, 200);
				setVisible(true);
			}
			else if (selectComboBox.getSelectedIndex() == 1) //Add Player to List
			{
				remove(mainPanel);
				remove(gamePanel);
				add(addPanel);
				setSize(250,250);
				setVisible(true);	
			}
			else if(selectComboBox.getSelectedIndex() == 2)  //Exit
			{				
				System.exit(0);
			}
			else
				JOptionPane.showMessageDialog(null, "Please make a selection in the combo box before pressing Go.");
		}
		
		if(sourceObject == typeGoButton)
		{
			remove(mainPanel);
			remove(addPanel);
			remove(typePanel);
			add(gamePanel);
			setSize(250, 250);
			setVisible(true);
		}
		
		if(sourceObject == gameGo)
		{
			if(gameComboBox.getSelectedIndex() == 1)
			{
				remove(gamePanel);
				remove(addPanel);
				designArrayPanel();
				setSize(400,400);
				setVisible(true);
			}
			if(gameComboBox.getSelectedIndex() == 2)
			{
				remove(gamePanel);
				remove(addPanel);
				selectComboBox.setSelectedIndex(-1);
				add(mainPanel);
				setSize(250,250);
				setVisible(true);
			}
				
		}
		
		else if(sourceObject == add)
		{
		
							
		}
		
		else if(sourceObject == gameBack)
		{
			remove(gamePanel);
			remove(addPanel);
			selectComboBox.setSelectedIndex(-1);
			add(mainPanel);
			setSize(250,250);
			setVisible(true);
		}
		else if(sourceObject == addBack)
		{
			remove(addPanel);
			remove(gamePanel);
			selectComboBox.setSelectedIndex(-1);
			add(mainPanel);
			setSize(250,250);
			setVisible(true);
		}		
		
	}//end of actionPerformed method

	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		if(vipBox.isSelected())
		{
			addPanel.add(idLabel);
			addPanel.add(idField);
			addPanel.add(nameLabel);
			addPanel.add(nameField);
			setSize(250,250);
			setVisible(true);
		}
		else
		{
/*			addPanel.remove(idLabel);
			addPanel.remove(idField);
			addPanel.remove(nameLabel);
			addPanel.remove(nameField);
*/			addPanel.removeAll();
			designaddPanel();
			setSize(250,250);
			setVisible(true);
		}
			
	}


}//end of class

