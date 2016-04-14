package Control.MainMenuAction;

import Model.Question;
import Model.Quiz;
import View.Language;
import View.MainMenuWindow;
import View.SolveWindows.SolveFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SolveAction implements ActionListener {
    MainMenuWindow parent;
    SolveFrame solveFrame;
    Quiz quiz;
    public SolveAction(MainMenuWindow parent) {
        this.parent = parent;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        JFileChooser quizChooser = new JFileChooser("./Quizzes");
        quizChooser.setFileFilter(new FileNameExtensionFilter(Language.QUIZ_CHOOSER_FILTER_TEXT,"QuizApp"));
        quizChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int valReturned = quizChooser.showOpenDialog(parent);
        if(valReturned == JFileChooser.APPROVE_OPTION){
            openQuiz(quizChooser.getSelectedFile().getAbsolutePath());
            solveFrame = new SolveFrame(parent,quiz);
            parent.setVisible(false);

        }

    }
    public void openQuiz(String path){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

            quiz = (Quiz)ois.readObject();
        }catch(IOException ioe){
            System.out.println("file cannot be opened");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Class not found exception");
        }
    }
}
