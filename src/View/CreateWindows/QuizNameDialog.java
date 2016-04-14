package View.CreateWindows;

import Control.CreateActions.QuizNameDialogAction;
import Model.Quiz;
import View.Language;
import View.MainMenuWindow;

import javax.swing.*;
import java.awt.*;

public class QuizNameDialog extends JDialog{
    private JButton ok;
    private JLabel label;
    private JPanel bottomPanel;
    private JTextField inputText;
    private JPanel midPanel;
    public QuizNameDialog(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(400,300);
        setLayout(new GridLayout(3,1,10,10));
        setLocation(100,80);

        ok = new JButton("ok");
        ok.addActionListener(new QuizNameDialogAction(this));
        label = new JLabel(Language.QUIZ_DIALOG_LABEL_TEXT);
        add(label);

        inputText = new JTextField(30);
        midPanel = new JPanel();
        midPanel.add(inputText);
        add(midPanel);

        bottomPanel = new JPanel();
        bottomPanel.add(ok);
        add(bottomPanel);



        setVisible(true);
    }

    public static boolean isDialogTextValid(QuizNameDialog dialog){
        String s = dialog.inputText.getText();
        int sLength = s.length();
        if(sLength < 3 || sLength >15){
            return false;
        }
        for(int i = 0; i < sLength; i++){
            char ch = s.charAt(i);
            if(!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ' ' || ch == '_')){
                return false;
            }

        }
        return  true;
    }
    public String getInputText(){
        return inputText.getText();
    }
}
