package Control.CreateActions;

import Model.StartApp;
import View.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// Cancel dialog Window with a Label and 2 Buttons : Yes and No
class CancelDialog extends JDialog{
    CancelDialog(final JFrame parent){
        setLocation(150, 150);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300,220);
        // Text Label in a separate Pannel
        JPanel labelPanel = new JPanel();
        labelPanel.add(new JLabel(Language.CANCEL_QUIZ_DIALOG_TEXT));

        //Yes and no buttons in a separate panel
        JPanel buttonsPanel = new JPanel();

        //Yes button
        JButton yesButton = new JButton(Language.YES_BUTTON);
        // YesAction cancels the quiz and sets main menu visible
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartApp.setMainMenuVisible(true);
                StartApp.cancelQuiz();
                dispose();
                parent.dispose();
            }
        });
        buttonsPanel.add(yesButton);

        //No button - simply dispose CancelDialog window and make ChooseLayoutWindow Visible
        JButton noButton = new JButton(Language.NO_BUTTON);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                parent.setVisible(true);
            }
        });
        buttonsPanel.add(noButton);
        setLayout(new GridLayout(2, 1));
        add(labelPanel);
        add(buttonsPanel);
        setVisible(true);
    }

}




//Opens a Cancel Dialog
public class CancelQuizAction implements ActionListener {
    JFrame parent;
    public CancelQuizAction(JFrame parent){
        this.parent = parent;
    }
    @Override public void actionPerformed(ActionEvent actionEvent){
        CancelDialog cancelDialog = new CancelDialog(parent);
        parent.setVisible(false);
    }
}
