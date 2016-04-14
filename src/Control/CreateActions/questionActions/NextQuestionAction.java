package Control.CreateActions.questionActions;

import Model.StartApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextQuestionAction implements ActionListener {
    @Override public void actionPerformed(ActionEvent actionEvent){
        StartApp.addQuestion();
    }
}
