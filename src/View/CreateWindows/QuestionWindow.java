package View.CreateWindows;


import Control.CreateActions.questionActions.*;
import Model.Question;

import View.Language;
import View.StaticImages;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;


class LayoutType1 extends  LayoutType{
    private JTextField questionText;
    protected JPanel topPanel;
    // 3 Panels
    private JPanel questionPanel;   //top panel containing a label with Question Text
    private JPanel answersPanel;    //mid panel containing a grid with answerBoxes
    private JPanel buttonsPanel;    //bottom panel containing 4 buttons

    JButton addButton,removeButton,nextButton,cancelButton;     //buttons with obvious actions, obvious!

    LinkedList <AbstractAnswer> answerBoxes;                    //List of answerBox
    LayoutType1(){

        setLayout(new GridLayout(3,1));                         //The layout is a grid with 3 lines: questionText top,
        questionText = new JTextField(Language.QUESTION_TEXT);              //answersPanel mid and buttonsPanel bottom
        questionText.setFont(new Font(Font.SERIF,Font.BOLD,18));

        answerBoxes = new LinkedList<>();
        questionPanel = new JPanel();
        topPanel = new JPanel(new GridLayout(1,2));
        topPanel.setOpaque(false);
        questionPanel.add(questionText);
        topPanel.add(questionPanel);

        answersPanel = new JPanel(new GridLayout(5,1,3,3));     //the answers are arranged in a 5x1 matrix that adds a new column every 5 lines

        buttonsPanel = new JPanel();
        //init buttons
        addButton = new JButton(Language.ADD_ANSWER_BUTTON_TEXT);
        removeButton = new JButton(Language.REMOVE_ANSWER_BUTTON_TEXT);
        removeButton.setEnabled(false);
        nextButton = new JButton(Language.NEXT_QUESTION_BUTTON_TEXT);
        nextButton.setEnabled(false);
        cancelButton = new JButton(Language.CANCEL_BUTTON_TEXT);

        //setting the actions for buttons
        addButton.addActionListener(new AddAnswerAction(this));
        removeButton.addActionListener(new RemoveAnswerAction(this));
        cancelButton.addActionListener(new CancelAction(this));
        nextButton.addActionListener(new NextQuestionAction());
        //adding the buttons in bottom panel
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(nextButton);

        questionPanel.setOpaque(false);
        answersPanel.setOpaque(false);
        buttonsPanel.setOpaque(false);

        // adding the panels

        add(topPanel);
        add(answersPanel);
        add(buttonsPanel);




        setVisible(true);
    }

    public boolean isRemoveButtonEnabled(){
        return removeButton.isEnabled();
    }
    public void setRemoveButtonEnabled(boolean value){
        removeButton.setEnabled(value);
    }

    public void addAnswer(){
        AnswerBox newAnswer = new AnswerBox();
        answerBoxes.add(newAnswer);
        answersPanel.add(newAnswer);
        removeButton.setEnabled(true);
        nextButton.setEnabled(true);
        newAnswer.setAnswerNumber(answerBoxes.size());
    }
    public void removeAnswer(){
        AbstractAnswer ans = answerBoxes.getLast();
        answerBoxes.removeLast();
        if(answerBoxes.isEmpty()){
            removeButton.setEnabled(false);
            nextButton.setEnabled(false);
        }
        answersPanel.remove((AnswerBox)ans);
        answersPanel.revalidate();
        answersPanel.repaint();

    }

    public String getQuestionText(){
        return questionText.getText();
    }
    public LinkedList<AbstractAnswer> getAbstractAnswers(){
        return answerBoxes;
    }
    public byte getType(){
        return 1;
    }

}
class LayoutType2 extends LayoutType{

    JTextField questionText;

    // 3 Panels
    JPanel questionPanel;   //top panel containing a label with Question Text
    JPanel answersPanel;    //mid panel containing a grid with answerBoxes
    JPanel buttonsPanel;    //bottom panel containing 4 buttons

    JButton addButton,removeButton,nextButton,cancelButton;     //buttons with obvious actions, obvious!
    LinkedList<AbstractAnswer> abstractAnswers;

