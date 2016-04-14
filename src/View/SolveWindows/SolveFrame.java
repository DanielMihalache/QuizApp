package View.SolveWindows;

import Control.SolveActions.SolveNextAction;
import Control.SolveActions.SolvePreviousAction;
import Control.SolveActions.SolveSubmitButtonAction;
import Model.Question;
import Model.Quiz;
import View.Language;
import View.MainMenuWindow;
import View.StaticImages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.LinkedList;

public class SolveFrame extends JFrame{

    private JPanel buttonsPanel;
    private QuestionPanel questionPanel;
    private JPanel progresPanel;
    private JPanel topPanel;
    private JButton next;
    private JButton previous;
    private JButton submit;
    private JProgressBar progressBar;

    private int pointer;
    private int sizeOfQuiz;
    private LinkedList<Question> questions;

    private Image image;

    public SolveFrame(final MainMenuWindow parent, Quiz quiz){
        setSize(896, 504);
        setLocation(150, 80);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);              //exit confirmation
        WindowListener exitListener = new WindowAdapter() {
            @Override  public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Are You Sure to Cancel Quiz",
                        "Cancel Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    parent.setVisible(true);
                    dispose();
                }
            }
        };
        addWindowListener(exitListener);
        //set Background
        image = StaticImages.randomImg();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics graphics) {
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        });

        questions = quiz.getQuestions();

        pointer = -1;
        sizeOfQuiz = questions.size();
        questionPanel = new QuestionPanel(this,questions.get(++pointer));


        buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        progresPanel = new JPanel(new GridLayout(2,1));
        progresPanel.setOpaque(false);

        next = new JButton(Language.NEXT_BUTTON_TEXT);
        previous = new JButton(Language.PREVIOUS_BUTON_TEXT);
        submit = new JButton(Language.SUBMIT_BUTTON_TEXT);
        progressBar = new JProgressBar(0,quiz.getQuestions().size());
        submit.addActionListener(new SolveSubmitButtonAction(this,quiz));

        progresPanel.add(progressBar);
        progresPanel.add(submit);
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.add(previous, BorderLayout.WEST);
        buttonsPanel.add(next, BorderLayout.EAST);
        buttonsPanel.add(progresPanel, BorderLayout.CENTER);


        if(sizeOfQuiz == pointer+1){
            next.setEnabled(false);
        }
        previous.setEnabled(false);







        next.addActionListener(new SolveNextAction(this));
        previous.addActionListener(new SolvePreviousAction(this));
        progressBar.setValue(1);
        progressBar.setString("1/" + sizeOfQuiz);
        progressBar.setStringPainted(true);

        topPanel = new JPanel(new GridLayout(1,1));
        topPanel.add(questionPanel);
        topPanel.setOpaque(false);
        add(topPanel, BorderLayout.CENTER);
        add(buttonsPanel,BorderLayout.SOUTH);
        setVisible(true);
    }


    public void nextQuestion(){

        topPanel.remove(questionPanel);
        questionPanel = new QuestionPanel(this,questions.get(++pointer));
        if(sizeOfQuiz == pointer+1){
            next.setEnabled(false);
        }
        previous.setEnabled(true);
        topPanel.add(questionPanel);
        topPanel.revalidate();

        image = StaticImages.randomImg();
        repaint();
        progressBar.setValue(pointer + 1);
        progressBar.setString((pointer+1) + "/"  + sizeOfQuiz);

    }

    public void previousQuestion(){
        topPanel.remove(questionPanel);
        questionPanel = new QuestionPanel(this,questions.get(--pointer));
        topPanel.add(questionPanel);
        next.setEnabled(true);
        if(pointer == 0){
            previous.setEnabled(false);
        }
        topPanel.revalidate();
        image = StaticImages.randomImg();
        progressBar.setValue(pointer+1);
        progressBar.setString((pointer+1) + "/"  + sizeOfQuiz);
        repaint();

    }
    public boolean isLastQuestion(){
        return (pointer+1 == sizeOfQuiz);
    }


}
