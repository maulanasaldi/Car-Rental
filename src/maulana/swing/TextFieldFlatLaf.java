/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulana.swing;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JTextField;
import java.awt.Font;

/**
 *
 * @author mmaul
 */
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
