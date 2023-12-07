import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LodgeHubHome extends JFrame {
    final int FRAME_SIZE_WIDTH = 1440;
    final int FRAME_SIZE_HEIGHT = 1025;

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

    // HOME INTERFACE
    JPanel homeContainer = new JPanel();
    JLabel homeBackground = new JLabel();
    ImageIcon homeWallpaper = new ImageIcon("Image/HomeWallpaper.png");
    JLabel locationBox = new JLabel();

    LodgeHubHome() {
        this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("LodgeFinder");
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(NavBar(), BorderLayout.WEST);
        this.add(Home());
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
        navBar.setLayout(null);
        navBar.setPreferredSize(new Dimension(245, 1025));
        navBar.setBackground(new Color(100, 178, 255));

        // Buttons in navigation
        navBar.add(Profile);
        navBar.add(Home);
        navBar.add(Favorites);
        navBar.add(Logout);
        // Profile Bar
        Profile.setIcon(profile);
        Profile.setBounds(56, 26, 140, 170);
        Profile.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Profile.setHorizontalTextPosition(JButton.CENTER);
        Profile.setVerticalTextPosition(JButton.BOTTOM);
        Profile.setIconTextGap(15);
        // Home Bar
        Home.setIcon(home);
        Home.setBounds(0, 206, 246, 170);
        Home.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Home.setForeground(new Color(255, 255, 255));
        Home.setHorizontalTextPosition(JButton.CENTER);
        Home.setVerticalTextPosition(JButton.BOTTOM);
        Home.setIconTextGap(15);
        // Favorite Bar
        Favorites.setIcon(heart);
        Favorites.setBounds(65, 387, 115, 170);
        Favorites.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Favorites.setHorizontalTextPosition(JButton.CENTER);
        Favorites.setVerticalTextPosition(JButton.BOTTOM);
        Favorites.setIconTextGap(15);
        // Logout button
        Logout.setIcon(logout);
        Logout.setBounds(55, 920, 130, 30);
        Logout.setFont(new Font("Segoe UI", Font.BOLD, 16));
        Logout.setForeground(new Color(255, 255, 255));
        Logout.setIconTextGap(10);

        return navBar;
    }

    public JPanel Home() {
        homeContainer.setLayout(null);
        homeContainer.setBounds(140, 245, 1195, 900);
        homeContainer.add(homeBackground);
        homeContainer.add(locationBox);

        // JLabel for Home Wallpaper
        homeBackground.setIcon(resizeImageIcon(homeWallpaper, 1180, 840));
        homeBackground.setBounds(0, 0, 1300, 840);
        homeBackground.add(locationBox);

        return homeContainer;
    }
    }
