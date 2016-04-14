package Control.CreateActions.questionActions;

import View.CreateWindows.LayoutType;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddAnswerAction implements ActionListener {
    private LayoutType layoutType;
    public AddAnswerAction(LayoutType layoutType){
        this.layoutType = layoutType;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        layoutType.addAnswer();
    }
}
