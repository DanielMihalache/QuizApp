package View.CreateWindows;

import Control.CreateActions.CancelQuizAction;
import Control.CreateActions.LayoutButtonAction;
import Control.CreateActions.ResultAction;
import Model.StartApp;
import View.Language;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChooseLayout   extends JFrame {


    private JButton layout1;
    private JButton layout2;
    private JButton layout3;

    private BufferedImage layoutImg1;
    private BufferedImage layoutImg2;
    private BufferedImage layoutImg3;

    private JPanel layoutsPanel;
    private JPanel buttonsPanel;

    private JButton cancelButton;
    private JButton resultsButton;
    public ChooseLayout(String title){
        super(title);
        initGUI();
    }

    private void initGUI(){
        setSize(896, 504);
        setLocation(170,80);
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
        layout1 = new JButton();
        layout2 = new JButton();
        layout3 = new JButton();
        try{
            layoutImg1 = javax.imageio.ImageIO.read(new File("LayoutImg1.jpg"));
            layoutImg2 = javax.imageio.ImageIO.read(new File("LayoutImg2.jpg"));
            layoutImg3 = javax.imageio.ImageIO.read(new File("LayoutImg3.jpg"));
        }catch(IOException ioe){
            System.out.println("Layout images missing!");
        }

        layout1.add(new JLabel(new ImageIcon(layoutImg1)));
        layout2.add(new JLabel(new ImageIcon(layoutImg2)));
        layout3.add(new JLabel(new ImageIcon(layoutImg3)));

        layout1.addActionListener(new LayoutButtonAction((byte) 1));
        layout2.addActionListener(new LayoutButtonAction((byte)2));
        layout3.addActionListener(new LayoutButtonAction((byte)3));

        layoutsPanel = new JPanel( new GridLayout(1, 3));
        layoutsPanel.add(layout1);
        layoutsPanel.add(layout2);
        layoutsPanel.add(layout3);

        cancelButton = new JButton(Language.CANCEL_BUTTON_TEXT);
        resultsButton = new JButton(Language.RESULTS_BUTTON_TEXT);

        cancelButton.addActionListener(new CancelQuizAction(this));
        resultsButton.addActionListener(new ResultAction(this));
        resultsButton.setEnabled(false);
        buttonsPanel = new JPanel();
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(resultsButton);

        add(layoutsPanel, BorderLayout.CENTER);
        add(buttonsPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
    public void setResultsButtonEnabled(boolean value){
        resultsButton.setEnabled(true);
    }
}
