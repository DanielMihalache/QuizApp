package View.SolveWindows;
import Model.Answer;

import java.awt.*;


public interface AbstractAnswer extends MenuContainer {

    public void setAnswer(Answer answer);
    public Answer getAnswer();
    public void setAnswerText(String text);


}
