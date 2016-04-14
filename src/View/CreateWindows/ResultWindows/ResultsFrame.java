package View.CreateWindows.ResultWindows;



import Control.CreateActions.CancelQuizAction;

import Control.CreateActions.ResultActions.ResultAddAction;
import Control.CreateActions.ResultActions.ResultRemoveAction;
import Control.CreateActions.ResultActions.ResultsFinishAction;
import Model.Result;
import Model.StartApp;
import View.Language;
import View.StaticImages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ResultsFrame extends JFrame  {
    private ImageIcon icon;
    private JLabel topTextLabel;
    private JButton cancelButton, addResult, removeResult, finishButton;

    private JPanel mainPanel,topPanel,midPanel,bottomPanel,buttonsPanel;

    private ResultButton defaultResultBotton;
    private Result defaultResult;

    private LinkedList<Result> results;
    private LinkedList<ResultButton> resultButtons;

    public static float knownFrom,knownTo;

    public ResultsFrame(){
        super(Language.RESULTS_WINDOW_TITLE);
        setSize(896,504);
        setLocation(150, 80);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter() {
            @Override  public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Are You Sure to Cancel Quiz",
                        "Cancel Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    StartApp.setMainMenuVisible(true);
                    StartApp.cancelQuiz();
                    dispose();
                }
            }
        };
        addWindowListener(exitListener);
        final BufferedImage backGImg = StaticImages.randomImg();

        results = StartApp.getResults();
        resultButtons = new LinkedList<>();

        mainPanel = new JPanel(new GridLayout(3,1)){
            @Override   public void paintComponent(Graphics graphics){
                graphics.drawImage(backGImg,0,0,getWidth(),getHeight(),null);
            }
        };


        topPanel = new JPanel();
        topPanel.setOpaque(false);
        midPanel = new JPanel(new GridLayout(3,3,5,5));
        midPanel.setOpaque(false);
        bottomPanel = new JPanel(new GridLayout(3,1));
        bottomPanel.setOpaque(false);
        buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);

        topTextLabel = new JLabel(Language.RESULTS_TOP_TEXT_LABEL);
        topPanel.add(topTextLabel);

        cancelButton = new JButton(Language.CANCEL_BUTTON_TEXT);
        addResult = new JButton(Language.ADD_RESULT_BUTTON_TEXT);
        removeResult = new JButton(Language.REMOVE_RESULT_BUTTON_TEXT);
        removeResult.setEnabled(false);
        finishButton = new JButton(Language.FINISH_BUTTON_TEXT);

        cancelButton.addActionListener(new CancelQuizAction(this));
        addResult.addActionListener(new ResultAddAction(this));
        removeResult.addActionListener(new ResultRemoveAction(this));
        finishButton.addActionListener(new ResultsFinishAction(this));

        defaultResult = StartApp.getQuizDefaultResult();
        defaultResultBotton = new ResultButton(this,defaultResult);

        knownFrom = defaultResult.getFrom();
        knownTo = defaultResult.getTo();

        results.add(defaultResult);
        midPanel.add(defaultResultBotton);




        buttonsPanel.add(cancelButton);
        buttonsPanel.add(addResult);
        buttonsPanel.add(removeResult);
        buttonsPanel.add(finishButton);


        bottomPanel.add(buttonsPanel);
        mainPanel.add(topPanel);
        mainPanel.add(midPanel);
        mainPanel.add(bottomPanel);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public void newResult(float midPoint1){
        float min = knownFrom;
        float max = knownTo;
        float midPoint = midPoint1;
        if(!(midPoint >= min && midPoint < max )){
            midPoint = (float)(min+max)/2;
        }

        Result newRes = new Result();
        newRes.setFromTo(min,midPoint);
        results.getLast().setFrom(midPoint);
        results.add(newRes);
        knownTo = midPoint;
        ResultButton newResButton = new ResultButton(this,newRes);
        resultButtons.add(newResButton);
        midPanel.add(newResButton);
        removeResult.setEnabled(true);
        midPanel.revalidate();
        midPanel.repaint();
    }

    public void removeLastResult(){
        Result newRes = results.getLast();
        results.removeLast();

        knownTo = results.getLast().getTo();
        results.getLast().setFrom(newRes.getFrom());
        newRes = null;
        midPanel.remove(resultButtons.getLast());
        resultButtons.removeLast();
        if(resultButtons.isEmpty()){
            removeResult.setEnabled(false);
        }
        revalidate();
        repaint();
    }

}
