import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class RegistrationForm extends JFrame{

	final int FRAME_SIZE_WIDTH = 833;
	final int FRAME_SIZE_HEIGHT = 653;
	private String usernameVar = " ", passwordVar = " ";
    LodgeHubLoginFrame LodgeHubLoginFrame;
	
	
	// Main Panels
	JPanel loginPanelLeft = new JPanel();
	JPanel loginPanelRight = new JPanel();
	
	//ImageIcon
	ImageIcon LodgeFinderIcon = new ImageIcon("Image/LodgeHubIcon.png");
	ImageIcon LodgeFinder = resizeImageLogo("Image/LodgeHub.png", 260,260);
    ImageIcon View = new ImageIcon("Image/View.png");
    ImageIcon Hide = new ImageIcon("Image/Hide.png");
	//ImageIcon Background = new ImageIcon("trashCashBG.jpg");
	int desiredWidth = 477; // Set your desired width
	int desiredHeight = 667; // Set your desired height
	ImageIcon Background = resizeImageIcon("Image/LoginWallpaper.jpg", desiredWidth, desiredHeight);
    //Resize LodgeFinder Logo
	 public static ImageIcon resizeImageLogo(String imagePath, int width, int height) {
	        ImageIcon imageIcon = new ImageIcon(imagePath);
	        Image image = imageIcon.getImage(); // transform it
	        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // scale it the smooth way
	        return new ImageIcon(newImage); // transform it back
	    }
   //Resize the background image
   public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage(); // transform it
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newImage); // transform it back
    }

	

	//JLabel for Right Panel
	JLabel logo = new JLabel();
	JLabel BackgroundPic = new JLabel();
	JLabel usernameLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel confirmpassLabel = new JLabel("CONFIRM PASSWORD");
    JLabel viewPassword = new JLabel();
    JLabel hidePassword = new JLabel();
    JLabel viewConfirmPass = new JLabel();
    JLabel hideConfirmPass = new JLabel();
	JLabel fnameLabel = new JLabel("FIRST NAME");
	JLabel lnameLabel = new JLabel("LAST NAME");
	JLabel phonenumberLabel = new JLabel("PHONE NUMBER");
	JLabel ageLabel = new JLabel("AGE");
	JLabel emailLabel = new JLabel("EMAIL ADDRESS");
	JLabel loginHere = new JLabel("Already have? Login ");
    JLabel greenHere = new JLabel("here");
	Border empty = new EmptyBorder(0, 0, 0, 0);

	JButton loginButton = new RoundJButton("Register");
	JTextField phonenumber = new RoundJTextField(15);
	JTextField age = new RoundJTextField(15);
	JTextField email = new RoundJTextField(15);
	JTextField fname = new RoundJTextField(15);
	JTextField mname = new RoundJTextField(15);
	JTextField lname = new RoundJTextField(15);
	JTextField username = new RoundJTextField(15);
	JPasswordField password = new RoundJPasswordField(15);
    JPasswordField confirmpass = new RoundJPasswordField(15);
	
	RegistrationForm(){
		this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("LodgeFinder");
		this.setIconImage(LodgeFinderIcon.getImage());
		this.setVisible(true);	
		this.setLayout(new BorderLayout());
		this.add(leftPanel(), BorderLayout.WEST);
		this.add(rightPanel(), BorderLayout.EAST);
		this.setLocationRelativeTo(null);
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
		loginPanelLeft.setPreferredSize(new Dimension(469,667));
		loginPanelLeft.setBackground(new Color(0, 0, 0, 45));
			
		// Resize Background in left panel
		loginPanelLeft.setLayout(null);
		int backgroundX = 0;  // Set your desired X coordinate
	    int backgroundY = 0;  // Set your desired Y coordinate
	    BackgroundPic.setIcon(Background);
	    BackgroundPic.setBounds(backgroundX, backgroundY, desiredWidth, desiredHeight);
	      
	    loginPanelLeft.add(BackgroundPic);

		return loginPanelLeft;
	}


	// Right Panel for Log-in Interface
    public JPanel rightPanel() {
        loginPanelRight.add(logo);
        logo.setIcon(LodgeFinder);
        logo.setBounds(60, 10, 500, 108);
        loginPanelRight.setLayout(new FlowLayout());
        loginPanelRight.setPreferredSize(new Dimension(364, 667));
        loginPanelRight.setBackground(new Color(217,217,217));
        loginPanelRight.setLayout(null);

        // First Name TextField and Label
        loginPanelRight.add(fname);
        fname.setBounds(40,172,145,25);
        fname.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loginPanelRight.add(fnameLabel);
        // This sets letter spacing to our JLabel Texts, I got this from stack overflow. Feel free to utilize this code snippet
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            fnameLabel.setFont(fnameLabel.getFont().deriveFont(attributes));
        });
        fnameLabel.setBounds(40, 140,100,40);
        fnameLabel.setFont(new Font("Actor", Font.PLAIN, 12));
        fnameLabel.setForeground(new Color(13, 77, 140));
        //TEXT FIELD AND LABEL FOR LASTNAME
        loginPanelRight.add(lname);
        lname.setBounds(200, 172, 145, 25);
        lname.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loginPanelRight.add(lnameLabel);
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            lnameLabel.setFont(lnameLabel.getFont().deriveFont(attributes));
        });
        lnameLabel.setBounds(200, 140, 100, 40);
        lnameLabel.setFont(new Font("Actor", Font.PLAIN, 12));
        lnameLabel.setForeground(new Color(13, 77, 140));
        // PHONE NUMBER TEXTFIELD AND LABEL
        loginPanelRight.add(phonenumber);
        phonenumber.setBounds(40, 226, 145, 25);
        phonenumber.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loginPanelRight.add(phonenumberLabel);
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            phonenumberLabel.setFont(phonenumberLabel.getFont().deriveFont(attributes));
        });
        phonenumberLabel.setBounds(40, 194, 130, 40);
        phonenumberLabel.setFont(new Font("Actor", Font.PLAIN, 12));
        phonenumberLabel.setForeground(new Color(13, 77, 140));
        // AGE TEXTFIELD AND LABEL
        loginPanelRight.add(age);
        age.setBounds(200, 226, 145, 25);
        age.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loginPanelRight.add(ageLabel);
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            ageLabel.setFont(ageLabel.getFont().deriveFont(attributes));
        });
        ageLabel.setBounds(200, 194, 80, 40);
        ageLabel.setFont(new Font("Actor", Font.PLAIN, 12));
        ageLabel.setForeground(new Color(13, 77, 140));
        // EMAIL ADDRESS TEXTFIELD AND LABEL
        loginPanelRight.add(email);
        email.setBounds(40, 280, 145, 25);
        email.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loginPanelRight.add(emailLabel);
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            emailLabel.setFont(emailLabel.getFont().deriveFont(attributes));
        });
        emailLabel.setBounds(40, 248, 130, 40);
        emailLabel.setFont(new Font("Actor", Font.PLAIN, 12));
        emailLabel.setForeground(new Color(13, 77, 140));
        // USERNAME TEXTFIELD and LABEL
        loginPanelRight.add(username);
        username.setBounds(200, 280, 145, 25); // adjust spacing
        username.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        // This sets letter spacing to our JLabel Texts, I got this from stack overflow. Feel free to utilize this code snippet
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            usernameLabel.setFont(usernameLabel.getFont().deriveFont(attributes));
        });
        loginPanelRight.add(usernameLabel);
        usernameLabel.setBounds(200, 248, 110, 40);
        usernameLabel.setForeground(new Color(13,77,140));    // change color on user name label me 
        usernameLabel.setFont(new Font("Actor", Font.PLAIN, 12));
        // PASSWORD LABEL and TEXTFIELD
        // This sets letter spacing to our JLabel Texts, I got this from stack overflow. Feel free to utilize this code snippet
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            passwordLabel.setFont(passwordLabel.getFont().deriveFont(attributes));
        });
        loginPanelRight.add(passwordLabel);
        passwordLabel.setBounds(40, 302, 111, 40);
        passwordLabel.setForeground(new Color(13,77,140));      // Change color on password label  me
        passwordLabel.setFont(new Font("Actor", Font.PLAIN, 12)); // change into Plain color me size it for 15

        // EYE ICON TO SHOW OR HIDE PASSWORD ASTERISK;
        loginPanelRight.add(hidePassword);
        hidePassword.setIcon(Hide);
        hidePassword.setBounds(165, 340, 13, 13);
        hidePassword.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                hidePassword.setVisible(false);
                viewPassword.setVisible(true);
                password.setEchoChar((char)0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        loginPanelRight.add(viewPassword);
        viewPassword.setIcon(View);
        viewPassword.setBounds(165, 340, 13, 13);
        viewPassword.setVisible(false);
        viewPassword.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                viewPassword.setVisible(false);
                hidePassword.setVisible(true);
                password.setEchoChar('*');
            };
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        
        loginPanelRight.add(password);
        password.setBounds(40, 334, 145, 25);
        password.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        // CONFIRMATION PASSWORD LABEL and TEXTFIELD
        // This sets letter spacing to our JLabel Texts, I got this from stack overflow. Feel free to utilize this code snippet
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            confirmpassLabel.setFont(confirmpassLabel.getFont().deriveFont(attributes));
        });
        loginPanelRight.add(confirmpassLabel);
        confirmpassLabel.setBounds(200, 302, 125, 40);
        confirmpassLabel.setForeground(new Color(13,77,140));
        confirmpassLabel.setFont(new Font("Actor", Font.PLAIN, 12));

        loginPanelRight.add(hideConfirmPass);
        hideConfirmPass.setIcon(Hide);
        hideConfirmPass.setBounds(325, 340, 13, 13);
        hideConfirmPass.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                viewConfirmPass.setVisible(true);
                hideConfirmPass.setVisible(false);
                confirmpass.setEchoChar((char)0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        loginPanelRight.add(viewConfirmPass);
        viewConfirmPass.setIcon(View);
        viewConfirmPass.setBounds(325, 340, 13, 13);
        viewConfirmPass.setVisible(false);
        viewConfirmPass.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                viewConfirmPass.setVisible(false);
                hideConfirmPass.setVisible(true);
                confirmpass.setEchoChar('*');
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        loginPanelRight.add(confirmpass);
        confirmpass.setBounds(200, 334, 145, 25);
        confirmpass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
         
        // LOGIN BUTTON
        loginPanelRight.add(loginButton);
        loginButton.setBounds(125, 438, 148, 40);
        loginButton.setBackground(new Color(13, 77, 140));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        loginButton.setFocusable(false);
        
     // New Account? Register here
        JLabel copyright = new JLabel("©2023 LodgeFinder. All rights reserved");
        loginPanelRight.add(copyright);
        copyright.setFont(new Font("Poppins", Font.PLAIN, 8));
        copyright.setBounds(135,520,160,160);
        loginPanelRight.add(loginHere);
        loginPanelRight.add(greenHere);
        loginHere.setBounds(110, 430, 200, 200);
        loginHere.setForeground(new Color(62,56,56));
        loginHere.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        greenHere.setForeground(new Color(100,178,255));
        greenHere.setBounds(248,510,40,40);
        greenHere.setFont(new Font("Segoe UI", Font.BOLD, 15));
        greenHere.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		if(e.getSource() == greenHere) {
        			dispose();
        			LodgeHubLoginFrame = new LodgeHubLoginFrame();
        		}
        	}
        	// if user hovers over highlighted "here" button it will change cursor to hand
        	@Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        	// if user stops hover over highlighted "here" button it will change hand cursor to default
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        
        Border blueLineBorder = new LineBorder(new Color(50, 89, 127), 2, true);
        Border emptyBorder = new EmptyBorder(0, 8, 0, 8); // adjust padding on up and down. >>>>>>>>>>>>>>>>>>>
        Border compoundBorder = new CompoundBorder(blueLineBorder, emptyBorder);
        username.setBorder(compoundBorder);
        password.setBorder(compoundBorder);
        confirmpass.setBorder(compoundBorder);
        fname.setBorder(compoundBorder);
        lname.setBorder(compoundBorder);
        phonenumber.setBorder(compoundBorder);
        age.setBorder(compoundBorder);
        email.setBorder(compoundBorder);

        // Add placeholder text for first name
        fname.setForeground(new Color(100, 178, 255));
        fname.setText("Enter first name");

        // Placeholder text for last name
        lname.setForeground(new Color(100, 178, 255));
        lname.setText("Enter last name");
        
        // Placeholder text for PHONE NUMBER
        phonenumber.setForeground(new Color(100, 178, 255));
        phonenumber.setText("Enter phone number");

        // Placeholder para sa AGE
        age.setForeground(new Color(100, 178, 255));
        age.setText("Enter age");

        // Placeholder text for EMAIL ADDRESS
        email.setForeground(new Color(100, 178, 255));
        email.setText("Enter email address");

        // Add placeholder text for username field
        username.setForeground(new Color(100,178,255));
        username.setText("Enter username");

        // Add placeholder text for password field
        password.setForeground(new Color(100,178,255));
        password.setEchoChar((char) 0); // Set echo char to zero to show plain text
        password.setText("Enter password");

        // Add placeholder text for confirmation password
        confirmpass.setForeground(new Color(100, 178, 255));
        confirmpass.setEchoChar((char) 0);
        confirmpass.setText("Enter password");
        
     // Add focus listeners to the text fields
        username.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (username.getText().equals("Enter username")) { // if ma click na ang field, mawala ang placeholder
                username.setText("");
                username.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (username.getText().isEmpty()) { // If di ma click ang field, display placeholder
                username.setText("Enter username");
                username.setForeground(new Color(100,178,255)); // Color sa placeholder
            }
        }
        });
        password.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) { // If ma click na gali ang input field mawala ang placeholder
                if (password.getText().equals("Enter password")) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                    password.setEchoChar('*'); // Ang echoChar e set nato balik og '*' kay para ma encrypted ang pass sa user
                }							   // gi EchoChar(0) man nato sya pag declare sa taas para di ma encrypt and placeholder
            }

            @Override
            public void focusLost(FocusEvent e) { // If di ma click ang input field, mo display ang "Enter password" na placeholder
                if (password.getText().isEmpty()) {
                    password.setForeground(new Color(100,178,255)); // Color sa placeholder
                    password.setEchoChar((char)0);		// This sets the encrypted text of the JPasswordField to a plain/readable text
                    password.setText("Enter password");
                }
            }
        });
        confirmpass.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) { // If ma click na gali ang input field mawala ang placeholder
                if (confirmpass.getText().equals("Enter password")) {
                    confirmpass.setText("");
                    confirmpass.setForeground(Color.BLACK);
                    confirmpass.setEchoChar('*'); // Ang echoChar e set nato balik og '*' kay para ma encrypted ang pass sa user
                }							   // gi EchoChar(0) man nato sya pag declare sa taas para di ma encrypt and placeholder
            }

            @Override
            public void focusLost(FocusEvent e) { // If di ma click ang input field, mo display ang "Enter password" na placeholder
                if (confirmpass.getText().isEmpty()) {
                    confirmpass.setForeground(new Color(100,178,255)); // Color sa placeholder
                    confirmpass.setEchoChar((char)0);		// This sets the encrypted text of the JPasswordField to a plain/readable text
                    confirmpass.setText("Enter password");
                }
            }
        });
        fname.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (fname.getText().equals("Enter first name")) { // if ma click na ang field, mawala ang placeholder
                fname.setText("");
                fname.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (fname.getText().isEmpty()) { // If di ma click ang field, display placeholder
                fname.setText("Enter first name");
                fname.setForeground(new Color(100,178,255)); // Color sa placeholder
            }
        }
        });
        lname.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (lname.getText().equals("Enter last name")) { // if ma click na ang field, mawala ang placeholder
                lname.setText("");
                lname.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (lname.getText().isEmpty()) { // If di ma click ang field, display placeholder
                lname.setText("Enter last name");
                lname.setForeground(new Color(100,178,255)); // Color sa placeholder
            }
        }
        });
        phonenumber.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (phonenumber.getText().equals("Enter phone number")) { // if ma click na ang field, mawala ang placeholder
                phonenumber.setText("");
                phonenumber.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (phonenumber.getText().isEmpty()) { // If di ma click ang field, display placeholder
                phonenumber.setText("Enter phone number");
                phonenumber.setForeground(new Color(100,178,255)); // Color sa placeholder
            }
        }
        });
        age.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (age.getText().equals("Enter age")) { // if ma click na ang field, mawala ang placeholder
                age.setText("");
                age.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (age.getText().isEmpty()) { // If di ma click ang field, display placeholder
                age.setText("Enter age");
                age.setForeground(new Color(100,178,255)); // Color sa placeholder
            }
        }
        });
        email.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (email.getText().equals("Enter email address")) { // if ma click na ang field, mawala ang placeholder
                email.setText("");
                email.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (email.getText().isEmpty()) { // If di ma click ang field, display placeholder
                email.setText("Enter email address");
                email.setForeground(new Color(100,178,255)); // Color sa placeholder
            }
        }
        });
        return loginPanelRight; 
    }

	// Magamit ni para Register button
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object source = e.getSource();
//		if(source==loginButton) {
//			usernameVar = username.getText();
//			passwordVar = password.getText();
//			if(usernameVar.equals(registeredUser) && passwordVar.equals(registeredPassword))
//				JOptionPane.showMessageDialog(null, "Login Successful! Welcome " + usernameVar);
//			else
//				JOptionPane.showMessageDialog(null,"Invalid Username/Password! New Account? Register now!","TrashCash", JOptionPane.ERROR_MESSAGE);		
//		}		
//	}
}