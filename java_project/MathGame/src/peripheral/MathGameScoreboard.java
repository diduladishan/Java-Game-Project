package peripheral;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import engine.MathGameCreateDatabase;

public class MathGameScoreboard extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6921462126880570161L;
	MathGameCreateDatabase myDb = null;
    Container container = getContentPane();
    JButton backButton = new JButton("BACK");
    JLabel scoreLabel = new JLabel("SCORECARD");
    JLabel background = new JLabel(new ImageIcon("C:\\Users\\Indraneel\\Desktop\\java_project\\images\\background.jpg"));
    JTextArea score = new JTextArea();
    
    MathGameScoreboard() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        Color bgColorBt1 = new Color(0, 255, 0, 130); 
        backButton.setBackground(bgColorBt1);   
        myDb = new MathGameCreateDatabase();
		String data = myDb.getScores();
		score.setText(data);
    }

    public void setLocationAndSize() {
    	background.setBounds(0, 0, 508, 719);
        backButton.setBounds(200, 400, 100, 30); 
        scoreLabel.setBounds(200, 50, 100, 30);
        score.setBounds(50, 80, 400, 280);
    }

    public void addComponentsToContainer() {
        container.add(backButton);
        container.add(score);
        container.add(scoreLabel);
        container.add(background);
        
    }

    public void addActionEvent() {
    	backButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == backButton) {
    		MathGameLogin login = new MathGameLogin();
    		dispose();
        
        }
    }
    
}


