import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;

public class BasicComboBoxUI extends javax.swing.plaf.basic.BasicComboBoxUI {
    public static ComboBoxUI createUI(JComponent c) {
        return new BasicComboBoxUI();
    }

    @Override
    protected JButton createArrowButton() {
        JButton arrowButton = new JButton();
        arrowButton.setIcon(new ImageIcon("Image/DropdownIcon.png"));
        arrowButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        arrowButton.setBackground(Color.WHITE);
        return arrowButton;
    }
}