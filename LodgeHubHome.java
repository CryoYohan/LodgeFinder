package trashcash;
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
import java.util.Random;

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
    
    Random random = new Random();
    LodgesDataBase lodgesDatabase = new LodgesDataBase();
    RegistrationForm register = new RegistrationForm();
    
    // Registration Backend Object
    RegistrationBackend registerBackend = new RegistrationBackend();
    
    // NavBar at the Left Side
    JPanel navBar = new JPanel();
    JButton Home = new JButton("Home");
    JButton Profile;
    JButton Favorites = new JButton("Favorites");
    JButton Logout = new CircleJButton("Logout");
    ImageIcon profile = new ImageIcon("UserProfilePicture.png");
    ImageIcon home = new ImageIcon("HomeWhite.png");
    ImageIcon homeBlue = new ImageIcon("Home.png");
    ImageIcon heart = new ImageIcon("heart.png");
    ImageIcon whiteHeart = new ImageIcon("whiteHeart.png");
    ImageIcon logout = new ImageIcon("Logout.png");
    ImageIcon icon = new ImageIcon("LodgeHubIcon.png");
    ImageIcon searchLodge = new ImageIcon("serachLodgeButton.jpg");
    
    

    // HOME INTERFACE
    JPanel homeContainer = new JPanel();
    JLabel homeBackground = new JLabel();
    ImageIcon homeWallpaper = new ImageIcon("HomeWallpaper1x.jpg");
    JLabel searchLodgeButton = new JLabel();
    
   
    JComboBox dropdown = new JComboBox<>(lodgesDatabase.barangays);
    
    // USER INTERFACE
    JPanel userProfileContainer;
    JLabel backgroundPicUserProfile,backgroundPicFavorites ; // BACKGROUND FOR background pic user profile and favorites
    ImageIcon userProfileBG = new ImageIcon("userProfileWallpaper2.jpg");
    ImageIcon favPanelBG = new ImageIcon("HomeWallpaperClear.jpg");
    JLabel userprofilePic = new JLabel();
    JLabel bookinglodgeLabel = new JLabel("Empty");
    JLabel bookinglocationLabel = new JLabel("Empty");
    JLabel bookingcontactLabel = new JLabel("Empty");
    JLabel bookingCheckin = new JLabel("EmptyIn\nHello world");
    JLabel bookingCheckout = new JLabel("EmptyOut");
    JLabel bookingDisplayPic = new JLabel();
    JButton updateProfile = new JButton();
    JButton changeProfilePic = new JButton();
    ImageIcon userProfilePictureIcon;
    
    // FAVORITES INTERFACE
    JPanel favContainer = new JPanel();
    JLabel favBackground = new JLabel();
    ImageIcon favBG = new ImageIcon("favoritePanelBG.png");
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
    JButton remove = new JButton("REMOVE"); // remove
    JLabel arrFavorites[] = {firstFav, secFav, thirdFav, fourthFav, fifthFav};
    
    // DISPLAY LODGES INTERFACE
    JPanel displayLodge = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JLabel lodgelabel1 = new JLabel("");
    JLabel lodgelabel2 = new JLabel("");
    JLabel lodgelabel3 = new JLabel("");
    JLabel lodgelabel4 = new JLabel("");
    JLabel lodgelabel5 = new JLabel("");
    ImageIcon img1 = new ImageIcon("showLodge.jpg");
    ImageIcon img2 = new ImageIcon("showLodge.jpg");
    ImageIcon img3 = new ImageIcon("showLodge.jpg");
    ImageIcon img4 = new ImageIcon("showLodge.jpg");
    ImageIcon img5 = new ImageIcon("showLodge.jpg");
    JLabel rate1 = new JLabel();
	JLabel rate2 = new JLabel();
	JLabel rate3 = new JLabel();
	JLabel rate4 = new JLabel();
	JLabel rate5 = new JLabel();
	JLabel arrRateLabel[] = {rate1,rate2,rate3,rate4,rate5};
  
    // Array of LodgeLabels
    JLabel arrlodgelabel[] = {lodgelabel1,lodgelabel2,lodgelabel3,lodgelabel4,lodgelabel5};
    // Array of Lodge Image Labels
    JLabel arrimglabel[] = {label1,label2,label3,label4,label5};
    
    JButton bookingButton1 = new JButton("BOOK");
    JButton bookingButton2 = new JButton("BOOK");
    JButton bookingButton3 = new JButton("BOOK");
    JButton bookingButton4 = new JButton("BOOK");
    JButton bookingButton5 = new JButton("BOOK");
    JLabel showLodgeBG = new JLabel();
    JLabel favoriteIconLabel1 = new JLabel();
    JLabel favoriteIconLabel2 = new JLabel();
    JLabel favoriteIconLabel3 = new JLabel();
    JLabel favoriteIconLabel4 = new JLabel();
    JLabel favoriteIconLabel5 = new JLabel();
    ImageIcon favoriteIcon = new ImageIcon("heartFavorite.png");
    ImageIcon showLodgePic = new ImageIcon("HomeWallpaperClear.jpg");
   
    
    // Dimension of Right Panel
    Dimension dimension = new Dimension(1039,750);
    
    // User's Info in Profile Labels
    JLabel firstname, lastname, age, email, phonenumber, fullnameUser;
    String usrGlobal, pswdGlobal,firstnameGlobal, lastnameGlobal, ageGlobal, emailGlobal, phonenumberGlobal, filepathGlobal;
    
    int brngyindex = 0;
    
    LodgeHubHome(String usr, String pswd,String fname, String lname, String age, String phonenumber, String mail, String filepath) {
    	usrGlobal = usr;
    	pswdGlobal = pswd;
    	firstnameGlobal = fname;
    	lastnameGlobal = lname;
    	ageGlobal = age;
    	emailGlobal = mail;
    	filepathGlobal = filepath;
    	Profile = new JButton(fname);
    	firstname = new JLabel(fname);
    	lastname = new JLabel(lname);
    	this.age = new JLabel(age);
    	email = new JLabel(mail);  	
    	this.phonenumber = new JLabel(phonenumber);
    	userProfilePictureIcon = new ImageIcon(filepath);
    	fullnameUser = new JLabel(fname + " " + lname);
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
        Profile.setBounds(0, 0, 212, 200);
        Profile.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Profile.setBackground(new Color(100, 178, 255));
        Profile.setForeground(new Color(13, 77, 140));
        Profile.setHorizontalTextPosition(JButton.CENTER);
        Profile.setVerticalTextPosition(JButton.BOTTOM);
        Profile.setIconTextGap(5);
        Profile.setFocusable(false);
        Profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Profile.setBorderPainted(false);
        buttonFunctionality(Profile);
       
        
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
        buttonFunctionality(Home);
      
        
        // Favorite Bar
        Favorites.setIcon(heart);
        Favorites.setBounds(0, 370, 212, 170);
        Favorites.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Favorites.setBackground(new Color(100, 178, 255));
        Favorites.setForeground(new Color(13, 77, 140));
        Favorites.setHorizontalTextPosition(JButton.CENTER);
        Favorites.setVerticalTextPosition(JButton.BOTTOM);
        Favorites.setIconTextGap(15);
        Favorites.setFocusable(false);
        Favorites.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Favorites.setBorderPainted(false);
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
        dropdown.setSelectedIndex(-1);
        dropdown.setSelectedItem("Select Barangay");
    
        // BUTTON TO SEARCH LODGES
        searchLodgeButton.setIcon(searchLodge);
        searchLodgeButton.setBounds(380,610,288,69);
        searchLodgeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelButton(searchLodgeButton);

        return homeContainer;
    }
    
    public JPanel UserProfile() {
    	ImageIcon updateIcon = new ImageIcon("account.png");
    	ImageIcon changeIcon = new ImageIcon("camera.png");
    	JLabel changeprof = new JLabel("Change Profile Picture");
    	JLabel updateprof = new JLabel("Update Profile Details");
    	Border lineBorder = new LineBorder(new Color(13,77,140), 5, true);
    	backgroundPicUserProfile = new JLabel();
    	userProfileContainer = new JPanel();
    	userProfileContainer.setPreferredSize(new Dimension(dimension));
    	userProfileContainer.setBounds(194, -50, 1039,763);
    	userProfileContainer.add(userprofilePic);
    	userProfileContainer.add(firstname); // JLabels
    	userProfileContainer.add(lastname);
    	userProfileContainer.add(age);
    	userProfileContainer.add(email);
    	userProfileContainer.add(phonenumber);
    	userProfileContainer.add(bookinglodgeLabel);
    	userProfileContainer.add(bookinglocationLabel);
    	userProfileContainer.add(bookingcontactLabel);
    	userProfileContainer.add(bookingCheckin);
    	userProfileContainer.add(bookingCheckout);
    	userProfileContainer.add(bookingDisplayPic);
    	userProfileContainer.add(updateProfile);
    	userProfileContainer.add(changeProfilePic);
    	userProfileContainer.add(fullnameUser);
    	userProfileContainer.add(updateprof);
    	userProfileContainer.add(changeprof);
    	userProfileContainer.add(backgroundPicUserProfile);	
    	
    	// Update User Textfields
    	
    	//Update Profile Details
    	updateprof.setBounds(445,710,300,50);
    	updateprof.setForeground(Color.WHITE);
    	updateprof.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    	updateProfile.setIcon(updateIcon);
    	updateProfile.setBounds(450,670,100,50);
    	updateProfile.setFocusable(false);
    	updateProfile.setBackground(Color.WHITE);
    	updateProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	buttonFunctionality(updateProfile);
    	
    	// Change Profile Picture
    	changeprof.setBounds(445,620,300,50);
    	changeprof.setForeground(Color.WHITE);
    	changeprof.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    	changeProfilePic.setIcon(changeIcon);
    	changeProfilePic.setBounds(450,580,100,50);
    	changeProfilePic.setFocusable(false);
    	changeProfilePic.setBackground(Color.WHITE);
    	changeProfilePic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	buttonFunctionality(changeProfilePic);
    	
    	//Booking Area
    	
    	bookingDisplayPic.setBounds(600,285,475,200);
    	bookingDisplayPic.setIcon(resizeImageIcon(img1,475,200));
    	
    	bookinglodgeLabel.setForeground(Color.BLACK);
    	bookinglodgeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
    	bookinglodgeLabel.setBounds(780,240,300,50);
    	
    	bookinglocationLabel.setForeground(Color.BLACK);
    	bookinglocationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    	bookinglocationLabel.setBounds(660,520,500,50);
    	
    	bookingcontactLabel.setForeground(Color.BLACK);
    	bookingcontactLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    	bookingcontactLabel.setBounds(660,570,330,50);
    	
    	bookingCheckin.setForeground(Color.BLACK);
    	bookingCheckin.setBounds(660,690,330,50);
    	bookingCheckin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    	
    	bookingCheckout.setForeground(Color.BLACK);
    	bookingCheckout.setBounds(910,690,330,50);
    	bookingCheckout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    	
    	//About
    	fullnameUser.setBounds(230,390, 500,100);
    	fullnameUser.setFont(new Font("Sans Serif", Font.BOLD, 33));
    	
    	email.setBounds(270,460,400,50);
    	email.setFont(new Font("Sans Serif", Font.ITALIC, 20));
    	
    	firstname.setForeground(Color.WHITE);
    	firstname.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    	firstname.setBounds(40,640,200,50);
    	
    	lastname.setForeground(Color.WHITE);
    	lastname.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    	lastname.setBounds(245,640,200,50);
    	
    	age.setForeground(Color.WHITE);
    	age.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    	age.setBounds(45,720,200,50);
    	
    	phonenumber.setForeground(Color.WHITE);
    	phonenumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    	phonenumber.setBounds(245,720,200,50);
    	
    	
    	userprofilePic.setBorder(lineBorder);
    	userprofilePic.setPreferredSize(new Dimension(150,150));
    	userprofilePic.setBounds(40, 320, 150, 150);
    	userprofilePic.setIcon(resizeImageIcon(userProfilePictureIcon,150,150));
    	   	
    	backgroundPicUserProfile.setBounds(16, 0, 1040, 840);
    	backgroundPicUserProfile.setIcon(resizeImageIcon(userProfileBG, 1039,750));
    	userProfileContainer.setLayout(null);
    	userProfileContainer.setVisible(false);
    	
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
        favBackground.setBounds(0, -114, 1039, 985);
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

        overFive.setText("TOP 5 FAVORITES:");
        overFive.setForeground(Color.WHITE);
        overFive.setBounds(30, 270, 300, 29);
        overFive.setFont(new Font("Segoe UI", Font.BOLD, 25));

        //First favorite
        jLabelButton(firstFav);
        firstFav.setText("");
        firstFav.setForeground(Color.WHITE);
        firstFav.setBounds(30, 350, 450, 45);
        firstFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        firstFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Second Favorite
        jLabelButton(secFav);
        secFav.setText("");
        secFav.setForeground(Color.WHITE);
        secFav.setBounds(30, 450, 450, 45);
        secFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        secFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Third Favorite
        jLabelButton(thirdFav);
        thirdFav.setText("");
        thirdFav.setForeground(Color.WHITE);
        thirdFav.setBounds(30, 550, 450, 45);
        thirdFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        thirdFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Fourth Favorite
        jLabelButton(fourthFav);
        fourthFav.setText("");
        fourthFav.setForeground(Color.WHITE);
        fourthFav.setBounds(30, 650, 450, 45);
        fourthFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        fourthFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Fifth favorite
        jLabelButton(fifthFav);
        fifthFav.setText("");
        fifthFav.setForeground(Color.WHITE);
        fifthFav.setBounds(30, 750, 450, 45);
        fifthFav.setFont(new Font("Segoe UI", Font.BOLD, 30));
        fifthFav.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 178, 255)));

        //Here ma display ang ge clicked nga favorite
        displayName.setText("Lodge:"); // ari e set ang name 
        displayName.setForeground(Color.BLACK);
        displayName.setFont(new Font("Segoe UI", Font.BOLD, 30));
        displayName.setBounds(580, 280, 450, 43);

        // Mao ni ang code para sa picture
        displayPic.setBounds(580, 330, 400, 230); // DAPAT ANG PIC KAY FIXED ANG SIZE PARA DILI MAGUBA NYA NINDOT TAN AWON INIG SWITCH SA ANOTHER :D
        displayPic.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        //Mao ni ang label para sa street
        street.setText("Street");
        street.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        street.setBounds(580, 580, 500, 23);

        //Mao ni ang label para sa price
        price.setText("Rate");
        price.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        price.setBounds(580, 650, 310, 23);


        //Button to remove the choosen favorite
        remove.setBounds(870, 730, 146, 44);
        remove.setFont(new Font("Segoe UI", Font.BOLD, 15));
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLACK);
        remove.setFocusable(false);
       
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
    
    	bookingButton1.setVisible(false);
    	bookingButton2.setVisible(false);
    	bookingButton3.setVisible(false);
    	bookingButton4.setVisible(false);
    	bookingButton5.setVisible(false);
    	panel1.setPreferredSize(new Dimension(260,220));
    	panel1.setBackground(new Color(100, 178, 255));
    	panel1.setBounds(120, 200, 260,220);
    	panel1.add(rate1);
    	panel1.add(label1);
    	panel1.add(favoriteIconLabel1);
    	panel1.add(lodgelabel1);
    	panel1.add(bookingButton1);
    	panel1.setLayout(null);
    	
    	addToFavorites(favoriteIconLabel1, brngyindex, 0);
    	bookLodgeFunc(bookingButton1,0);
    	bookingButton1.setBounds(90,180,90,30);
    	bookingButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	bookingButton1.setBackground(Color.WHITE);
    	bookingButton1.setFocusable(false);
    	bookingButton1.setForeground(new Color(0,0,102));
    	rate1.setBounds(10,130,300,50);
    	rate1.setForeground(Color.BLACK);
    	rate1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	favoriteIconLabel1.setBounds(215,130,50,50);
    	favoriteIconLabel1.setIcon(favoriteIcon);
    	label1.setIcon(resizeImageIcon(img1, 260,100));
    	label1.setBounds(0, -30, 260,220);
    	lodgelabel1.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lodgelabel1.setForeground(new Color(0,0,102));
    	lodgelabel1.setBounds(10, -30, 230, 85);
    	
    	panel2.setPreferredSize(new Dimension(260,220));
    	panel2.setBackground(new Color(100, 178, 255));
    	panel2.setBounds(400, 200, 260,220);
    	panel2.add(rate2);
    	panel2.add(label2);
    	panel2.add(favoriteIconLabel2);
    	panel2.add(lodgelabel2);
    	panel2.add(bookingButton2);
    	panel2.setLayout(null);
    	
    	addToFavorites(favoriteIconLabel2, brngyindex, 1);
    	bookLodgeFunc(bookingButton2,1);
    	bookingButton2.setBounds(90,180,90,30);
    	bookingButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	bookingButton2.setBackground(Color.WHITE);
    	bookingButton2.setFocusable(false);
    	bookingButton2.setForeground(new Color(0,0,102));
    	rate2.setBounds(10,130,300,50);
    	rate2.setForeground(Color.BLACK);
    	rate2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	favoriteIconLabel2.setBounds(215,130,50,50);
    	favoriteIconLabel2.setIcon(favoriteIcon);
    	label2.setIcon(resizeImageIcon(img2, 260,100));
    	label2.setBounds(0, -30, 260,220);
    	lodgelabel2.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lodgelabel2.setForeground(new Color(0,0,102));
    	lodgelabel2.setBounds(10, -30, 230, 85);
    	
    	panel3.add(rate3);
    	panel3.setPreferredSize(new Dimension(260,220));
    	panel3.setBackground(new Color(100, 178, 255));
    	panel3.setBounds(680, 200, 260,220);
    	panel3.add(rate3);
    	panel3.add(label3);
    	panel3.add(favoriteIconLabel3);
    	panel3.add(lodgelabel3);
    	panel3.add(bookingButton3);
    	panel3.setLayout(null);
    	
    	addToFavorites(favoriteIconLabel3, brngyindex, 2);
    	bookLodgeFunc(bookingButton3,2);
    	bookingButton3.setBounds(90,180,90,30);
    	bookingButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	bookingButton3.setBackground(Color.WHITE);
    	bookingButton3.setFocusable(false);
    	bookingButton3.setForeground(new Color(0,0,102));
    	rate3.setBounds(10,130,300,50);
    	rate3.setForeground(Color.BLACK);
    	rate3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	favoriteIconLabel3.setBounds(215,130,50,50);
    	favoriteIconLabel3.setIcon(favoriteIcon);
    	label3.setIcon(resizeImageIcon(img3, 260,100));
    	label3.setBounds(0, -30, 260,220);
    	lodgelabel3.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lodgelabel3.setForeground(new Color(0,0,102));
    	lodgelabel3.setBounds(10, -30, 230, 85);
    	
    	panel4.add(rate4);
    	panel4.setPreferredSize(new Dimension(260,220));
    	panel4.setBackground(new Color(100, 178, 255));
    	panel4.setBounds(250, 460, 260,220);
    	panel4.add(rate4);
    	panel4.add(label4);
    	panel4.add(favoriteIconLabel4);
    	panel4.add(lodgelabel4);
    	panel4.add(bookingButton4);
    	panel4.setLayout(null);
    	
    	addToFavorites(favoriteIconLabel4, brngyindex, 3);
    	bookLodgeFunc(bookingButton4,3);
    	bookingButton4.setBounds(90,180,90,30);
    	bookingButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	bookingButton4.setBackground(Color.WHITE);
    	bookingButton4.setFocusable(false);
    	bookingButton4.setForeground(new Color(0,0,102));
    	rate4.setBounds(10,130,300,50);
    	rate4.setForeground(Color.BLACK);
    	rate4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	favoriteIconLabel4.setBounds(215,130,50,50);
    	favoriteIconLabel4.setIcon(favoriteIcon);
    	label4.setIcon(resizeImageIcon(img4, 260,100));
    	label4.setBounds(0, -30, 260,220);
    	lodgelabel4.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lodgelabel4.setForeground(new Color(0,0,102));
    	lodgelabel4.setBounds(10, -30, 230, 85);
    	
    	panel5.add(rate5);
    	panel5.setPreferredSize(new Dimension(260,220));
    	panel5.setBackground(new Color(100, 178, 255));
    	panel5.setBounds(530, 460, 260,220);
    	panel5.add(rate5);
    	panel5.add(label5);
    	panel5.add(favoriteIconLabel5);
    	panel5.add(lodgelabel5);
    	panel5.add(bookingButton5);
    	panel5.setLayout(null);
    	
    	addToFavorites(favoriteIconLabel5, brngyindex, 4);
    	bookLodgeFunc(bookingButton5,4);
    	bookingButton5.setBounds(90,180,90,30);
    	bookingButton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	bookingButton5.setBackground(Color.WHITE);
    	bookingButton5.setFocusable(false);
    	bookingButton5.setForeground(new Color(0,0,102));
    	rate5.setBounds(10,130,300,50);
    	rate5.setForeground(Color.BLACK);
    	rate5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	favoriteIconLabel5.setBounds(215,130,50,50);
    	favoriteIconLabel5.setIcon(favoriteIcon);
    	label5.setIcon(resizeImageIcon(img5, 260,100));
    	label5.setBounds(0, -30, 260,220);
    	lodgelabel5.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lodgelabel5.setForeground(new Color(0,0,102));
    	lodgelabel5.setBounds(10, -30, 230, 85);
    	
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
					bookingButton1.setVisible(false);
	                bookingButton2.setVisible(false);
	                bookingButton3.setVisible(false);
	                bookingButton4.setVisible(false);
	                bookingButton5.setVisible(false);
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
					bookingButton1.setVisible(false);
	                bookingButton2.setVisible(false);
	                bookingButton3.setVisible(false);
	                bookingButton4.setVisible(false);
	                bookingButton5.setVisible(false);
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
					favContainer.setVisible(true);
					userProfileContainer.setVisible(false);
					homeContainer.setVisible(false);
					favContainer.setVisible(true);
					bookingButton1.setVisible(false);
	                bookingButton2.setVisible(false);
	                bookingButton3.setVisible(false);
	                bookingButton4.setVisible(false);
	                bookingButton5.setVisible(false);
	                Favorites.setIcon(whiteHeart);
	                Favorites.setForeground(Color.WHITE);
	                Favorites.setBackground(new Color(19, 112, 204));
	                Home.setIcon(homeBlue);
	                Home.setForeground(new Color(13, 77, 140));
	                Home.setBackground(new Color(100,178,255));
	                Profile.setBackground(new Color(100,178,255));
				}
				if(source==Logout) {
					int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "LodgeFinder", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
						dispose();
						new LodgeHubLoginFrame();
					} 
				}
				
				if(source==updateProfile) {				
					int updateOrRegister = 2;
					registerBackend.updateData(usrGlobal,pswdGlobal,firstnameGlobal,lastnameGlobal,ageGlobal,phonenumberGlobal, emailGlobal);
					register.openRegister(updateOrRegister);
					dispose();
				}
				if(source==changeProfilePic) {
//					String path = registerBackend.changeProfilePicture(userprofilePic);
//					registerBackend.updateData(usrGlobal,pswdGlobal,firstnameGlobal,lastnameGlobal,ageGlobal,phonenumberGlobal, emailGlobal,path );
					registerBackend.changeProfilePicture(userprofilePic);
				}
				
			}
    		
    	});
    }
    
    public void bookLodgeFunc(JButton button, int index2) {
    	button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source==bookingButton1 || source==bookingButton2 || source==bookingButton3 || source==bookingButton4 || source==bookingButton5) {
					int selectedBarangayIndex = selectBarangay(dropdown);
					bookingDisplayPic.setIcon(resizeImageIcon(lodgesDatabase.lodgePictures[selectedBarangayIndex][index2],475,200));
					bookinglodgeLabel.setText(lodgesDatabase.lodges[selectedBarangayIndex][index2]);
					bookinglocationLabel.setText(lodgesDatabase.lodgesLocations[selectedBarangayIndex][index2]);
					int max = lodgesDatabase.rate.length - 1;
					int min = 0;
					int rand = 0;
					int range = max - min + 1;
					for (int i = 0; i < 5; i++) {
			            rand = (int)(Math.random() * range) + min;
					}
					bookingcontactLabel.setText(lodgesDatabase.contactnumber[rand]);
					bookingCheckin.setText("December 19, 2023");
					bookingCheckout.setText("December 20, 2023");
					JOptionPane.showMessageDialog(null, "Booked!", "LodgeFinder", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
    }
    
    public void jLabelButton(JLabel labelButton) {
    	labelButton.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			Object source = e.getSource();
    			if(source==searchLodgeButton) {
    				brngyindex = selectBarangay(dropdown);
    			}
	    		for(int i = 0; i < arrFavorites.length; i++) {
	    			if(source==arrFavorites[i]) {
	    				displayName.setText(arrFavorites[i].getText());
	    				String chosenLodge = arrFavorites[i].getText();
	    				//displayPic.setIcon(resizeImageIcon(lodgesDatabase.lodgePictures[brngyindex][i],475,230));
	    				for(int j = 0; j < lodgesDatabase.lodges.length-1;j++) {
	    					for(int k =0; k < lodgesDatabase.lodges[j].length - 1; k++) {
	    						if(chosenLodge.equals(lodgesDatabase.lodges[j][k])) {
	    							//int picIndex = lodgesDatabase.lodges[j][k].indexOf(chosenLodge);
	    							displayPic.setIcon(resizeImageIcon(lodgesDatabase.lodgePictures[j][k],475,230));
	    						}
	    					}
	    				}
	    				removeFavorites(remove, chosenLodge);
	    				break;
	    				}
	    		}
	    		

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
    }
    
    public void removeFavorites(JButton button, String chosenLodge) {
    	button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source==button) {
					for(int i = 0; i < lodgesDatabase.lodges[i].length; i++) {
						if(arrFavorites[i].getText().equals(chosenLodge)) {
							arrFavorites[i].setText("");
						}
					}
					street.setText("");
					displayName.setText("");
					displayPic.setIcon(null);
					rate.setText("");
				}
			}   		
    	});
    	
    }
    public void addToFavorites(JLabel heart, int index1, int index2 ) {
    	heart.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			Object source = e.getSource();
    			if(source == favoriteIconLabel1 || source == favoriteIconLabel2 || source == favoriteIconLabel3 || source == favoriteIconLabel4 || source == favoriteIconLabel5) {
    				int selectedBarangayIndex = selectBarangay(dropdown);
    				for(int i = arrFavorites.length - 1; i >= 0; i--) {
    					if(arrFavorites[i].getText().equals("")) {
    						arrFavorites[i].setText(lodgesDatabase.lodges[selectedBarangayIndex][index2]);
    						street.setText(lodgesDatabase.lodgesLocations[selectedBarangayIndex][index2]);
    						displayPic.setIcon(resizeImageIcon(lodgesDatabase.lodgePictures[selectedBarangayIndex][index2], 400,230));
    	                    int value = (int)(random.nextInt(lodgesDatabase.rate.length));
    	                    price.setText(lodgesDatabase.rate[value]);
    						JOptionPane.showMessageDialog(null, "Added to Favorites!", "LodgeFinder", JOptionPane.INFORMATION_MESSAGE);
    						break;
    					}
    					else if(!arrFavorites[0].getText().equals("") && !arrFavorites[1].getText().equals("") && !arrFavorites[2].getText().equals("") && !arrFavorites[3].getText().equals("") && !arrFavorites[4].getText().equals("") ) {
    						JOptionPane.showMessageDialog(null, "Favorites are full!", "LodgeFinder", JOptionPane.WARNING_MESSAGE);
    						break;
    					}
    				}
    				
    				
    				displayName.setText(lodgesDatabase.lodges[selectedBarangayIndex][index2]);
    			}
    			
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
    }
    
 // Modify the return type of selectBarangay to int
    public int selectBarangay(JComboBox combobox) {
        int brngy = -1;
        for (int i = 0; i < lodgesDatabase.barangays.length; i++) {
            if (combobox.getSelectedItem().equals(lodgesDatabase.barangays[i])) {
                brngy = i;
                for (int j = 0; j < lodgesDatabase.lodges[i].length; j++) {
                    arrlodgelabel[j].setText(lodgesDatabase.lodges[brngy][j]);
                    arrimglabel[j].setIcon(resizeImageIcon(lodgesDatabase.lodgePictures[brngy][j], 260, 100));
                    for(int k = 0; k < 5; k++) {
                    	int value = (int)(random.nextInt(lodgesDatabase.rate.length));
                        arrRateLabel[k].setText(lodgesDatabase.rate[value]);
                    }
                  
                    
                }
                displayLodge.setVisible(true);
                bookingButton1.setVisible(true);
                bookingButton2.setVisible(true);
                bookingButton3.setVisible(true);
                bookingButton4.setVisible(true);
                bookingButton5.setVisible(true);
                homeContainer.setVisible(false);
                break;
            }
        }
        return brngy;
    }
    
   
    
}
