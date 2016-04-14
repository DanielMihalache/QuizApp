package View.CreateWindows;

import Model.Answer;

import javax.swing.*;
import java.awt.*;

public interface AbstractAnswer{

    abstract public Answer abstractAnswerToAnswer();
    abstract public String getAnswerText();
    abstract public float getPoints();

}
