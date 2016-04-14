package Control.CreateActions.ResultActions;

import View.CreateWindows.ResultWindows.ResultButton;
import View.CreateWindows.ResultWindows.ResultPopUp;
import View.CreateWindows.ResultWindows.ResultsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OKButtonAction implements ActionListener {
    ResultsFrame resultsFrame;
    ResultPopUp resultPopUp;

    public OKButtonAction(ResultsFrame resultsFrame,ResultPopUp resultPopUp){
        this.resultPopUp = resultPopUp;
        this.resultsFrame = resultsFrame;
    }

    @Override    public void actionPerformed(ActionEvent actionEvent) {
        resultsFrame.setVisible(true);
        resultPopUp.actualizeResult();
        resultPopUp.dispose();
    }
}
