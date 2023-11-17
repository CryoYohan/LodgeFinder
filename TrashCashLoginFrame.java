import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TrashCashLoginFrame extends JFrame{

	final int FRAME_SIZE_WIDTH = 833;
	final int FRAME_SIZE_HEIGHT = 653;
	
	// Main Panels
	JPanel loginPanelLeft = new JPanel();
	JPanel loginPanelRight = new JPanelGradient();
	
	//ImageIcon
	ImageIcon TrashCashlogo = new ImageIcon("Image/TrashCashLogo.png");
	ImageIcon Background = new ImageIcon("Image/LoginBG.png");

	//JLabel for Right Panel
	JLabel logo = new JLabel();
	JLabel BackgroundPic = new JLabel();
	JLabel usernameLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	Border empty = new EmptyBorder(0, 0, 0, 0);

	//JLabel for Left Panel
	JLabel title = new JLabel("TrashCash");
	JLabel shadowTitle = new JLabel("TrashCash");
	JLabel logo2 = new JLabel();
	JLabel quote = new JLabel();

	JButton loginButton = new JButton("LOG-IN");
	
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	
	TrashCashLoginFrame(){
		this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("TrashCash");
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(leftPanel(), BorderLayout.WEST);
		this.add(rightPanel(), BorderLayout.EAST);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Program", JOptionPane.YES_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	public JPanel leftPanel() {
		// Left Panel for Log-in Interface
		loginPanelLeft.setLayout(new BorderLayout());
		loginPanelLeft.setPreferredSize(new Dimension(480,626));
		loginPanelLeft.setBackground(new Color(0, 0, 0, 45));
		loginPanelLeft.add(logo2);
		loginPanelLeft.add(title);
		loginPanelLeft.add(shadowTitle);
		loginPanelLeft.add(quote);
		loginPanelLeft.add(BackgroundPic);

		logo2.setIcon(TrashCashlogo);
		logo2.setBounds(154, 45, 171, 160);

		shadowTitle.setFont(new Font("Segoe UI", Font.BOLD, 80));
		shadowTitle.setBounds(48, 200, 387, 92);
		shadowTitle.setForeground(new Color(174, 168, 168));

		title.setFont(new Font("Segoe UI", Font.BOLD, 80));
		title.setBounds(56, 200, 387, 92);
		title.setForeground(new Color(255, 255, 255));

		quote.setText("\"Transform Waste, Earn Green: Your Trash, Your Cash!\"");
		quote.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		quote.setBounds(70, 280, 355, 20);
		quote.setForeground(new Color(222, 213, 213));

		BackgroundPic.setIcon(Background);

		return loginPanelLeft;
	}
	
	public JPanel rightPanel() {
		//TrashCash Logo
		loginPanelRight.add(logo);
		logo.setIcon(TrashCashlogo);
		logo.setBounds(101,45,171,160);

		// Right Panel for Log-in Interface
		loginPanelRight.setLayout(new FlowLayout());
		loginPanelRight.setPreferredSize(new Dimension(352,626));
		loginPanelRight.setLayout(null);

		//USERNAME LABEL
		loginPanelRight.add(usernameLabel);
		usernameLabel.setBounds(50, 250, 110, 40);
		usernameLabel.setForeground(new Color(245, 245, 245));
		usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

		//USERNAME TEXTFIELD
		loginPanelRight.add(username);
		username.setBounds(50, 285, 262, 45);
		username.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		username.setBorder(empty);

		//PASSWORD LABEL
		loginPanelRight.add(passwordLabel);
		passwordLabel.setBounds(50, 340, 111, 40);
		passwordLabel.setForeground(new Color(245, 245, 245));
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

		//PASSWORD TEXTFIELD
		loginPanelRight.add(password);
		password.setBounds(50, 375, 262, 45);
		password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		password.setBorder(empty);

		//LOGIN BUTTON
		loginPanelRight.add(loginButton);
		loginButton.setBounds(110, 450, 148, 40);
		loginButton.setBackground(new Color(25, 122, 46));
		loginButton.setForeground(new Color(245,245,245));
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		loginButton.setFocusable(false);

		return loginPanelRight;
	}
}
