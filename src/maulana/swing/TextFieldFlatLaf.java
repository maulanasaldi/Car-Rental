package maulana.swing;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JTextField;

public class TextFieldFlatLaf extends JTextField {

    public TextFieldFlatLaf() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"                
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,10,5,20;"
                + "background:$TextField.background");
        setFont(getFont().deriveFont(14f));
    }                               
}