    QuestionWindow questionWindow;                          //I need the questionWindow param to set questionWindow invisible
                                                            //in AnswerDialog
    LayoutType2(QuestionWindow questionWindow){
        setLayout(new GridLayout(3,1));
        setOpaque(false);
        questionText = new JTextField(Language.QUESTION_TEXT);
        questionText.setFont(new Font(Font.SERIF,Font.BOLD,22));
        abstractAnswers = new LinkedList<>();
        this.questionWindow = questionWindow;

        questionPanel = new JPanel();
        questionPanel.add(questionText);

        answersPanel = new JPanel(new GridLayout(5,1,3,3));

        buttonsPanel = new JPanel();
        addButton = new JButton(Language.ADD_ANSWER_BUTTON_TEXT);
        removeButton = new JButton(Language.REMOVE_ANSWER_BUTTON_TEXT);
        removeButton.setEnabled(false);
        nextButton = new JButton(Language.NEXT_QUESTION_BUTTON_TEXT);
        cancelButton = new JButton(Language.CANCEL_BUTTON_TEXT);


        addButton.addActionListener(new AddAnswerAction(this));
        removeButton.addActionListener(new RemoveAnswerAction(this));
        cancelButton.addActionListener(new CancelAction(this));
        nextButton.addActionListener(new NextQuestionAction());
        nextButton.setEnabled(false);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(nextButton);



        questionPanel.setOpaque(false);
        answersPanel.setOpaque(false);
        buttonsPanel.setOpaque(false);

        add(questionPanel);
        add(answersPanel);
        add(buttonsPanel);
        setVisible(true);



    }

    @Override
    public boolean isRemoveButtonEnabled() {
        return removeButton.isEnabled();
    }

    @Override
    public void setRemoveButtonEnabled(boolean value) {
        removeButton.setEnabled(value);
    }

    public void addAnswer(){
        AnswerButton newAnswer = new AnswerButton(questionWindow);
        abstractAnswers.add(newAnswer);
        answersPanel.add(newAnswer);
        removeButton.setEnabled(true);
        nextButton.setEnabled(true);
        answersPanel.revalidate();
        answersPanel.repaint();
    }
    public void removeAnswer(){
        AbstractAnswer ans = abstractAnswers.getLast();
        abstractAnswers.removeLast();
        if(abstractAnswers.isEmpty()){
            removeButton.setEnabled(false);
            nextButton.setEnabled(false);
        }
        answersPanel.remove((AnswerButton)ans);
        answersPanel.revalidate();
        answersPanel.repaint();

    }

    public String getQuestionText(){
        return questionText.getText();
    }

    public LinkedList<AbstractAnswer> getAbstractAnswers() {
        return abstractAnswers;
    }
    public byte getType(){
        return 2;
    }

}
class LayoutType3 extends LayoutType1 implements ImageChooserInterface{
    private ImageIcon imgIcon;
    private JButton chooseImgButton;
    private JPanel buttonPanel;
    BufferedImage bufferedImage;
    LayoutType3(){
        super();
        try{
            bufferedImage = javax.imageio.ImageIO.read(new File("./Images/ChooseImage.jpg"));
            imgIcon = new ImageIcon(bufferedImage);
            chooseImgButton = new JButton(imgIcon);
            chooseImgButton.addActionListener(new ChooseImgAction(this));
            buttonPanel = new JPanel();
            buttonPanel.setOpaque(false);
            buttonPanel.add(chooseImgButton);
            topPanel.add(buttonPanel);

        }catch(IOException ioe){
            System.out.printf("ImgNotFound");
        }
    }
    public byte getType(){
        return 3;
    }
    private BufferedImage resizeImg(BufferedImage originalSizeImg){
        BufferedImage resize = new BufferedImage(320,260,BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resize.createGraphics();
        graphics2D.drawImage(originalSizeImg,0,0,320,260,null);
        graphics2D.dispose();
        bufferedImage = resize;
        return resize;
    }
    public void setQuestionImg(){
        imgIcon = new ImageIcon (resizeImg(StaticImages.IMAGE_CHOSEN));
        chooseImgButton.setIcon(imgIcon);

    }
    public void renewImg(){
        setQuestionImg();
        topPanel.revalidate();
        topPanel.repaint();
    }

    public ImageIcon getImgIcon(){
        return imgIcon;
    }
}




public class QuestionWindow extends JFrame {
    private LayoutType layoutType;
    public static BufferedImage img;
    public QuestionWindow(String name,byte type){
        super(name);
        setSize(896, 504);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        img = StaticImages.randomImg();

        switch (type) {
            case 1:
                layoutType = new LayoutType1();
                break;
            case 2:
                layoutType = new LayoutType2(this);
                break;
            default:
                layoutType = new LayoutType3();
        }
        setContentPane(layoutType);
        setVisible(true);
    }

    /**
     *
     * @return Question() object converted from Question window
     */
    public Question questionWindowToQuestion(){

        Question question = new Question(layoutType.getQuestionText());
        AbstractAnswer abstractAnswer;
        LinkedList<AbstractAnswer> abstractAnswers = layoutType.getAbstractAnswers();
        Iterator<AbstractAnswer> it = abstractAnswers.iterator();
        while(it.hasNext()){
            abstractAnswer = it.next();
            question.addAnswer(abstractAnswer.abstractAnswerToAnswer());
        }
        byte questionType = layoutType.getType();
        question.setQuestionType(questionType);
        if(questionType == 3){
            question.setImg(((LayoutType3)layoutType).getImgIcon());
        }

        return question;
    }
}
