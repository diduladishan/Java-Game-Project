package peripheral;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import engine.MathGameCreateDatabase;
import engine.MathGameEngine;

public class MathGameSignup extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6921462126880570161L;
	MathGameCreateDatabase myDb = null;
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton signupButton = new JButton("SIGN UP");
    JLabel background = new JLabel(new ImageIcon("C:\\Users\\Indraneel\\Desktop\\java_project\\images\\background.jpg"));

    MathGameSignup() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
        Color bgColorBt1 = new Color(0, 255, 0, 130); 
        signupButton.setBackground(bgColorBt1);        
    }

    public void setLocationAndSize() {
    	background.setBounds(0, 0, 508, 719);
        userLabel.setBounds(100, 250, 100, 30);
        passwordLabel.setBounds(100, 290, 100, 30);
        userTextField.setBounds(200, 250, 150, 30);
        passwordField.setBounds(200, 290, 150, 30);
        signupButton.setBounds(200, 330, 100, 30);        
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(signupButton);
        container.add(background);
    }

    public void addActionEvent() {
        signupButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == signupButton) {
    		String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = String.valueOf(passwordField.getPassword());
            myDb = new MathGameCreateDatabase();
    		myDb.addUser(userText, pwdText);
    		MathGameLogin login = new MathGameLogin();
    		dispose();
        
        }
    }
    
}


