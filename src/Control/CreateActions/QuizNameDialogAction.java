package Control.CreateActions;
import Model.StartApp;
import View.CreateWindows.QuizNameDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizNameDialogAction implements ActionListener {
    private QuizNameDialog quizNameDialog;
    public QuizNameDialogAction(QuizNameDialog quizNameDialog){
        this.quizNameDialog = quizNameDialog;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        if(QuizNameDialog.isDialogTextValid(quizNameDialog)){
            String name = quizNameDialog.getInputText();
            StartApp.createChooseLayoutWindow(name);
            StartApp.setQuizName(name);
            quizNameDialog.dispose();
        }else {
            Toolkit.getDefaultToolkit().beep();

        }
    }
}
