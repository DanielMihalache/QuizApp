package Control.SolveActions;

import Model.Quiz;
import View.SolveWindows.FinalResultFrame;
import View.SolveWindows.SolveFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SolveSubmitButtonAction implements ActionListener {
    Quiz quiz;
    SolveFrame parentFrame;
    public SolveSubmitButtonAction(SolveFrame parentFrame,Quiz quiz){
        this.parentFrame = parentFrame;
        this.quiz = quiz;
    }

    @Override    public void actionPerformed(ActionEvent e) {
        parentFrame.dispose();
        FinalResultFrame finalResult = new FinalResultFrame(quiz.getResult());

    }
}
