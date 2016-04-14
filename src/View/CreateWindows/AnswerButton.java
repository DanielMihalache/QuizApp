package View.CreateWindows;

import Model.Answer;
import Model.StartApp;
import View.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class AnswerDialog extends JDialog{
    JTextField answerText,points;

    JPanel textPanel,buttonPanel;

    JButton ok;
    AnswerDialog(final AnswerButton answerButton, final JFrame parentFrame){
        setSize(300,200);
        setLocation(150, 150);
        setLayout(new GridLayout(4,1));

        answerText = new JTextField(answerButton.getAnswerText());
        points = new JTextField(answerButton.getPoints() + "");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        ok = new JButton("ok");                                 //butonul ok face vizibila fereastra intrebarii,
                                                                // si seteaza datele din cele 2 campuri text pe buton
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton.setAnswerText(answerText.getText());
                float p = 0;
                try{
                    p = Float.parseFloat(points.getText());
                }catch(NumberFormatException nfe){
                    p = 0;
                }
                answerButton.setPoints(p);
                answerButton.setText(answerButton.getAnswerText() + " " + p);
                parentFrame.setVisible(true);

                dispose();
            }
        });

        textPanel = new JPanel();
        buttonPanel = new JPanel();
        textPanel.add(answerText);
        textPanel.add(points);
        add(textPanel);
        buttonPanel.add(ok);
        add(buttonPanel);
        setVisible(true);
    }
}














class AnswerButtonsAction implements ActionListener{
    JFrame parentFrame;
    AnswerButton answerButton;
    AnswerButtonsAction(AnswerButton answerButton,JFrame parentFrame){
        this.parentFrame = parentFrame;
        this.answerButton = answerButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AnswerDialog answerDialog = new AnswerDialog(answerButton,parentFrame);
        parentFrame.setVisible(false);
    }
}


public class AnswerButton extends JButton implements AbstractAnswer {

    private String answerText;
    private float points;

    public AnswerButton(JFrame parentFrame){
        answerText = Language.ANSWER_TEXT;
        points = 0;
        addActionListener(new AnswerButtonsAction(this,parentFrame));

    }

    public void setAnswerText(String answerText){
        this.answerText = answerText;
    }
    public void setPoints(float points){
        this.points = points;
    }

    @Override
    public Answer abstractAnswerToAnswer() {
        return new Answer(answerText,points);
    }

    @Override
    public String getAnswerText() {
        return answerText;
    }

    @Override
    public float getPoints() {
        return points;
    }
}
