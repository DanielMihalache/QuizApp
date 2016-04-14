package Control.CreateActions.questionActions;

import Model.StartApp;
import View.CreateWindows.LayoutType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelAction implements ActionListener {
    LayoutType layoutType;
    public CancelAction(LayoutType layoutType){
        this.layoutType = layoutType;
    }
    @Override   public void actionPerformed(ActionEvent actionEvent){
        layoutType.cancelQuestion();

    }
}
