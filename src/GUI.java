import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUI extends JFrame implements ActionListener {
	private JButton button;
	private JComboBox fonts;
	private String message;
	private JComboBox red;
	private JComboBox green;
	private JComboBox blue;
	
	public GUI(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		add(button = new JButton("Press Me"));
		
		button.addActionListener(this);
		
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		add(fonts = new JComboBox(fontNames));
		
		message = "Hello";
		
		Integer[] choices = new Integer[256];
		
		for (int counter=0;counter<choices.length;counter++)
			choices[counter] =counter;
		
		add(red = new JComboBox(choices));
		add(green = new JComboBox(choices));
		add(blue = new JComboBox(choices));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		repaint();

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Font font = new Font(fonts.getSelectedItem().toString(),Font.BOLD,20);
		
		g.setFont(font);
		
		int red = Integer.parseInt(this.red.getSelectedItem().toString());
		int green = Integer.parseInt(this.green.getSelectedItem().toString());
		int blue = Integer.parseInt(this.blue.getSelectedItem().toString());
	
		g.setColor(new Color(red,green,blue));
		
		g.drawString(message, 10, 200);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI gui = new GUI("GUI");
		
		gui.setSize(500,500);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);

	}

}
