package peripheral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import engine.MathGameCreateDatabase;

public class MathGameLoginGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6921462126880570161L;
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton signupButton = new JButton("SIGN UP");
    JButton scoreButton = new JButton("SCORES");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel background = new JLabel(new ImageIcon("C:\\Users\\Indraneel\\Desktop\\java_project\\images\\background.jpg"));
    MathGameCreateDatabase myDb = null;
    
    MathGameLoginGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
        Color bgColorBt1 = new Color(0, 255, 0, 130); 
        Color bgColorBt2 = new Color(255, 0, 0, 130); 
        loginButton.setBackground(bgColorBt1);
        resetButton.setBackground(bgColorBt2);
        signupButton.setBackground(bgColorBt1);
        scoreButton.setBackground(bgColorBt2);
        
    }

    public void setLocationAndSize() {
    	background.setBounds(0, 0, 508, 719);
        userLabel.setBounds(100, 250, 100, 30);
        passwordLabel.setBounds(100, 290, 100, 30);
        userTextField.setBounds(200, 250, 150, 30);
        passwordField.setBounds(200, 290, 150, 30);
        showPassword.setBounds(160, 330, 150, 30);
        loginButton.setBounds(100, 380, 100, 30);
        resetButton.setBounds(250, 380, 100, 30);
        signupButton.setBounds(100, 430, 100, 30);
        scoreButton.setBounds(250, 430, 100, 30);
        
    }

    public void addComponentsToContainer() {
    	container.add(loginButton);
        container.add(resetButton);
        container.add(signupButton);
        container.add(scoreButton);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(background);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        signupButton.addActionListener(this);
        scoreButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == scoreButton) {
    		MathGameScoreboard frame = new MathGameScoreboard();
            frame.setTitle("Math Game");
            frame.setVisible(true);
            frame.setBounds(0, 0, 508, 719);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
    		dispose();
    	}
    	if (e.getSource() == signupButton) {
    		MathGameSignup frame = new MathGameSignup();
            frame.setTitle("Math Game");
            frame.setVisible(true);
            frame.setBounds(0, 0, 508, 719);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
    		dispose();
    	}
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = String.valueOf(passwordField.getPassword());
            myDb = new MathGameCreateDatabase();
            if(myDb.validateUser(userText, pwdText)) {
            	JOptionPane.showMessageDialog(this, "Login Successful! Get ready for level 1!");
            	MathGameGUI theGame = new MathGameGUI(userText); 
				theGame.setVisible(true); 
				dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                userTextField.setText("");
                passwordField.setText("");
                showPassword.setSelected(false);
                userTextField.requestFocus();
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            showPassword.setSelected(false);
            userTextField.requestFocus();
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}


