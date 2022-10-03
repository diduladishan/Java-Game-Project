package peripheral;

import javax.swing.JFrame;

public class MathGameLogin {
	public static void main(String[] args) {
    	MathGameLoginGUI frame = new MathGameLoginGUI();
        frame.setTitle("Math Game");
        frame.setVisible(true);
        frame.setBounds(0, 0, 508, 719);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
	
	public MathGameLogin() {
		MathGameLoginGUI frame = new MathGameLoginGUI();
        frame.setTitle("Math Game");
        frame.setVisible(true);
        frame.setBounds(0, 0, 508, 719);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
	}
}
