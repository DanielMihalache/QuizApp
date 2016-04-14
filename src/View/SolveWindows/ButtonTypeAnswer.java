package View.SolveWindows;

import Control.SolveActions.SolveButtonTypeAnswerAction;
import Control.SolveActions.SolveNextAction;
import Model.Answer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class ButtonTypeAnswer extends JButton implements AbstractAnswer {
    Answer answer;
    public ButtonTypeAnswer(QuestionPanel questionPanel, Answer answer){
        super(answer.getAnswerText());
        this.answer = answer;
        setSelected(answer.isSelected());
        if(answer.isSelected()){
            setBackground(Color.GREEN);
        }
        addActionListener(new SolveButtonTypeAnswerAction(questionPanel,answer));
    }


    @Override
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override    public void setAnswerText(String text) {
        answer.setAnswerText(text);
        setText(text);
    }
}
