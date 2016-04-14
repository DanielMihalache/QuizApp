package Control.CreateActions.ResultActions;

import Model.StartApp;
import View.CreateWindows.ResultWindows.ResultsFrame;
import View.Language;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResultsFinishAction implements ActionListener {
    ResultsFrame parent;
    public ResultsFinishAction(ResultsFrame parent){
        this.parent = parent;
    }
    @Override    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();

        chooser.setDialogTitle(Language.FOLDER_CHOOSER_TITLE);          //set title
        chooser.setCurrentDirectory(new java.io.File("./Quizzes"));             //Default directory
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileFilter(new FileNameExtensionFilter("Folders or QuizApp files", "QuizApp"));
        chooser.setAcceptAllFileFilterUsed(false);      //Disable  the "All files" option
        int returnVal = chooser.showOpenDialog((Component)e.getSource());
        if(returnVal == JFileChooser.APPROVE_OPTION){
            System.out.println(chooser.getSelectedFile().getAbsolutePath() + "");
            StartApp.saveQuiz(chooser.getSelectedFile().getAbsolutePath());
        }
        parent.dispose();
    }
}
