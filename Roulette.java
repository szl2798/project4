import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Roulette {

	public static void main(String[] args)throws IOException{
		ArrayList<Game> currentGames = new ArrayList<Game>();
		ArrayList<Player> currentPlayers = new ArrayList<Player>();
		GameFile.load(currentGames, currentPlayers); //static call to LoadGame which constructs currentGames and currentPlayers objects
		System.out.println(currentGames);
		System.out.println(currentPlayers);
		// Call GUI
		JFrame frame = new JFrame("Roulette");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GameWindow(currentGames, currentPlayers));
		
		frame.pack();
		frame.setVisible(true);

	}
	public static class GameWindow extends JPanel{
		JLabel mainMenu;
		JLabel mainOptions;
		JButton selectAGame, addAPlayer,quit;
		JButton playerButton,vipPlayerButton;
		JButton addRegularButton, addVipButton;
		JTextField moneyField, idField, nameField;
		JPanel menuPanel, addAPlayerPanel, addRegularPlayer, addVipPlayer;
		ArrayList<Game> availableGames;
		ArrayList<Player> availablePlayers;
		
		public GameWindow(ArrayList availableGames, ArrayList availablePlayers){
			this.availableGames = availableGames;
			this.availablePlayers = availablePlayers;
			setBackground(Color.yellow);
			mainMenu = new JLabel("Main Menu",JLabel.CENTER);
			selectAGame = new JButton("Select A Game");
			addAPlayer = new JButton("Add A Player");
			addAPlayer.addActionListener(new ButtonListener());
			quit = new JButton("Quit");
			
			menuPanel =new JPanel(new FlowLayout());
			menuPanel.setPreferredSize(new Dimension(170, 265));
			menuPanel.setBackground(Color.yellow);
			menuPanel.add(mainMenu);
			menuPanel.add(selectAGame);
			menuPanel.add(addAPlayer);
			menuPanel.add(quit);
			add(menuPanel);
			setBackground(Color.yellow);
			setPreferredSize(new Dimension(450,550));
			
		}
		
		public JPanel addAPlayerPanel(){
			addAPlayerPanel = new JPanel();
			addAPlayerPanel.setLayout(new FlowLayout());
			addAPlayerPanel.setPreferredSize(new Dimension(170, 265));
			addAPlayerPanel.setBackground(Color.yellow);
			JLabel heading = new JLabel("Adding a player", JLabel.CENTER);
			playerButton = new JButton("Add a regular player");
			playerButton.addActionListener(new ButtonListener());
			vipPlayerButton = new JButton("Add a vip player");
			vipPlayerButton.addActionListener(new ButtonListener());
			addAPlayerPanel.add(heading);
			addAPlayerPanel.add(playerButton);
			addAPlayerPanel.add(vipPlayerButton);
			return addAPlayerPanel;
		}
		
		public void addRegularPlayer(){
			addRegularPlayer = new JPanel();
			addRegularPlayer.setLayout(new FlowLayout());
			addRegularPlayer.setPreferredSize(new Dimension(200, 265));
			addRegularPlayer.setBackground(Color.yellow);
			JLabel heading = new JLabel("Adding a regular player", JLabel.CENTER);
			addRegularButton = new JButton("Add");
			addRegularButton.addActionListener(new addButtonListener());
			JLabel money = new JLabel("Money the player's have:");
			moneyField = new JTextField(5);
			
			addRegularPlayer.add(heading);
			addRegularPlayer.add(money);
			addRegularPlayer.add(moneyField);
			addRegularPlayer.add(addRegularButton);
			add(addRegularPlayer);
			updateUI();
			
		}
		
		public void addVipPlayer(){
			addVipPlayer = new JPanel();
			addVipPlayer.setLayout(new BoxLayout(addVipPlayer,BoxLayout.Y_AXIS));
			addVipPlayer.setPreferredSize(new Dimension(230, 265));
			addVipPlayer.setBackground(Color.yellow);
			JLabel heading = new JLabel("Adding a regular player");
			heading.setAlignmentX(CENTER_ALIGNMENT);

			
			JLabel money = new JLabel("Money the player's have:");
			money.setAlignmentX(CENTER_ALIGNMENT);
			moneyField = new JTextField();
			moneyField.setMaximumSize(getPreferredSize());
			JLabel playerId = new JLabel("Player's id:");
			playerId.setAlignmentX(CENTER_ALIGNMENT);
			idField = new JTextField();
			idField.setMaximumSize(getPreferredSize());
			JLabel playerName = new JLabel("Player's name:");
			playerName.setAlignmentX(CENTER_ALIGNMENT);
			nameField = new JTextField();
			nameField.setMaximumSize(getPreferredSize());
			addVipButton = new JButton("Add");
			addVipButton.setAlignmentX(CENTER_ALIGNMENT);
			addVipButton.addActionListener(new addButtonListener());
			
			addVipPlayer.add(heading);
			addVipPlayer.add(Box.createRigidArea(new Dimension(0,20)));
			addVipPlayer.add(money);
			addVipPlayer.add(moneyField);
			addVipPlayer.add(playerId);
			addVipPlayer.add(idField);
			addVipPlayer.add(playerName);
			addVipPlayer.add(nameField);
			addVipPlayer.add(addVipButton);
			add(addVipPlayer);
			updateUI();
		}
		
		public class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(event.getSource() == addAPlayer){
					remove(menuPanel);
					updateUI();
					add(addAPlayerPanel());
					updateUI();
				}else if(event.getSource() == playerButton){
					remove(addAPlayerPanel);
					updateUI();
					addRegularPlayer();
				}else if( event.getSource() == vipPlayerButton){
					remove(addAPlayerPanel);
					updateUI();
					addVipPlayer();
				}
			}
		}
		
		public class addButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(event.getSource() == addRegularButton){
					availablePlayers.add(new Player(Integer.parseInt(moneyField.getText()),false));
					remove(addRegularPlayer);
					updateUI();
					add(menuPanel);
					updateUI();
				}else if(event.getSource() == addVipButton){
					availablePlayers.add(new VipPlayer(Integer.parseInt(moneyField.getText()),true, Integer.parseInt(idField.getText()), nameField.getText()));
					System.out.println(availablePlayers);
					remove(addVipPlayer);
					updateUI();
					add(menuPanel);
					updateUI();
				}
			}
		}
	}
}

