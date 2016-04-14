package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Language {
    public static final byte EN = 1;
    public static final byte RO = 2;
    //MainWindowTexts
    public static String MAIN_MENU_WINDOW_TITLE;
    public static String YES_BUTTON;
    public static String NO_BUTTON;
    public static String SOLVE_BUTTON_TEXT;
    public static String CREATE_BUTTON_TEXT;
    public static String OPTIONS_BUTTON_TEXT;
    public static String QUIZ_NAME_DIALOG_TITLE;
    public static String QUIZ_DIALOG_LABEL_TEXT;
    public static String QUESTION_TEXT;
    public static String ANSWER_TEXT;
    public static String ADD_ANSWER_BUTTON_TEXT;
    public static String REMOVE_ANSWER_BUTTON_TEXT;
    public static String ADD_RESULT_BUTTON_TEXT;
    public static String REMOVE_RESULT_BUTTON_TEXT;
    public static String CANCEL_BUTTON_TEXT;
    public static String CANCEL_QUIZ_DIALOG_TEXT;
//    public static String CANCEL_QUESTION_DIALOG_TEXT;
    public static String FINISH_BUTTON_TEXT;
    public static String NEXT_QUESTION_BUTTON_TEXT;
    public static String RESULTS_BUTTON_TEXT;
    public static String FOLDER_CHOOSER_TITLE;
    public static String FILE_COULD_NOT_BEEN_SAVED;
    public static String OVERWRITE_WARNING_TEXT;
    public static String IMG_CHOOSER_TITLE;
    public static String IMG_CHOOSER_FILTER_TEXT;
    public static String IMG_CANNOT_BE_OPEN;
    public static String RESULTS_WINDOW_TITLE;
    public static String RESULTS_TOP_TEXT_LABEL;
    public static String CLICK_ME;
    public static String MID_POINT_LABEL;
    public static String RESULT_DESCRIPTION;
    public static String TITLE;
    public static String QUIZ_CHOOSER_FILTER_TEXT;
    public static String NEXT_BUTTON_TEXT;
    public static String PREVIOUS_BUTON_TEXT;
    public static String SUBMIT_BUTTON_TEXT;








    public Language(byte language){
        if (language == EN) {
            try{
                    BufferedReader in = new BufferedReader(new FileReader(new File("EN.txt")),1024);
                    readWords(in);
                    in.close();
                }catch (IOException ioe){
                    System.out.println("Language EN file not found");
                }

        } else {
                try {
                    BufferedReader in = new BufferedReader(new FileReader(new File("RO.txt")),1024);
                    readWords(in);
                    in.close();
                }catch (IOException ioe){
                    System.out.println("Language RO file not found");
                }
        }
    }

    private void readWords(BufferedReader in)throws IOException{
        Scanner sc = new Scanner(in);

        MAIN_MENU_WINDOW_TITLE = sc.nextLine();
        YES_BUTTON = sc.nextLine();
        NO_BUTTON = sc.nextLine();
        SOLVE_BUTTON_TEXT = sc.nextLine();
        CREATE_BUTTON_TEXT = sc.nextLine();
        OPTIONS_BUTTON_TEXT = sc.nextLine();
        QUIZ_NAME_DIALOG_TITLE = sc.nextLine();
        QUIZ_DIALOG_LABEL_TEXT = sc.nextLine();
        QUESTION_TEXT = sc.nextLine();
        ANSWER_TEXT = sc.nextLine();
        ADD_ANSWER_BUTTON_TEXT = sc.nextLine();
        REMOVE_ANSWER_BUTTON_TEXT = sc.nextLine();
        ADD_RESULT_BUTTON_TEXT = sc.nextLine();
        REMOVE_RESULT_BUTTON_TEXT = sc.nextLine();
        CANCEL_BUTTON_TEXT = sc.nextLine();
        CANCEL_QUIZ_DIALOG_TEXT = sc.nextLine();
        FINISH_BUTTON_TEXT = sc.nextLine();
        NEXT_QUESTION_BUTTON_TEXT = sc.nextLine();
        RESULTS_BUTTON_TEXT = sc.nextLine();
        FOLDER_CHOOSER_TITLE = sc.nextLine();
        FILE_COULD_NOT_BEEN_SAVED = sc.nextLine();
        OVERWRITE_WARNING_TEXT = sc.nextLine();
        IMG_CHOOSER_FILTER_TEXT = sc.nextLine();
        IMG_CHOOSER_TITLE = sc.nextLine();
        IMG_CANNOT_BE_OPEN = sc.nextLine();
        RESULTS_WINDOW_TITLE = sc.nextLine();
        RESULTS_TOP_TEXT_LABEL = sc.nextLine();
        CLICK_ME = sc.nextLine();
        MID_POINT_LABEL = sc.nextLine();
        RESULT_DESCRIPTION = sc.nextLine();
        TITLE = sc.nextLine();
        QUIZ_CHOOSER_FILTER_TEXT = sc.nextLine();
        NEXT_BUTTON_TEXT = sc.nextLine();
        PREVIOUS_BUTON_TEXT = sc.nextLine();
        SUBMIT_BUTTON_TEXT = sc.nextLine();

    }

}
