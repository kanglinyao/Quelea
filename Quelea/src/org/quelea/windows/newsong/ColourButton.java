package org.quelea.windows.newsong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import org.quelea.Utils;

/**
 * The colour button where the user selects a colour.
 * @author Michael
 */
public class ColourButton extends JButton {

    private Color colour;
    private ColourSelectionWindow selectionWindow;

    /**
     * Create and initialise the colour button.
     * @param defaultColor the default colour of the button.
     */
    public ColourButton(final Color defaultColor) {
        super("Choose colour...");
        selectionWindow = new ColourSelectionWindow(SwingUtilities.getWindowAncestor(this));
        this.colour = defaultColor;
        selectionWindow.setSelectedColour(colour);
        setIcon(new ImageIcon(Utils.getImageFromColour(colour, 16, 16)));
        selectionWindow.getConfirmButton().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                colour = selectionWindow.getSelectedColour();
                setIcon(new ImageIcon(Utils.getImageFromColour(colour, 16, 16)));
            }
        });
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                selectionWindow.setLocation((int)getLocationOnScreen().getX(), (int)getLocationOnScreen().getY());
                selectionWindow.setVisible(true);
            }
        });
    }

    /**
     * Set the icon colour of this button.
     * @param colour the colour of the button's icon.
     */
    public void setIconColour(Color colour) {
        setIcon(new ImageIcon(Utils.getImageFromColour(colour, 16, 16)));
    }

    /**
     * Get the colour selection window.
     * @return the colour selection window.
     */
    public ColourSelectionWindow getColourSelectionWindow() {
        return selectionWindow;
    }

}
