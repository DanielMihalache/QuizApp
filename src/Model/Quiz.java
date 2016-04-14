package Model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;


public class Quiz implements Serializable{

    private LinkedList<Question> questions;
    private LinkedList<Result> possibleResults;
    private float score;
    private float maxScore;
    private float minScore;
    private String name;

    //Constructors              --They initialize score and maxScore with 0
    public Quiz(){
        score = 0;
        maxScore = 0;
        minScore = 0;
        questions = new LinkedList<Question>();
        possibleResults = new LinkedList<>();
        name = null;
    }
    public Quiz(String name){
        this.name = name;
    }
    public Quiz(LinkedList<Question> questions){
        this.questions = questions;
        actualizeMaxScore(questions);
    }
    //Setters                   --The obvious setSomething functions
    public void setName(String name){
        this.name = name;
    }
    public void setQuestions(LinkedList<Question> questions){
        maxScore = minScore = 0;
        this.questions = questions;
        actualizeMaxScore(questions);
    }
    public void setPossibleResults(LinkedList<Result> possibleResults){
        this.possibleResults = possibleResults;
    }
    public void computeScore(){
        Iterator<Question> it = this.questions.iterator();
        score = 0;
        while (it.hasNext()){
            score += it.next().getScore();
        }
    }           //The score is not set from the outside; It is computed fom the data within the Question list;

    //Getters                   --The obvious getSomething functions
    public float getScore(){
        return score;
    }
    public float getMaxScore(){
        return maxScore;
    }
    public float getMinScore(){
        return minScore;
    }
    public LinkedList<Question> getQuestions (){
        return questions;
    }
    public String getName(){
        return name;
    }
    public LinkedList<Result> getPossibleResults(){
        return possibleResults;
    }
    //Extras
    public void addQuestion(Question question){
        questions.add(question);
        maxScore += question.getMaxScore();
        minScore += question.getMinScore();
    }
    public void removeLastQuestion(){
        maxScore -= questions.peek().getMaxScore();
        questions.pop();
    }
    public void removeQuestion(Question question){
        maxScore -= question.getMaxScore();
        questions.remove(question);
    }

    private void actualizeMaxScore(LinkedList<Question> questions){
        Iterator<Question> it = questions.iterator();
        while(it.hasNext()){
            maxScore +=it.next().getMaxScore();
        }
    }
    public Result getResult(){
        computeScore();
        return Result.getResult(score,possibleResults);
    }
}
