package Model;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Question implements Serializable{
    private String questionText = null;
    private LinkedList<Answer> answers;
    private float score = 0;
    private float maxScore = 0;
    private float minScore = 0;

    private ImageIcon img;
    private boolean hasImg;

    private byte questionType;

    //Constructors
    public Question(byte type){
        questionType = type;
        img = null;
        hasImg = false;
        answers = new LinkedList<Answer>();
    }
    public Question(){
        answers = new LinkedList<Answer>();
    }
    public Question(String questionText){
        this.questionText = questionText;
        answers = new LinkedList<Answer>();
        hasImg = false;
        img = null;
    }
    public Question(String questionText,Answer answer){
        this.questionText = questionText;
        answers = new LinkedList<Answer>();
        this.answers.add(answer);
        float p = answer.getPoints();
        if(p > 0){
            maxScore = p;
        }else{
            minScore = p;
        }

        hasImg = false;
        img = null;
    }
    public Question(String questionText,LinkedList<Answer> answers){
        this.questionText = questionText;
        this.answers = answers;
        actualizeMaxScore(answers);
        img = null;
        hasImg = false;

    }
    //Setters
    public void setQuestionType(byte questionType){
        this.questionType = questionType;
    }
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }
    public void computeScore(Answer answerSelected){
        this.score = answerSelected.getPoints();
    }
    public void computeScore(LinkedList<Answer> answersSelected){
        Iterator<Answer> it = answersSelected.iterator();
        score = 0;
        while (it.hasNext()){
            score += it.next().getPoints();
        }
    }
    public void setImg(ImageIcon img){
        this.img = img;
        hasImg = true;
    }
    public void setAnswers(LinkedList<Answer> answers){
        this.answers = answers;
        maxScore = 0;
        actualizeMaxScore(answers);
    }
    //Getters
    public byte getQuestionType(){  return questionType;}
    public  String getQuestionText(){
        return questionText;
    }
    public  float getScore(){
        return score;
    }
    public LinkedList<Answer> getAnswers(){
        return answers;
    }
    public float getMaxScore(){
        return maxScore;
    }
    public float getMinScore() {
        return minScore;
    }
    public boolean hasImg(){
        return hasImg;
    }
    public ImageIcon getImg(){
        return img;
    }
    //Extras
    public void addAnswer(Answer answer){
        answers.add(answer);
        float p = answer.getPoints();
        if(p > 0){
            maxScore += p;
        }else{
            minScore += p;
        }
    }
    public void removeLastAnswer(){
        if(!answers.isEmpty()){
            float p = answers.peek().getPoints();
            if (p > 0) {
                maxScore -= p;
            }else{
                minScore -= p;
            }
            answers.pop();
        }

    }
    public void removeAnswer(Answer answer){
        float p = answer.getPoints();
        if(p > 0){
            maxScore -= p;
        } else{
            minScore -= p;
        }
        answers.remove(answer);
    }

    private void actualizeMaxScore(LinkedList<Answer> answers) {
        Iterator<Answer> it = answers.iterator();
        if (questionType == 3) {
            float max = Float.MIN_VALUE;
            float min = Float.MAX_VALUE;
            while (it.hasNext()){
                float p = it.next().getPoints();
                max = Math.max(p,max);
                min = Math.min(p,min);
            }
        } else {
            while (it.hasNext()) {
                float p = it.next().getPoints();
                if (p > 0) {
                    maxScore += p;
                } else {
                    minScore += p;
                }
            }
        }
    }
}
