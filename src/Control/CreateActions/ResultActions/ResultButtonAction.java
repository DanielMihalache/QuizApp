package Control.CreateActions.ResultActions;

import View.CreateWindows.ResultWindows.ResultButton;
import View.CreateWindows.ResultWindows.ResultPopUp;
import View.CreateWindows.ResultWindows.ResultsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultButtonAction implements ActionListener {
    private ResultButton resultButton;
    private ResultsFrame resultsFrame;

    public ResultButtonAction(ResultsFrame resultsFrame, ResultButton resultButton){
        this.resultButton = resultButton;
        this.resultsFrame = resultsFrame;
    }
    @Override    public void actionPerformed(ActionEvent actionEvent) {
        resultsFrame.setVisible(false);
        ResultPopUp resultPopUp = new ResultPopUp(resultButton,resultsFrame);
    }
}
