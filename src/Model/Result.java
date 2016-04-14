package Model;

import View.Language;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Result implements Serializable {
    private String description,title;
    private float from,to;
    private ImageIcon image = null;

    public Result(){
        try{
            image =new ImageIcon(javax.imageio.ImageIO.read(new File("./Images/ChooseImage.jpg")));
        }catch(IOException ioe){
            System.out.println("ChooseImage.jpg not found in ./Images");
        }
        title = Language.TITLE;
        description = Language.RESULT_DESCRIPTION;
    };

    public void setDescription(String description){
        this.description = description;
    }
    public void setFrom(float from){
        this.from = from;
    }
    public void setTo(float to){
        this.to = to;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public void setFromTo(float from, float to){
        this.from = from;
        this.to = to;
    }
    public void setImage(ImageIcon image){
        this.image = image;
    }

    public String getDescription(){
        return description;
    }
    public ImageIcon getIcon(){
        return image;
    }
    public float getFrom(){
        return from;
    }
    public float getTo(){
        return to;
    }
    public static Result getResult(float score, LinkedList <Result> results){
        Iterator <Result> it = results.iterator();
        Result current;
        while(it.hasNext()){
            current = it.next();
            if(score > current.from && score <= current.to)
                return current;
        }
        it = results.iterator();
        float f = Float.MAX_VALUE;
        Result minR = null;
        while(it.hasNext()){
            current = it.next();
            float p = current.from;
            if(f > p){
                f = p;
                minR = current;
            }
        }
        return minR;
    }
    public String getTitle(){
        return title;
    }
}
