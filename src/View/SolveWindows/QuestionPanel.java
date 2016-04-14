package View.SolveWindows;


import Model.Answer;
import Model.Question;
import View.CreateWindows.*;;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class QuestionPanel extends JPanel {

    Question question;

    private JPanel questionTextPanel;
    private JLabel questionTextLabel;
    private SolveFrame parent;
    private JPanel answersPanel;

    public QuestionPanel(SolveFrame parent, Question question){
        setOpaque(false);
        setLayout(new GridLayout(2, 1));            //set layout
        this.question = question;
        this.parent = parent;

        //set question Panel with questionText and questionImg (if needed)
        questionTextLabel = new JLabel(question.getQuestionText());
        questionTextPanel = new JPanel(new GridLayout(1,2));
        questionTextPanel.add(questionTextLabel);
        if(question.hasImg()){
            JLabel imgLabel = new JLabel(question.getImg());
            questionTextPanel.add(imgLabel);
        }

        answersPanel = new JPanel(new GridLayout(5,1));         //answerPanel is populated in the addAbstractAnswers method below

        questionTextPanel.setOpaque(false);
        answersPanel.setOpaque(false);

        add(questionTextPanel);
        addAbstractAnswers();
        add(answersPanel);

    }


    private void addAbstractAnswers(){
        Iterator<Answer> it = question.getAnswers().iterator();    //Answers iterator.has
        AbstractAnswer abstractAnswer;
        while(it.hasNext()){
            abstractAnswer = makeAbstractAnswerFromAnswer(it.next(),question.getQuestionType());
            answersPanel.add((Component)abstractAnswer);
        }
    }

    private AbstractAnswer makeAbstractAnswerFromAnswer(Answer answer, byte questionType){
        AbstractAnswer abstractAnswer;
        if(questionType == 2){
            abstractAnswer = new ButtonTypeAnswer(this,answer);
        }else{
            abstractAnswer = new CheckBoxAnswer(answer);
        }



        return abstractAnswer;
    }


    public void nextQuestion(){
        parent.nextQuestion();
    }
    public void unselectAllAnswers(){
        Iterator <Answer> iterator = question.getAnswers().iterator();
        while (iterator.hasNext()){
            iterator.next().setSelected(false);
        }
    }
    public boolean isLastQuestion(){
        return parent.isLastQuestion();
    }
}
