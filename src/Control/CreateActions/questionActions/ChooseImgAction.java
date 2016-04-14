package Control.CreateActions.questionActions;

import View.CreateWindows.ImageChooser;
import View.CreateWindows.ImageChooserInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseImgAction    implements ActionListener {
    private ImageChooserInterface component;
    public ChooseImgAction(ImageChooserInterface component){
        this.component = component;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ImageChooser imageChooser = new ImageChooser(component);
    }
}
