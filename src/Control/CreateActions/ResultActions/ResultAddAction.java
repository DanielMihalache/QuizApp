package Control.CreateActions.ResultActions;


import View.CreateWindows.ResultWindows.ResultsFrame;
import View.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class MidPointDialog extends JDialog{
    MidPointDialog(final ResultsFrame parent){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3,1));
        add(new JLabel(Language.MID_POINT_LABEL));
        JPanel midPanel = new JPanel(new GridLayout(1,3));
        midPanel.add(new JLabel(ResultsFrame.knownFrom + "<"));
        final JTextField jTextField = new JTextField("X");
        midPanel.add(jTextField);
        midPanel.add(new JLabel(" < " + ResultsFrame.knownTo ));

        JPanel bottomPanel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                float from = ResultsFrame.knownFrom;
                float to =  ResultsFrame.knownTo;
                float p = (float)(from + to)/2;
                try{
                    float parse = Float.parseFloat(jTextField.getText());
                    if(parse < to && parse > from ){
                        p = parse;
                    }
                }catch (NumberFormatException nfe){
                    //do nothing
                }
                parent.newResult(p);
                parent.setEnabled(true);
                dispose();
            }
        });
        bottomPanel.add(ok);
        add(midPanel);
        add(bottomPanel);
        setVisible(true);
    }
}


public class ResultAddAction implements ActionListener {
    ResultsFrame resultsFrame;
    public ResultAddAction(ResultsFrame resultsFrame){
        this.resultsFrame = resultsFrame;
    }
    @Override    public void actionPerformed(ActionEvent actionEvent) {
        resultsFrame.setEnabled(false);
        MidPointDialog midPointDialog = new MidPointDialog(resultsFrame);
    }
}
