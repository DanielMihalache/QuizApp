package Control.SolveActions;

import View.SolveWindows.CheckBoxAnswer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class SolveCheckBoxAction implements ItemListener{
    private CheckBoxAnswer checkBoxAnswer;

    public SolveCheckBoxAction(CheckBoxAnswer checkBoxAnswer){
        this.checkBoxAnswer = checkBoxAnswer;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        boolean sel = !checkBoxAnswer.getAnswer().isSelected();
        checkBoxAnswer.getAnswer().setSelected(sel);
    }
}
