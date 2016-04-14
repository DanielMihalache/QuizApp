package View.SolveWindows;

import Control.SolveActions.SolveCheckBoxAction;
import Model.Answer;

import javax.swing.*;

public class CheckBoxAnswer extends JCheckBox implements AbstractAnswer {
    private  Answer answer;
    public CheckBoxAnswer(Answer answer){
        super(answer.getAnswerText(),answer.isSelected());
        setOpaque(false);
        this.answer = answer;
        addItemListener(new SolveCheckBoxAction(this));
    }

    public   Answer getAnswer(){
        return  answer;
    }
    public void setAnswer(Answer answer){
        this.answer = answer;
    }

    @Override    public void setAnswerText(String text) {
        setText(text);
    }



}
