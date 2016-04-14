package View.CreateWindows;

import View.Language;
import View.StaticImages;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageChooser extends JFileChooser{

    public ImageChooser(ImageChooserInterface parentComponent){
        super("./UserImages");
        setDialogTitle(Language.IMG_CHOOSER_TITLE);
        setFileFilter(new FileNameExtensionFilter(Language.IMG_CHOOSER_FILTER_TEXT, "jpg", "gif"));   //jpg and gif filter
        int returnVal = showOpenDialog((Component)parentComponent);
        if(returnVal == APPROVE_OPTION){
            try{
                StaticImages.IMAGE_CHOSEN = javax.imageio.ImageIO.read(new File(getSelectedFile().getAbsolutePath()));
                System.out.println("img path:" + getSelectedFile().getAbsolutePath());
                parentComponent.renewImg();
            }catch (IOException ioe){
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(new JLabel(Language.IMG_CANNOT_BE_OPEN));
            }
        }
    }








}
