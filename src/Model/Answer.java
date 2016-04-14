package Model;

import java.io.Serializable;

public class Answer implements Serializable{
    private String answerText;
    private float points;
    private boolean selected;

    public Answer(){
        answerText = null;
        points = 0;
        selected = false;
    }
    public Answer(String answerText){
        this.answerText = answerText;
        points = 0;
        selected = false;
    }
    public Answer(String answerText,float points){
        this.answerText = answerText;
        this.points = points;
        selected = false;
    }

    public void setAnswerText(String answerText){
        this.answerText = answerText;
    }
    public void setPoints(float points){
        this.points = points;
    }
    public void setSelected(boolean value){
        selected = value;
    }
    public String getAnswerText(){
        return answerText;
    }
    public Float getPoints(){
        return points;
    }
    public boolean isSelected(){
        return selected;
    }

    @Override
    public boolean equals(Object answer){
        return this.answerText.equals(((Answer)answer).answerText)&&points == ((Answer) answer).points;
    }
}
