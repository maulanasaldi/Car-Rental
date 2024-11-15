package maulana.swing;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;

/**
 *
 * @author RAVEN
 */
public class ButtonActionFlatLaf extends JButton {

    public ButtonActionFlatLaf() {

        putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Button.background");
    }
}
