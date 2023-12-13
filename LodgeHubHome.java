import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
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
//import org.desktop.swingx.autocomplete.AutoCompleteDecorator;

public class LodgeHubHome extends JFrame {
    final int FRAME_SIZE_WIDTH = 1250;
    final int FRAME_SIZE_HEIGHT = 750;

    // NavBar at the Left Side
    JPanel navBar = new JPanel();
    JButton Profile = new CircleJButton("Cyril John");
    JButton Home = new HomeJButton("Home");
    JButton Favorites = new CircleJButton("Favorites");
    JButton Logout = new CircleJButton("Logout");
    ImageIcon profile = new ImageIcon("profileAvatar.png");
    ImageIcon home = new ImageIcon("HomeWhite.png");
    ImageIcon heart = new ImageIcon("heart.png");
    ImageIcon logout = new ImageIcon("Logout.png");
    ImageIcon icon = new ImageIcon("LodgeHubIcon.png");
    ImageIcon searchLodge = new ImageIcon("serachLodgeButton.jpg");

    // HOME INTERFACE
    JPanel homeContainer = new JPanel();
    JLabel homeBackground = new JLabel();
    ImageIcon homeWallpaper = new ImageIcon("HomeWallpaper1x.jpg");
    JLabel locationBox = new JLabel();
    JLabel searchLodgeButton = new JLabel();
    
    String[] barangays = {"Kalubihan", "Parian", "Labangon", "Tisa", "Mambaling", "Guadalupe"};
    String[][] lodges = {{"Sogo" ,"TMS Lodge", "Mount View Inn", "Moon Hostel", "Marlo Lodge"}, 
    					 {"Beehive Lodge", "Bro's Lodging", "Honeymoon Inn", "Rest Lodge", "LodgeHub"},
    					 {"Seafarer's Inn", "HomiesLodge", "Queens Land", "Rest and Go", "Sleep Well Lodge"}};
    JComboBox dropdown = new JComboBox<>(barangays);
    
    // USER INTERFACE
    JPanel userProfileContainer;
    JLabel backgroundPicUserProfile,backgroundPicFavorites ; // BACKGROUND FOR background pic user profile and favorites
    ImageIcon userProfileBG = new ImageIcon("userProfileWallpaper2.jpg");
    ImageIcon favPanelBG = new ImageIcon("HomeWallpaperClear.jpg");
    JLabel userprofilePic = new JLabel();
    
    // FAVORITES INTERFACE
    JPanel favContainer = new JPanel();
    
    // DISPLAY LODGES INTERFACE
    JPanel displayLodge = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel label1 = new JLabel("SOGO");
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JLabel lodgelabel1 = new JLabel("");
    JLabel lodgelabel2 = new JLabel("");
    JLabel lodgelabel3 = new JLabel("");
    JLabel lodgelabel4 = new JLabel("");
    JLabel lodgelabel5 = new JLabel("");
    
    // Array of Labels
    JLabel arrlabel[] = {lodgelabel1,lodgelabel2,lodgelabel3,lodgelabel4,lodgelabel5};
    
    JLabel showLodgeBG = new JLabel();
    JLabel favoriteIconLabel = new JLabel();
    ImageIcon favoriteIcon = new ImageIcon("heartFavorite.png");
    ImageIcon showLodgePic = new ImageIcon("HomeWallpaperClear.jpg");
    ImageIcon img1 = new ImageIcon("showLodge.jpg");
    ImageIcon img2 = new ImageIcon("showLodge.jpg");
    ImageIcon img3 = new ImageIcon("showLodge.jpg");
    ImageIcon img4 = new ImageIcon("showLodge.jpg");
    ImageIcon img5 = new ImageIcon("showLodge.jpg");
    
    // Dimension of Right Panel
    Dimension dimension = new Dimension(1039,750);

