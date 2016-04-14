package View.SolveWindows;

import Model.Result;
import Model.StartApp;
import View.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class FinalResultFrame extends JFrame {

    public FinalResultFrame(final Result result){
        super(result.getTitle());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(150, 80);
        setSize(896, 604);

        WindowListener exitListener = new WindowAdapter() {
            @Override  public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Are You Sure to Close",
                        "Close Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    StartApp.setMainMenuVisible(true);
                    dispose();
                }
            }
        };
        addWindowListener(exitListener);


        setContentPane(new JPanel(new GridLayout(3, 1)) {
            @Override
            public void paintComponent(Graphics graphics) {
                graphics.drawImage(result.getIcon().getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        });

        JLabel description = new JLabel(result.getDescription());
        description.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
        description.setForeground(Color.BLUE);

        add(Box.createHorizontalGlue());
        add(description);
        setVisible(true);

    }
}
