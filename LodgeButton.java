import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class LodgeButton extends JButton {
	
    public LodgeButton() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorderPainted(false);
        setOpaque(false);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(0)); // Set the border width to 2 pixels
        int arc = 5; // Corner radius
        int x = 0; // Adjusted to 1 pixel to make room for the border
        int y = 0; // Adjusted to 1 pixel to make room for the border
        int width = getWidth() - 0; // Adjusted to 3 pixels for both sides
        int height = getHeight() - 0; // Adjusted to 3 pixels for both top and bottom
        g2.drawRoundRect(x, y, width, height, arc, arc);
    }
	
}