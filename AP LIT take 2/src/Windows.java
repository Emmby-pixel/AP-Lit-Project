import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Windows extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8255319694373975038L;
	
		 static JFrame frame; 
		 Container con;
		 static Font fnt = new Font("arial", 1, 20);	
		
	public Windows(int width, int height, String title, Game game ) {
		frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setBackground(Color.black);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		con = frame.getContentPane();
		
		game.start();
		
	}
	
	/*public static void textbox(String words) {
		
		
		JTextArea mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 100, 100);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(fnt);
		mainTextArea.setLineWrap(true);
		mainTextArea.setText(words);
		mainTextArea.append(words);
		
		mainTextArea.setVisible(true);
	}*/
	
	public static JFrame getJFrame() {
		return frame;
	}
	
	
}