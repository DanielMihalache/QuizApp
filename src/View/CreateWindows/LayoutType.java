package View.CreateWindows;

import Model.StartApp;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public abstract class LayoutType extends JPanel {

    abstract public boolean isRemoveButtonEnabled();
    abstract public void setRemoveButtonEnabled(boolean value);
    abstract public void addAnswer();
    abstract public void removeAnswer();

    abstract public String getQuestionText();
    abstract public LinkedList<AbstractAnswer> getAbstractAnswers();


    public void cancelQuestion(){
        StartApp.cancelQuestionWindow();
    }


    abstract public byte getType();


    @Override   public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        graphics.drawImage(QuestionWindow.img,0,0,getWidth(),getHeight(),null);

        setOpaque(true);
        System.out.println("new Layout");
    }
}
