package peripheral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.MalformedURLException;
import javax.swing.*;

import engine.MathGameCreateDatabase;
import engine.MathGameEngine;
public class MathGameGUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = -107785653906635L;
	JLabel questArea = null;
	MathGameEngine myGame = null;
	JTextArea infoArea = null;
	JLabel label = null;
	JTextArea score = null;
	JLabel label1 = null;
	JButton button = null;
	String username = "";
	MathGameCreateDatabase myDb = null;

    @Override
    public void actionPerformed(ActionEvent e) {
            String userText;
            userText = infoArea.getText();
            
            if (myGame.checkSolution(userText)) {       	
            	myGame.updateScore(5);
            	score.setText(String.valueOf(myGame.getScore()));
            	infoArea.setText("");
            	infoArea.requestFocus();
            	
            	if(myGame.gameOver())
            	{	
            		JOptionPane.showMessageDialog(this, "Correct Answer! +5 points awarded! \n Game Over!");
            		JOptionPane.showMessageDialog(this, "Congratulations! Your Score:" + String.valueOf(myGame.getScore()));
            		myDb = new MathGameCreateDatabase();
            		myDb.updateScore(myGame.getUserName(), myGame.getScore());
            		dispose();
            		System.exit(0);
            	}
            	else {
            		JOptionPane.showMessageDialog(this, "Correct Answer! +5 points awarded! \n You go to the next level!");
            		MathGameGUI theGame = new MathGameGUI(myGame.getUserName()); 
    				theGame.setVisible(true); 
    				dispose();
            	}
            	
        		}
            	
            else {
                JOptionPane.showMessageDialog(this, "Wrong Answer! -2 points deducted! \n Try Again!");
                myGame.updateScore(-2);
                score.setText(String.valueOf(myGame.getScore()));
                infoArea.setText("");
                infoArea.requestFocus();
            }
        }


	private void initGame(String player) throws MalformedURLException {
		username = player;
		setResizable(false);
		setSize(460, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Math Game");
		JPanel panel = new JPanel();
		getContentPane().add(panel);	
		myGame = new MathGameEngine(player);
		int level = myGame.getLevel();
		String image1 = myGame.getImage(level);
		
		panel.setLayout(null);
		URL url = new URL(image1);
		ImageIcon ii = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(450, 600, 50));
		
		questArea = new JLabel(ii);
	    questArea.setSize(460, 600);
		label = new JLabel("Enter your answer:");
		label.setSize(200,50);
		label.setLocation(20,600);
		
		infoArea = new JTextArea(1, 40);
		infoArea.setLocation(140, 615);
		infoArea.setSize(145,22);
		
		JButton button = new JButton("Submit");
		
		button.setLocation(300, 615);
		button.setSize(120, 22);
		button.addActionListener(this);
		
		score = new JTextArea();
		score.setLocation(160, 652);
		score.setSize(150,22);
		
		label1 = new JLabel("Score:");
		label1.setSize(200,50);
		label1.setLocation(120,635);
		
		score.setEditable(false);
		score.setText(String.valueOf(myGame.getScore()));
		
		panel.add(label1);
		panel.add(score);
		panel.add(button);
		panel.add(questArea);
		panel.add(label);
		panel.add(infoArea);
		
	}

	
	public MathGameGUI() {
		super();
		try {
			initGame(null);
		}
		catch (MalformedURLException e) {
			System.out.println("Something went wrong when trying to retrieve game!"); 
			e.printStackTrace(); 
		} 		
		
	}


	public MathGameGUI(String player) {
		super();
		try {
		initGame(player);
		}
		catch (MalformedURLException e) {
		System.out.println("Something went wrong when trying to retrieve game!"); 
		e.printStackTrace();
		}
	} 		

	public static void main(String[] args) {
//		MathGameGUI myGUI = new MathGameGUI(userText);
//		myGUI.setVisible(true);

	}
}
