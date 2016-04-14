package Control.CreateActions;

import View.CreateWindows.ResultWindows.ResultsFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultAction implements ActionListener {
    JFrame parent;
    public ResultAction(JFrame parent){
        this.parent = parent;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        ResultsFrame resultsFrame = new ResultsFrame();
        parent.dispose();
    }
}
