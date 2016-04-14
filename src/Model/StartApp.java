package Model;

import View.CreateWindows.ChooseLayout;
import View.CreateWindows.QuestionWindow;
import View.CreateWindows.QuizNameDialog;
import View.Language;
import View.MainMenuWindow;
import View.StaticImages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class StartApp {
    private static Quiz quiz = null;
    private static ChooseLayout chooseLayoutWindow= null;       //only for Create
    private static QuestionWindow questionWindow = null;        //only for Create
    private static LinkedList<Result> results = null;

    private static MainMenuWindow mainMenuWindow;

    public static void createNewQuiz(){
        quiz = new Quiz();
        QuizNameDialog quizNameDialog = new QuizNameDialog();

    }
    /*
    public static void createNewResults(){
        results = new LinkedList<>();
        Result defaultResult = new Result();
        defaultResult.setFromTo(quiz.getMinScore(), quiz.getMaxScore());
        results.add(defaultResult);
    }
    */
    public static Result getQuizDefaultResult(){
        Result result = new Result();
        result.setDescription("DefaultResult");
        result.setFromTo(quiz.getMinScore(),quiz.getMaxScore());
        return result;
    }
    public static void cancelQuiz(){
        quiz = null;
        results = null;
        chooseLayoutWindow = null;
    }
    public static boolean quizIsNull(){
        return (quiz == null);
    }
    public static void setQuizName(String name){
        quiz.setName(name);
    }

    public static void createChooseLayoutWindow(String name){
        chooseLayoutWindow = new ChooseLayout(name);
    }
    public static void setChooseLayoutWindowVisible(boolean value){
        chooseLayoutWindow.setVisible(value);
    }

    public static void createQuestionWindow(byte type){
        questionWindow = new QuestionWindow(" ",type);
    }
    public static void cancelQuestionWindow(){
        questionWindow.dispose();
        questionWindow = null;
        chooseLayoutWindow.setVisible(true);
    }
    public static void addQuestion(){

        Question question = questionWindow.questionWindowToQuestion();
        if(!question.getAnswers().isEmpty()){
            quiz.addQuestion(question);
            chooseLayoutWindow.setResultsButtonEnabled(true);
            cancelQuestionWindow();
        }


    }
    public static LinkedList<Result> getResults(){
        results = new LinkedList<>();
        return results;
    }

    public static void setMainMenuVisible(boolean value){
        mainMenuWindow.setVisible(value);
    }

    public static void saveQuiz(final String path){
        quiz.setPossibleResults(results);
        try{
        if(path.endsWith("QuizApp")){
            final JDialog warning = new JDialog();    //make a warning dialog to overwrite current quiz
            JPanel textPanel = new JPanel(), buttonsPanel = new JPanel();
            textPanel.add(new JLabel(Language.OVERWRITE_WARNING_TEXT));
            JButton yesButton = new JButton(Language.YES_BUTTON);
            JButton noButton = new JButton(Language.NO_BUTTON);
            buttonsPanel.add(yesButton);
            buttonsPanel.add(noButton);

            yesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        File saveFile = new File(path);

                        StringTokenizer st = new StringTokenizer(path,"/");                 //renew quiz name
                        String name = "quizName";
                        while(st.hasMoreTokens()){
                            name = st.nextToken();
                        }
                        quiz.setName(name);

                        System.out.println("path :" + path + "\tquizname " + name);
                        ObjectOutputStream serial = new ObjectOutputStream(new FileOutputStream(saveFile));
                        serial.writeObject(quiz);
                        quiz = null;
                        serial.close();
                        chooseLayoutWindow.dispose();
                        mainMenuWindow.setVisible(true);
                        chooseLayoutWindow = null;
                        questionWindow = null;
                        warning.dispose();
                    } catch (IOException ioe) {
                        System.out.println(Language.FILE_COULD_NOT_BEEN_SAVED);
                        JPopupMenu popUp = new JPopupMenu();
                        popUp.add(new JLabel(Language.FILE_COULD_NOT_BEEN_SAVED));
                        popUp.setVisible(true);
                    }
                }
            });

            noButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    warning.dispose();
                }
            });

            warning.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            warning.setSize(400, 300);
            warning.setLayout(new GridLayout(2,1));
            warning.add(textPanel);
            warning.add(buttonsPanel);

            warning.setVisible(true);
        }else{
            File saveFile = new File(path + "/" + quiz.getName() + ".QuizApp");
            ObjectOutputStream serial = new ObjectOutputStream(new FileOutputStream(saveFile));
            serial.writeObject(quiz);
            quiz = null;
            serial.close();
            chooseLayoutWindow.dispose();
            mainMenuWindow.setVisible(true);
            chooseLayoutWindow = null;
            questionWindow = null;
        }
        }catch(IOException ioe){
            System.out.println(Language.FILE_COULD_NOT_BEEN_SAVED);
            JPopupMenu popUp = new JPopupMenu();
            popUp.add(new JLabel(Language.FILE_COULD_NOT_BEEN_SAVED));
            popUp.setVisible(true);
        }
    }




    public StartApp(){
        Language a = new Language(Language.EN);
        StaticImages staticImages = new StaticImages();
        mainMenuWindow = new MainMenuWindow(Language.MAIN_MENU_WINDOW_TITLE);
    }
}
