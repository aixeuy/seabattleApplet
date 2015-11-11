package panels.preparePanels.inventPanels;

import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Win7uX32 on 2015/7/22.
 */
public class Cb extends JRadioButton {
    int index;
    public Cb(String slow, boolean b, ButtonGroup cvs,int i) {
        super(slow,b);
        super.setBackground(null);
        cvs.add(this);
        index=i;
    }

}