    LodgeHubHome() {
        this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("LodgeFinder");
        this.setVisible(true);
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.add(NavBar());
        this.add(UserProfile());
        this.add(Home());       
        this.add(Favorites());
        this.add(displayLodges());
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
        navBar.setPreferredSize(new Dimension(211, 750));
        navBar.setBackground(new Color(100, 178, 255));
        navBar.setBounds(0,0,211,1025);

        // Buttons in navigation
        navBar.add(Profile);
        navBar.add(Home);
        navBar.add(Favorites);
        navBar.add(Logout);
        
        // Profile Bar
        Profile.setIcon(profile);
        Profile.setBounds(38, 26, 140, 170);
        Profile.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Profile.setHorizontalTextPosition(JButton.CENTER);
        Profile.setVerticalTextPosition(JButton.BOTTOM);
        Profile.setIconTextGap(15);
        buttonFunctionality(Profile);
       
        
        // Home Bar
        Home.setIcon(home);
        Home.setBounds(0, 206, 212, 170);
        Home.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Home.setForeground(new Color(255, 255, 255));
        Home.setHorizontalTextPosition(JButton.CENTER);
        Home.setVerticalTextPosition(JButton.BOTTOM);
        Home.setIconTextGap(15);
        buttonFunctionality(Home);
      
        
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
        buttonFunctionality(Logout);
        
        navBar.setLayout(null);

        return navBar;
    }
 
    public JPanel Home() {
        homeContainer.setLayout(null);
        homeContainer.setPreferredSize(new Dimension(dimension));
        homeContainer.setBounds(194, -50, 1039,763);
        homeContainer.add(searchLodgeButton);
        homeContainer.add(homeBackground);

        // JLabel for Home Wallpaper
        homeBackground.setBounds(0, 0, 1040, 840);
        homeBackground.setIcon(resizeImageIcon(homeWallpaper, 1039,750));
        homeBackground.add(dropdown);
        
        // DROPDOWN MENU
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
        dropdown.setFocusable(false);
        dropdown.setEditable(false);
        dropdown.setSelectedIndex(-1);
        dropdown.setSelectedItem("Select Barangay");
//        selectBarangay(dropdown);
       // AutoCompleteDecorator.decorate
        
        // BUTTON TO SEARCH LODGES
        searchLodgeButton.setIcon(searchLodge);
        searchLodgeButton.setBounds(380,610,288,69);
        searchLodgeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelButton(searchLodgeButton);

        return homeContainer;
    }
    
    public JPanel UserProfile() {
    	Border lineBorder = new LineBorder(new Color(13,77,140), 5, true);
    	backgroundPicUserProfile = new JLabel();
    	userProfileContainer = new JPanel();
    	userProfileContainer.setPreferredSize(new Dimension(dimension));
    	userProfileContainer.setBounds(194, -50, 1039,763);
    	userProfileContainer.add(userprofilePic);
    	userProfileContainer.add(backgroundPicUserProfile);
    	
    //  Ang profile sa nvabar e reuse sa User Profile
    	
    	userprofilePic.setBorder(lineBorder);
    	userprofilePic.setBackground(Color.red);
    	userprofilePic.setPreferredSize(new Dimension(150,150));
    	userprofilePic.setBounds(40, 320, 150, 150);
    	
    	
    	backgroundPicUserProfile.setBounds(16, 0, 1040, 840);
    	backgroundPicUserProfile.setIcon(resizeImageIcon(userProfileBG, 1039,750));
    	userProfileContainer.setLayout(null);
    	userProfileContainer.setVisible(false);
    	
    	
    	
    	return userProfileContainer;
    }
    
