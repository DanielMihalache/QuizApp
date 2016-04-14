package Control.SolveActions;

import Model.Question;
import View.SolveWindows.SolveFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SolveNextAction implements ActionListener {
    SolveFrame parent;

    public SolveNextAction(SolveFrame parent){
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.nextQuestion();
    }
}
