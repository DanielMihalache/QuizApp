package View.CreateWindows.ResultWindows;

import Control.CreateActions.ResultActions.ResultButtonAction;
import Model.Result;
import View.Language;

import javax.swing.*;


public class ResultButton extends JButton {
    private String title;
    private Result result;
    public ResultButton(ResultsFrame resultsFrame,Result result){
        title = Language.CLICK_ME;
        this.result = result;
        setText(title + " " + result.getFrom() + "->" + result.getTo());
        addActionListener(new ResultButtonAction(resultsFrame,this));
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Result getResult(){
        return result;
    }

    public void actualize(Result result){
        setTitle(title + result.getFrom() + "->" + result.getTo());
        revalidate();
        repaint();
    }
}