    public JPanel Favorites() {
    	backgroundPicFavorites = new JLabel();
    	favContainer.setPreferredSize(new Dimension(dimension));
    	favContainer.setBounds(180, -50, 1060,763);
    	favContainer.add(backgroundPicFavorites);
    	
    	//  Ang profile sa navbar e reuse sa User Profile
    	backgroundPicFavorites.setBounds(16, 0, 1040, 840);
    	backgroundPicFavorites.setIcon(resizeImageIcon(favPanelBG, 1039,750));
    	favContainer.setLayout(null);
    	favContainer.setVisible(false);
       
        return favContainer;
    }
    
    
    public JPanel displayLodges() {
    	displayLodge.setPreferredSize(new Dimension(dimension));
    	displayLodge.setBounds(180, -50, 1060,763);
    	displayLodge.add(panel1);
    	displayLodge.add(panel2);
    	displayLodge.add(panel3);
    	displayLodge.add(panel4);
    	displayLodge.add(panel5);
    	displayLodge.add(showLodgeBG);
    	
    	panel1.setPreferredSize(new Dimension(260,220));
    	panel1.setBackground(Color.blue);
    	panel1.setBounds(120, 200, 260,220);
    	panel1.add(label1);
    	panel1.add(favoriteIconLabel);
    	panel1.add(lodgelabel1);
    	panel1.setLayout(null);
    	
    	favoriteIconLabel.setBounds(215,130,50,50);
    	favoriteIconLabel.setIcon(favoriteIcon);
    	label1.setIcon(resizeImageIcon(img1, 260,100));
    	label1.setBounds(0, -30, 260,220);
    	lodgelabel1.setFont(new Font("Segoe UI", Font.BOLD, 20));
    	lodgelabel1.setBounds(10, -30, 160, 85);
    	
    	panel2.setPreferredSize(new Dimension(260,220));
    	panel2.setBackground(Color.red);
    	panel2.setBounds(400, 200, 260,220);
    	panel2.add(label2);
    	panel2.add(favoriteIconLabel);
    	panel2.add(lodgelabel2);
    	panel2.setLayout(null);
    	
    	favoriteIconLabel.setIcon(favoriteIcon);
    	label2.setIcon(resizeImageIcon(img2, 260,100));
    	label2.setBounds(0, -30, 260,220);
    	lodgelabel2.setFont(new Font("Segoe UI", Font.BOLD, 20));
    	lodgelabel2.setBounds(10, -30, 160, 85);
    	
    	panel3.setPreferredSize(new Dimension(260,220));
    	panel3.setBackground(Color.GREEN);
    	panel3.setBounds(680, 200, 260,220);
    	panel3.add(label3);
    	panel3.add(favoriteIconLabel);
    	panel3.add(lodgelabel3);
    	panel3.setLayout(null);
    	
    	favoriteIconLabel.setIcon(favoriteIcon);
    	label3.setIcon(resizeImageIcon(img3, 260,100));
    	label3.setBounds(0, -30, 260,220);
    	lodgelabel3.setFont(new Font("Segoe UI", Font.BOLD, 20));
    	lodgelabel3.setBounds(10, -30, 160, 85);
    	
    	panel4.setPreferredSize(new Dimension(260,220));
    	panel4.setBackground(Color.black);
    	panel4.setBounds(250, 460, 260,220);
    	panel4.add(label4);
    	panel4.add(favoriteIconLabel);
    	panel4.add(lodgelabel4);
    	panel4.setLayout(null);
    	
    	favoriteIconLabel.setIcon(favoriteIcon);
    	label4.setIcon(resizeImageIcon(img4, 260,100));
    	label4.setBounds(0, -30, 260,220);
    	lodgelabel4.setFont(new Font("Segoe UI", Font.BOLD, 20));
    	lodgelabel4.setBounds(10, -30, 160, 85);
    	
    	panel5.setPreferredSize(new Dimension(260,220));
    	panel5.setBackground(Color.magenta);
    	panel5.setBounds(530, 460, 260,220);
    	panel5.add(label5);
    	panel5.add(favoriteIconLabel);
    	panel5.add(lodgelabel5);
    	panel5.setLayout(null);
    	
    	favoriteIconLabel.setIcon(favoriteIcon);
    	label5.setIcon(resizeImageIcon(img5, 260,100));
    	label5.setBounds(0, -30, 260,220);
    	lodgelabel5.setFont(new Font("Segoe UI", Font.BOLD, 20));
    	lodgelabel5.setBounds(10, -30, 160, 85);
    	
    	showLodgeBG.setBounds(16, 0, 1040, 840);
    	showLodgeBG.setIcon(resizeImageIcon(showLodgePic,1039,750));
    	displayLodge.setLayout(null);
    	displayLodge.setVisible(false);
    	
    	return displayLodge;
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
				if(source==Logout) {
					int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "LodgeFinder", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
						dispose();
						new LodgeHubLoginFrame();
					} 
				}
				
			}
    		
    	});
    }
    
    public void jLabelButton(JLabel labelButton) {
    	labelButton.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			Object source = e.getSource();
    			if(source==labelButton) {
    				selectBarangay(dropdown);
    			}
    		}
    		
    	});
    }
    
    public void selectBarangay(JComboBox combobox) {
    	//String message = "";
    	for(int i = 0; i < barangays.length;i++) {
    		if(combobox.getSelectedItem().equals(barangays[i])) {
    			for(int j = 0; j < lodges[i].length; j++) {
    				int brngy = i;   				
    				arrlabel[j].setText(lodges[brngy][j]);
    			}
    			displayLodge.setVisible(true);
    			homeContainer.setVisible(false);
    			//JOptionPane.showMessageDialog(null, message);
    			break;
    		}
    	}
    	
    }
 
  
}
