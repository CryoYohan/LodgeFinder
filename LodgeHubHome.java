import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class LodgeHubHome extends JFrame {
    final int FRAME_SIZE_WIDTH = 1250;
    final int FRAME_SIZE_HEIGHT = 750;

    // NavBar at the Left Side
    JPanel navBar = new JPanel();
    JButton Profile = new CircleJButton("Cyril John");
    JButton Home = new HomeJButton("Home");
    JButton Favorites = new CircleJButton("Favorites");
    JButton Logout = new CircleJButton("Logout");
    ImageIcon profile = new ImageIcon("Image/profileAvatar.png");
    ImageIcon home = new ImageIcon("Image/HomeWhite.png");
    ImageIcon heart = new ImageIcon("Image/heart.png");
    ImageIcon logout = new ImageIcon("Image/Logout.png");
    ImageIcon icon = new ImageIcon("Image/LodgeHubIcon.png");

    // HOME INTERFACE
    JPanel homeContainer = new JPanel();
    JLabel homeBackground = new JLabel();
    ImageIcon homeWallpaper = new ImageIcon("Image/HomeWallpaper.jpg");
    String[] barangays = {"Kalubihan", "Parian", "Labangon", "Tisa", "Mambaling", "Guadalupe"};
    JComboBox dropdown = new JComboBox<>(barangays);
    JButton btn = new LodgeButton();
    ImageIcon searchButton = new ImageIcon("Image/searchLodge.png");

    
    
    // USER INTERFACE
    JPanel userProfileContainer;
    
    // FAVORITES INTERFACE
    JPanel favContainer;

    LodgeHubHome() {
        this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setTitle("LodgeFinder");
        this.setVisible(true);
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.add(NavBar());
        this.add(UserProfile());
        this.add(Home());       
        this.add(Favorites());
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Program", JOptionPane.YES_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public JPanel NavBar() {
        navBar.setPreferredSize(new Dimension(211, 1025));
        navBar.setBackground(new Color(100, 178, 255));
        navBar.setBounds(0,0,211,1025);

        // Buttons in navigation
        navBar.add(Profile);
        navBar.add(Home);
        navBar.add(Favorites);
        navBar.add(Logout);
        buttonFunctionality(Profile);
        buttonFunctionality(Home);
        
        // Profile Bar
        Profile.setIcon(profile);
        Profile.setBounds(38, 26, 140, 170);
        Profile.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Profile.setHorizontalTextPosition(JButton.CENTER);
        Profile.setVerticalTextPosition(JButton.BOTTOM);
        Profile.setIconTextGap(15);
       
        
        // Home Bar
        Home.setIcon(home);
        Home.setBounds(0, 206, 212, 170);
        Home.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Home.setForeground(new Color(255, 255, 255));
        Home.setHorizontalTextPosition(JButton.CENTER);
        Home.setVerticalTextPosition(JButton.BOTTOM);
        Home.setIconTextGap(15);
      
        
        // Favorite Bar
        Favorites.setIcon(heart);
        Favorites.setBounds(50, 387, 115, 170);
        Favorites.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Favorites.setHorizontalTextPosition(JButton.CENTER);
        Favorites.setVerticalTextPosition(JButton.BOTTOM);
        Favorites.setIconTextGap(15);
        buttonFunctionality(Favorites);
        
        // Logout button
        Logout.setIcon(logout);
        Logout.setBounds(40, 650, 130, 50);
        Logout.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Logout.setForeground(new Color(255, 255, 255));
        Logout.setIconTextGap(10);
        
        navBar.setLayout(null);

        return navBar;
    }

    public JPanel Home() {
        homeContainer.setLayout(null);
        homeContainer.setPreferredSize(new Dimension(1050,750));
        homeContainer.setBounds(190, -69, 1195, 900);
        homeContainer.add(homeBackground);

        // JLabel for Home Wallpaper
        homeBackground.setIcon(resizeImageIcon(homeWallpaper, 1060, 720));
        homeBackground.setBounds(0, 0, 1208, 840);
        homeBackground.add(dropdown);
        homeBackground.add(btn);

        //DROPDOWN MENU
        Border lineBorder = new LineBorder(new Color(164, 164, 164), 2, true);
        Border emptyBorder = new EmptyBorder(0, 8, 0, 0);
        Border compoundBorder = new CompoundBorder(lineBorder, emptyBorder);
        dropdown.setBounds(380, 450, 288, 69);
        dropdown.setFont(new Font("Poppins", Font.PLAIN, 20));
        dropdown.setBackground(Color.WHITE);
        dropdown.setUI(BasicComboBoxUI.createUI(dropdown));
        dropdown.setBorder(compoundBorder);
        dropdown.setMaximumRowCount(3);
        dropdown.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dropdown.setForeground(new Color(19, 112, 204));
        //dropdown.setFocusable(true); //disable if editable is true especially when autocomplete is enabled
        dropdown.setEditable(true);
        dropdown.setSelectedIndex(-1);
        dropdown.setSelectedItem("Select Barangay");
        AutoCompleteDecorator.decorate(dropdown); //Erase this code and setEditable to false if dili ta makauyon

        //BUTTON TO SEARCH LODGES
        btn.setBounds(380, 600, 288, 69);
        btn.setIcon(searchButton);
        btn.setBorderPainted(false);

        return homeContainer;
    }

    public JPanel UserProfile() {
    	userProfileContainer = new JPanel();
    	userProfileContainer.setPreferredSize(new Dimension(1208,969));
    	userProfileContainer.setBounds(190, 0, 1195, 900);
    	//userProfileContainer.add(homeBackground);
    	//userProfileContainer.add(locationBox);
    	userProfileContainer.setBackground(Color.red);
    	userProfileContainer.setLayout(null);
    	userProfileContainer.setVisible(false);
    	
    	return userProfileContainer;
    }
    
    public JPanel Favorites() {
    	favContainer = new JPanel();
    	favContainer.setLayout(null);
    	favContainer.setPreferredSize(new Dimension(1208,969));
    	favContainer.setBounds(190, 0, 1195, 900);
    	favContainer.setBackground(Color.MAGENTA);
    	favContainer.setVisible(false);
       
        return favContainer;
    }
    
       
    public void buttonFunctionality(JButton button) {
    	button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source==Home) {
					homeContainer.setVisible(true);
					userProfileContainer.setVisible(false);
					favContainer.setVisible(false);
				}
				if(source==Profile) {
					userProfileContainer.setVisible(true);
					homeContainer.setVisible(false);
					favContainer.setVisible(false);
					
				}
				if(source==Favorites) {
					favContainer.setVisible(true);
					userProfileContainer.setVisible(false);
					homeContainer.setVisible(false);
				}				
				
			}
    		
    	});
    }
}