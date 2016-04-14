package View;


import Control.MainMenuAction.CreateAction;
import Control.MainMenuAction.SolveAction;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenuWindow extends JFrame {
    //images for backGround and logo
    private BufferedImage backGroundImg;
    private BufferedImage logoImg;
    private JLabel logoLabel;       //Label to contain logo img

    //buttons
    private JButton create;
    private JButton solve;
    private JButton options;

    //Two panels; top panel contains logo, horizontal glue, and buttons panel
    private JPanel buttonsPanel;
    private JPanel topPanel;



    public MainMenuWindow(String title){
        super(title);
        initGUI();
    }
    private void initGUI(){
        //Setting the characteristics of the MainMenuWindow
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        setSize(896,504);
        setLocation(150,80);



        //Setting background img
        try{
            backGroundImg = javax.imageio.ImageIO.read(new File("MenuBackGround.jpg"));
            setContentPane(new JPanel(new GridLayout(3,1)){
                @Override   public void paintComponent(Graphics graphics){
                    graphics.drawImage(backGroundImg,0,0,getWidth(),getHeight(),null);
                }
            });
        }catch(IOException ioe){
            System.out.println("Background image not found!");
        }

        //Setting logo img
        try{
            logoImg = javax.imageio.ImageIO.read(new File("QuizAppLogo.jpg"));
            logoLabel = new JLabel(new ImageIcon(logoImg));
        }catch (IOException ioe){
            System.out.println("Logo img not found!");
        }

        //Setting-up the buttons
        solve = new JButton(Language.SOLVE_BUTTON_TEXT);
        solve.addActionListener(new SolveAction(this));

        create = new JButton(Language.CREATE_BUTTON_TEXT);
        create.addActionListener(new CreateAction());

        options = new JButton(Language.OPTIONS_BUTTON_TEXT);
        options.setEnabled(false);


        //Joining them all together
        buttonsPanel = new JPanel(new GridLayout(3,1));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(solve);
        buttonsPanel.add(create);
        //buttonsPanel.add(options);

        topPanel = new JPanel(new GridLayout(1,3));
        topPanel.add(logoLabel);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(buttonsPanel);
        topPanel.setOpaque(false);



        add(topPanel);
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        setVisible(true);
    }


}
