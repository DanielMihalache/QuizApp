package Control.SolveActions;

import View.SolveWindows.SolveFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SolvePreviousAction implements ActionListener {
    SolveFrame parent;
    public SolvePreviousAction(SolveFrame parent){
        this.parent = parent;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        parent.previousQuestion();
    }
}
