package View.CreateWindows;

import Model.Answer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//AnswerBox este un panel ce contine 3 campuri:
    //1 - campul pentru textul raspunsului
    //2 - camputl pentru punctaj
    //3 - campul cu numarul intrebarii

//Cea mai importanta metoda a acestei clase este cea Suprascrisa in Abstract answer:
    //abstractAnswerToAnswer() returneaza o conversie in clasa Answer a unui obiect AnswerBox

public class AnswerBox extends JPanel implements AbstractAnswer {
    private JTextField answerText;
    private JTextField points;
    private JPanel pointsPanel;
    private JLabel answerNumber;
    AnswerBox(){
        super(new BorderLayout());
        answerText = new JTextField();
        points = new JTextField("");
        pointsPanel = new JPanel(new GridLayout(1,2));
        pointsPanel.add(points);
        pointsPanel.add(new JLabel("pts"));
        pointsPanel.setOpaque(false);
        answerNumber = new JLabel(" ");
        points.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Float.parseFloat(points.getText());
                }catch (IllegalArgumentException iae){
                    String s = points.getText();
                    points.setText(s.substring(s.length()-2));
                }
            }
        });



        this.add(answerNumber,BorderLayout.WEST);
        this.add(answerText,BorderLayout.CENTER);
        this.add(pointsPanel, BorderLayout.EAST);
    }
    public void setAnswerNumber(int answerNumber){
        this.answerNumber.setText(answerNumber + "");
    }

    public Answer abstractAnswerToAnswer(){
        float f;
        try {
            f = Float.parseFloat(points.getText());
        }catch(NumberFormatException nfe){
            f = 0;
        }
        return new Answer(answerText.getText(),f);
    }

    public String getAnswerText(){
        return answerText.getText();
    }
    public float getPoints(){
        try{
            return Float.parseFloat(points.getText());
        }catch(NumberFormatException nfe){
            return 0;
        }
    }
}
