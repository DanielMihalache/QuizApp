package Control.SolveActions;

import Model.Answer;
import View.SolveWindows.ButtonTypeAnswer;
import View.SolveWindows.QuestionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveButtonTypeAnswerAction implements ActionListener {
    Answer answer;
    QuestionPanel parentPanel;
    public SolveButtonTypeAnswerAction(QuestionPanel parentPanel, Answer answer){
        this.answer = answer;
        this.parentPanel = parentPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parentPanel.unselectAllAnswers();
        answer.setSelected(true);
        if(parentPanel.isLastQuestion()){

        }else {
            parentPanel.nextQuestion();
        }

    }
}
