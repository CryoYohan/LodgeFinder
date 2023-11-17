import javax.swing.*;
import java.awt.*;

public class JPanelGradient extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

		Graphics2D Color = (Graphics2D) g;
		Color.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth(), h = getHeight();
		
		Color topColor = new Color(100, 157, 109); //Top color sa gradient
		Color bottomColor = new Color(27, 44, 30); // Bottom color sa gradient

		GradientPaint gradientPaint = new GradientPaint(0, 0, topColor, w, h, bottomColor);

		Color.setPaint(gradientPaint);
		Color.fillRect(0, 0, w, h);
	}
}