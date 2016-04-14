package Control.MainMenuAction;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.StartApp;

public class CreateAction implements ActionListener {

    public CreateAction(){
    }
    @Override public void actionPerformed(ActionEvent actionEvent) {
        if(StartApp.quizIsNull()){
            StartApp.setMainMenuVisible(false);
            StartApp.createNewQuiz();

        }
    }
}
