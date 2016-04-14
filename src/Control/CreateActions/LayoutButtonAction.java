package Control.CreateActions;

import Model.StartApp;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Model.StartApp.createQuestionWindow;

public class LayoutButtonAction implements ActionListener {
    private     byte type;

    public LayoutButtonAction(byte type){
        this.type = type;
    }
    @Override   public void actionPerformed(ActionEvent actionEvent){
            StartApp.createQuestionWindow(type);
            StartApp.setChooseLayoutWindowVisible(false);
    }
}
