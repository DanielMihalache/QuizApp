package Control.CreateActions.questionActions;

import View.CreateWindows.LayoutType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveAnswerAction implements ActionListener {
    LayoutType layoutType;
    public RemoveAnswerAction(LayoutType layoutType){
        this.layoutType = layoutType;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        layoutType.removeAnswer();
    }
}
