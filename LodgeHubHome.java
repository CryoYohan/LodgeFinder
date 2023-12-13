import java.awt.BorderLayout;
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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class LodgeHubHome extends JFrame {
    final int FRAME_SIZE_WIDTH = 1250;
    final int FRAME_SIZE_HEIGHT = 750;

    // NavBar at the Left Side
    JPanel navBar = new JPanel();
    JButton Profile = new JButton("Cyril John");
    JButton Home = new JButton("Home");
    JButton Favorites = new JButton("Favorites");
    JButton Logout = new CircleJButton("Logout");
    ImageIcon profile = new ImageIcon("Image/profileAvatar.png");
    ImageIcon home = new ImageIcon("Image/HomeWhite.png");
    ImageIcon homeBlue = new ImageIcon("Image/Home.png");
    ImageIcon heart = new ImageIcon("Image/heart.png");
    ImageIcon whiteHeart = new ImageIcon("Image/whiteHeart.png");
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
    JLabel titleAndQuote = new JLabel(); // TITLE and QUOTE BACKGROUND SA USER INTERFACE WHAT I MEAN SA TITLE IS KANANG NAA SA KINABABWAN
    ImageIcon titleQuote = new ImageIcon("Image/titleQuote.jpg"); // IMAGE SA TITLE AND QUOTE
    JLabel backgroundPic = new JLabel(); // BACKGROUND PICTURE WITH LOW EXPOSURE
    ImageIcon bgPic = new ImageIcon("Image/bgPic.jpg"); // IMAGE SA BACKGROUND LOW EXPO
    JPanel userName = new JPanel(); // Panel for user's name email and picture
    JPanel about = new JPanel(); // Panel for user's personal details
    JPanel booking = new JPanel(); // Panel for booking
    JPanel schedule = new JPanel(); // Panel para schedule
    
    // FAVORITES INTERFACE
    JPanel favContainer;
    JLabel favBackground = new JLabel();
    ImageIcon favBG = new ImageIcon("Image/FavBG.png");
    JLabel overFive = new JLabel();
    JLabel firstFav = new JLabel();
    JLabel secFav = new JLabel();
    JLabel thirdFav = new JLabel();
    JLabel fourthFav = new JLabel();
    JLabel fifthFav = new JLabel();
    JLabel displayName = new JLabel(); // Name sa lodge, inn or pension
    JLabel displayPic = new JLabel(); // Ari i set as icon ang picture sa lodge
    ImageIcon Pics = new ImageIcon(); // Ari i butang ang pic
    JLabel street = new JLabel(); // here is the street kung asa nga spot
    JLabel price = new JLabel(); // here is the price
    JLabel rate = new JLabel(); // here is the rate bisag wata kibaw pilay ratings (buotbuoti lng ni ya oy)
    JButton remove = new RemoveJButton("REMOVE"); // remove

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

    private ImageIcon resizeImageIcon(ImageIcon homeWallpaper2, int width, int height) {
        Image image = homeWallpaper2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public JPanel NavBar() {
        navBar.setPreferredSize(new Dimension(211, 750));
        navBar.setBackground(new Color(100, 178, 255));
        navBar.setBounds(0,0,211,750);

        // Buttons in navigation
        navBar.add(Profile);
        navBar.add(Home);
        navBar.add(Favorites);
        navBar.add(Logout);
        buttonFunctionality(Profile);
        buttonFunctionality(Home);
        buttonFunctionality(Favorites);
        
        // Profile Bar
        Profile.setIcon(profile);
        Profile.setBounds(0, 26, 212, 170);
        Profile.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Profile.setBackground(new Color(100, 178, 255));
        Profile.setForeground(new Color(13, 77, 140));
        Profile.setHorizontalTextPosition(JButton.CENTER);
        Profile.setVerticalTextPosition(JButton.BOTTOM);
        Profile.setIconTextGap(15);
        Profile.setFocusable(false);
        Profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Profile.setBorderPainted(false);
       
        
        // Home Bar
        Home.setIcon(home);
        Home.setBounds(0, 200, 212, 170);
        Home.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Home.setBackground(new Color(19, 112, 204));
        Home.setForeground(Color.WHITE);
        Home.setHorizontalTextPosition(JButton.CENTER);
        Home.setVerticalTextPosition(JButton.BOTTOM);
        Home.setIconTextGap(15);
        Home.setFocusable(false);
        Home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Home.setBorderPainted(false);
      
        
        // Favorite Bar
        Favorites.setIcon(heart);
        Favorites.setBounds(0, 375, 212, 170);
        Favorites.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Favorites.setBackground(new Color(100, 178, 255));
        Favorites.setForeground(new Color(13, 77, 140));
        Favorites.setHorizontalTextPosition(JButton.CENTER);
        Favorites.setVerticalTextPosition(JButton.BOTTOM);
        Favorites.setIconTextGap(15);
        Favorites.setFocusable(false);
        Favorites.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Favorites.setBorderPainted(false);
    
        
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
    	userProfileContainer.setPreferredSize(new Dimension(1039,750));
    	userProfileContainer.setBounds(190, 0, 1039, 750);
    	userProfileContainer.setLayout(null);
    	userProfileContainer.setVisible(false);
        userProfileContainer.add(titleAndQuote);
        userProfileContainer.add(backgroundPic);
        //TITLE AND BACKGROUND PICTURE
        titleAndQuote.setIcon(resizeImageIcon(titleQuote, 1039, 119));
        titleAndQuote.setBounds(15, 0, 1039, 119);
        backgroundPic.setIcon(resizeImageIcon(bgPic, 1039, 584));
        backgroundPic.setBounds(15,128, 1039, 584);
        backgroundPic.add(userName);
        backgroundPic.add(about);
        backgroundPic.add(booking);
        backgroundPic.add(schedule);
        //PANEL FOR USER'S NAME EMAIL AND PICTURE WITH WHITE BACKGROUND
        userName.setBounds(0, 215, 585, 124);
        userName.setBackground(Color.WHITE);
        userName.setBorder(BorderFactory.createMatteBorder(5,0,0,0, new Color(13, 77, 140))); // Creates top border
        
        //PANEL FOR USER'S PERSONAL DETAILS
        about.setBounds(0, 339, 585, 245);
        about.setBackground(new Color(13, 77, 140));

        //PANEL FOR A BOOKING
        booking.setBounds(585, 0, 454, 449);
        booking.setBackground(new Color(217, 217, 217));

        //PANEL FOR SCHEDULES
        schedule.setBounds(585, 449, 454, 135);
        schedule.setBackground(new Color(100, 178, 255));

    	
    	return userProfileContainer;
    }
    
    public JPanel Favorites() {
    	favContainer = new JPanel();
    	favContainer.setLayout(null);
    	favContainer.setPreferredSize(new Dimension(1039,750));
    	favContainer.setBounds(195, 0, 1039, 750);
    	favContainer.setVisible(false);
        favContainer.add(favBackground);

        //NAVBAR BACKGROUND


        favBackground.setIcon(favBG);
        favBackground.setBounds(0, 0, 1039, 985);
        favBackground.add(overFive); // mao ni ang mo count pila ka lodges, inn or pension iya gi favorite maximum is 5 ra 
        favBackground.add(firstFav); // First nga lodge, inn or pension nga iya gi add sa favorite
        favBackground.add(secFav); // Second favorite
        favBackground.add(thirdFav); // Third favorite
        favBackground.add(fourthFav); // Fourth favorite
        favBackground.add(fifthFav); // Fifth and the last favorite
        favBackground.add(displayName); // Name sa lodge, inn or pension
        favBackground.add(displayPic); // Picture
        favBackground.add(street); // Street kung asa dapita
        favBackground.add(price); // Presyo 
        favBackground.add(rate); // Ratings 
        favBackground.add(remove); //BUTTON PARA MA REMOVE

        overFive.setText("5/5");
        overFive.setForeground(Color.WHITE);
        overFive.setBounds(30, 210, 47, 29);
        overFive.setFont(new Font("Segoe UI", Font.BOLD, 25));

        //First favorite
        firstFav.setText("• Sogo Hotel");
        firstFav.setForeground(Color.WHITE);
        firstFav.setBounds(100, 290, 255, 45);
        firstFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        firstFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Second Favorite
        secFav.setText("• TMS Lodge");
        secFav.setForeground(Color.WHITE);
        secFav.setBounds(100, 370, 255, 45);
        secFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        secFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Third Favorite
        thirdFav.setText("• Marlo Lodge");
        thirdFav.setForeground(Color.WHITE);
        thirdFav.setBounds(100, 450, 255, 45);
        thirdFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        thirdFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Fourth Favorite
        fourthFav.setText("• Ben's Inn");
        fourthFav.setForeground(Color.WHITE);
        fourthFav.setBounds(100, 530, 255, 45);
        fourthFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        fourthFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Fifth favoriteee
        fifthFav.setText("• Peter Pension");
        fifthFav.setForeground(Color.WHITE);
        fifthFav.setBounds(100, 610, 255, 45);
        fifthFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        fifthFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Here ma display ang ge clicked nga favorite
        displayName.setText("Sogo Hotel"); // ari e set ang name 
        displayName.setForeground(Color.BLACK);
        displayName.setFont(new Font("Segoe UI", Font.BOLD, 30));
        displayName.setBounds(580, 230, 200, 43);

        // Mao ni ang code para sa picture
        displayPic.setBounds(580, 275, 400, 230); // DAPAT ANG PIC KAY FIXED ANG SIZE PARA DILI MAGUBA NYA NINDOT TAN AWON INIG SWITCH SA ANOTHER :D
        displayPic.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        //Mao ni ang label para sa street
        street.setText("Sanciangko St, Cebu City");
        street.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        street.setBounds(580, 520, 310, 23);

        //Mao ni ang label para sa priceee
        price.setText("350 per hour");
        price.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        price.setBounds(580, 570, 310, 23);

        //Mao ni ang label para sa ratings
        rate.setText("Rated: 4.5 out of 5");
        rate.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        rate.setBounds(580, 620, 310, 23);

        //Button to remove the choosen favorite
        remove.setBounds(870, 660, 146, 44);
        remove.setFont(new Font("Segoe UI", Font.BOLD, 15));
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLACK);
        remove.setFocusable(false);
       
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
                    Home.setIcon(home);
                    Home.setForeground(Color.WHITE);
                    Home.setBackground(new Color(19, 112, 204));
                    Favorites.setIcon(heart);
                    Favorites.setForeground(new Color(13, 77, 140));
                    Favorites.setBackground(new Color(100,178,255));
                    Profile.setBackground(new Color(100,178,255));
                    Profile.setForeground(new Color(13, 77, 140));
				}
				if(source==Profile) {
					userProfileContainer.setVisible(true);
					homeContainer.setVisible(false);
					favContainer.setVisible(false);
                    Profile.setForeground(Color.WHITE);
                    Profile.setBackground(new Color(19, 112, 204));
                    Favorites.setIcon(heart);
                    Favorites.setForeground(new Color(13, 77, 140));
                    Favorites.setBackground(new Color(100,178,255));
                    Home.setIcon(homeBlue);
					Home.setForeground(new Color(13, 77, 140));
                    Home.setBackground(new Color(100,178,255));
				}
				if(source==Favorites) {
					userProfileContainer.setVisible(false);
					homeContainer.setVisible(false);
                    favContainer.setVisible(true);
                    Favorites.setIcon(whiteHeart);
                    Favorites.setForeground(Color.WHITE);
                    Favorites.setBackground(new Color(19, 112, 204));
                    Home.setIcon(homeBlue);
                    Home.setForeground(new Color(13, 77, 140));
                    Home.setBackground(new Color(100,178,255));
                    Profile.setBackground(new Color(100,178,255));
				}		
			}
    		
    	});
    }
}