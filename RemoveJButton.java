import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class RemoveJButton extends JButton {
    private Shape shape;
    private Color defaultColor = new Color(255, 255, 255); // Default Background
    private Color pressedColor = new Color(220, 56, 56); // Red Background if pressed

    public RemoveJButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(Color.BLACK); // Set text foreground color
        setBackground(defaultColor);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor);
                setForeground(Color.WHITE);
                setText("REMOVED");
                repaint();
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

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setStroke(new BasicStroke(2)); // Set the border width to 2 pixels
        int arc = 7; // Corner radius
        int x = 1; // Adjusted to 1 pixel to make room for the border
        int y = 1; // Adjusted to 1 pixel to make room for the border
        int width = getWidth() - 3; // Adjusted to 3 pixels for both sides
        int height = getHeight() - 3; // Adjusted to 3 pixels for both top and bottom
        g2.drawRoundRect(x, y, width, height, arc, arc);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }

}
