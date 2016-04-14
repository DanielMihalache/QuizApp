package View.CreateWindows.ResultWindows;

import Control.CreateActions.ResultActions.OKButtonAction;
import Control.CreateActions.questionActions.ChooseImgAction;
import Model.Result;
import View.CreateWindows.ImageChooserInterface;
import View.Language;
import View.StaticImages;

import javax.swing.*;
import java.awt.*;

public class ResultPopUp extends JFrame implements ImageChooserInterface{
    private Image image = null;
    private JButton addImg;
    private JTextArea description;
    private JTextField title;
    private Result result;
    JPanel midPanel;
    public ResultPopUp(ResultButton resultButton,ResultsFrame resultsFrame){
        super(resultButton.getResult().getTitle());
        setSize(896, 504);
        setLocationByPlatform(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setContentPane(new JPanel(new GridLayout(3,1)){
            @Override public void paintComponent(Graphics graphics){
                graphics.drawImage(image,0,0,getWidth(),getHeight(),null);
            }
        });



        result = resultButton.getResult();

        title = new JTextField(result.getTitle());          //title=resultTitle

        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        titlePanel.setOpaque(false);
        add(titlePanel);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setOpaque(false);

        midPanel = new JPanel(new GridLayout(2,1,5,5));
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);


        midPanel.setOpaque(false);



        description = new JTextArea(result.getDescription());               //description = result.getDescription;
        description.setOpaque(false);
        addImg = new JButton(Language.IMG_CHOOSER_TITLE);
        addImg.addActionListener(new ChooseImgAction(this));

        image = result.getIcon().getImage();
        midPanel.add(descriptionPanel);
        descriptionPanel.add(description);
        buttonsPanel.add(addImg);

        JButton ok = new JButton("ok");
        ok.addActionListener(new OKButtonAction(resultsFrame,this));
        buttonsPanel.add(ok);
        add(midPanel);
        add(buttonsPanel);
        setVisible(true);
    }

    public void actualizeResult(){
        result.setDescription(description.getText());
        result.setTitle(title.getText());
        result.setImage(new ImageIcon(image));
    }


    @Override
    public void renewImg() {
        image = StaticImages.IMAGE_CHOSEN;
        repaint();
    }
}
