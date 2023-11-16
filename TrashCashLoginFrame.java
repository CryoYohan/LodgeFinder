package trashcash;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.color.*;
public class TrashCashLoginFrame extends JFrame{

	final int FRAME_SIZE_WIDTH = 833;
	final int FRAME_SIZE_HEIGHT = 653;
	
	// Main Panels
	JPanel loginPanelLeft = new JPanel();
	JPanel loginPanelRight = new JPanel();
	
	// Sub Panels for Left Panel
	JPanel subleft = new JPanel();
	JPanel subleft2 = new JPanel();
	JPanel subleft3 = new JPanel();
	
	// Sub Panels for Left Panel
	JPanel subright = new JPanel();
	JPanel subright2 = new JPanel();
	JPanel subright3 = new JPanel();
	
	JLabel usernameLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	
	JTextField username = new JTextField("Enter username");
	JTextField password = new JTextField("Enter password");
	
	TrashCashLoginFrame(){
		this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setTitle("TrashCash");
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(leftPanel(), BorderLayout.WEST);
		this.add(rightPanel(), BorderLayout.EAST);
		
	}
	public JPanel leftPanel() {
		// Left Panel for Log-in Interface
		loginPanelLeft.setLayout(new BorderLayout());
		loginPanelLeft.setPreferredSize(new Dimension(481,626));
		loginPanelLeft.setBackground(new Color(14,57,21));
		return loginPanelLeft;
	}
	
	public JPanel rightPanel() {
		// Right Panel for Log-in Interface
		loginPanelRight.setLayout(new FlowLayout());
		
		loginPanelRight.setPreferredSize(new Dimension(352,626));
		loginPanelRight.setBackground(new Color(100,157,109));
		
		subright.setBackground(Color.red);
		subright.setPreferredSize(new Dimension(200,150));
		subright2.setPreferredSize(new Dimension(200,150));
		subright3.setPreferredSize(new Dimension(200,150));
		subright2.setBackground(Color.BLUE);
		subright3.setBackground(Color.GREEN);
				
		loginPanelRight.add(subright, BorderLayout.NORTH );
		loginPanelRight.add(subright2, BorderLayout.CENTER);
		loginPanelRight.add(subright3, BorderLayout.SOUTH);
		return loginPanelRight;
	}
	
	
	
}
