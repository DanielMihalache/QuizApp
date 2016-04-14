package Control.CreateActions.ResultActions;

import View.CreateWindows.ResultWindows.ResultsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultRemoveAction implements ActionListener {
    ResultsFrame parent;
    public ResultRemoveAction(ResultsFrame parent){
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        parent.removeLastResult();
    }
}
